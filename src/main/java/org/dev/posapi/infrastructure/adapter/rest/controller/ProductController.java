package org.dev.posapi.infrastructure.adapter.rest.controller;

import org.dev.posapi.application.dto.request.CreateProductRequest;
import org.dev.posapi.application.dto.request.UpdateProductRequest;
import org.dev.posapi.application.port.in.ProductUseCase;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductUseCase productUseCase;

    @PostMapping
    public ResponseEntity<BaseResponse> createProduct(@RequestBody CreateProductRequest request) {
        return productUseCase.createProduct(request).apply();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getProducts() {
        return productUseCase.getProducts().apply();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getProductById(@PathVariable Long id) {
        return productUseCase.getProductById(id).apply();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest request) {
        return productUseCase.updateProduct(id, request).apply();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteProduct(@PathVariable Long id) {
        return productUseCase.deleteProduct(id).apply();
    }
}
