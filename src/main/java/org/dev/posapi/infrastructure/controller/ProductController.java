package org.dev.posapi.infrastructure.controller;

import org.dev.posapi.application.dto.request.CreateProductRequest;
import org.dev.posapi.application.port.in.ProductUseCase;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductUseCase productUseCase;

    @PostMapping
    public ResponseEntity<BaseResponse> createProduct(@RequestBody CreateProductRequest request) {
        return productUseCase.createProduct(request).apply();
    }
}
