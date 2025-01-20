package org.dev.posapi.application.service;

import org.dev.posapi.application.dto.request.CreateSaleItemRequest;
import org.dev.posapi.application.dto.request.CreateSaleRequest;
import org.dev.posapi.application.dto.request.UpdateSaleRequest;
import org.dev.posapi.application.port.in.ProductUseCase;
import org.dev.posapi.application.port.in.SaleItemUseCase;
import org.dev.posapi.application.port.in.SaleUseCase;
import org.dev.posapi.application.port.out.SaleItemRepository;
import org.dev.posapi.application.port.out.SaleRepository;
import org.dev.posapi.domain.model.ProductEntity;
import org.dev.posapi.domain.model.SaleEntity;
import org.dev.posapi.domain.model.SaleItemEntity;
import org.dev.posapi.domain.model.UserEntity;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class SaleService implements SaleUseCase {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    ProductUseCase productUseCase;

    @Autowired
    SaleItemUseCase saleItemUseCase;
    @Autowired
    private SaleItemRepository saleItemRepository;

    @Override
    public BaseResponse createSale(CreateSaleRequest request) {
        UserEntity user = new UserEntity();
        user.setId(Long.valueOf(1));
        user.setUsername("mauricio_cruz");
        user.setPassword("123");
        user.setRole(UserEntity.Role.cashier);

        Long[] products = request.getProducts();

        Map<Long, Long> productQuatities = new HashMap<>();

        for (Long productId : products) {
            productQuatities.put(Long.valueOf(productId), productQuatities.getOrDefault(productId, 0L) + 1);
        }

        double total = 0;

        SaleEntity sale = new SaleEntity();
        sale.setUser(user);
        sale.setTotal(total);

        SaleEntity savedSale = saleRepository.save(sale);
        List<SaleItemEntity> saleItems = new ArrayList<>();

        for (Map.Entry<Long, Long> entry : productQuatities.entrySet()) {
            Long productId = entry.getKey();
            Long quantity = entry.getValue();
            BaseResponse response = productUseCase.getProductById(productId);

            ProductEntity product = (ProductEntity) response.getData();

            if (product != null) {
                double subtotal = product.getPrice() * quantity;
                total += subtotal;

                SaleItemEntity saleItem = new SaleItemEntity();
                saleItem.setSale(sale);
                saleItem.setProduct(product);
                saleItem.setQuantity(Math.toIntExact(quantity));
                saleItem.setUnitPrice(product.getPrice());
                saleItem.setSubtotal(subtotal);

                productUseCase.saleProduct(productId, Math.toIntExact(quantity));

                saleItemRepository.save(saleItem);
                saleItems.add(saleItem);
            }
        }

        sale.setTotal(total);
        saleRepository.save(sale);



        return BaseResponse.builder()
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("Sale created successfully")
                .success(true)
                .data(savedSale)
                .build();
    }

    @Override
    public BaseResponse getSales() {
        return null;
    }

    @Override
    public BaseResponse getSaleById(Long id) {
        return null;
    }

    @Override
    public BaseResponse updateSale(Long id, UpdateSaleRequest request) {
        return null;
    }

    @Override
    public BaseResponse deleteSale(Long id) {
        return null;
    }
}
