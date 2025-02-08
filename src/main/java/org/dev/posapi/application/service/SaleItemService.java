package org.dev.posapi.application.service;

import org.dev.posapi.application.dto.request.CreateSaleItemRequest;
import org.dev.posapi.application.port.in.SaleItemUseCase;
import org.dev.posapi.application.port.out.SaleItemRepository;
import org.dev.posapi.domain.model.SaleItemEntity;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class SaleItemService implements SaleItemUseCase {
    @Autowired
    private SaleItemRepository saleItemRepository;

    @Override
    public SaleItemEntity createSaleItem(CreateSaleItemRequest request) {
        SaleItemEntity saleItem = new SaleItemEntity();
        saleItem.setSale(request.getSale());
        saleItem.setProduct(request.getProduct());
        saleItem.setQuantity(request.getQuantity());
        saleItem.setUnitPrice(request.getUnitPrice());
        saleItem.setSubtotal(request.getSubtotal());

        return saleItemRepository.save(saleItem);
    }

    @Override
    public BaseResponse getSalesByDates(String startDate, String endDate) throws ParseException {
        return saleItemRepository.getSalesByDates(startDate, endDate);
    }

    @Override
    public BaseResponse getBestSellingProducts() {
        return saleItemRepository.getBestSellingProducts();
    }

    @Override
    public BaseResponse getSalesByProduct() {
        return null;
    }
}
