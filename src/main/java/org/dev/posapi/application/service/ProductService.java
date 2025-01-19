package org.dev.posapi.application.service;

import org.dev.posapi.application.dto.request.CreateProductRequest;
import org.dev.posapi.application.port.in.ProductUseCase;
import org.dev.posapi.application.port.out.ProductRepository;
import org.dev.posapi.domain.model.ProductEntity;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ProductService implements ProductUseCase {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public BaseResponse createProduct(CreateProductRequest request) {
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        ProductEntity createProduct = productRepository.save(product);

        return BaseResponse.builder()
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("Product created successfully")
                .success(true)
                .data(createProduct)
                .build();
    }
}
