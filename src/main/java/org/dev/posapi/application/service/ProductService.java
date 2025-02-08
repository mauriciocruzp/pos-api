package org.dev.posapi.application.service;

import org.dev.posapi.application.dto.request.CreateProductRequest;
import org.dev.posapi.application.dto.request.UpdateProductRequest;
import org.dev.posapi.application.port.in.ProductUseCase;
import org.dev.posapi.application.port.out.ProductRepository;
import org.dev.posapi.domain.model.ProductEntity;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public BaseResponse getProducts() {
        List<ProductEntity> products = productRepository.findAll();

        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Products retrieved successfully")
                .success(true)
                .data(products)
                .build();
    }

    @Override
    public BaseResponse getProductById(Long id) {
        ProductEntity product = productRepository.findById(id);

        if (product == null) {
            return BaseResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Product not found")
                    .success(false)
                    .build();
        }

        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Product retrieved successfully")
                .success(true)
                .data(product)
                .build();
    }

    @Override
    public BaseResponse updateProduct(Long id, UpdateProductRequest request) {
        ProductEntity product = new ProductEntity();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        UpdateProductRequest.Status status = request.getStatus();
        if (status == UpdateProductRequest.Status.active) {
            product.setStatus(ProductEntity.Status.active);
        } else {
            product.setStatus(ProductEntity.Status.inactive);
        }

        ProductEntity updatedProduct = productRepository.update(id, product);

        if (updatedProduct == null) {
            return BaseResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Product not found")
                    .success(false)
                    .build();
        }

        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Product updated successfully")
                .success(true)
                .data(updatedProduct)
                .build();
    }

    @Override
    public BaseResponse deleteProduct(Long id) {
        boolean isDeleted = productRepository.deleteById(id);

        if (!isDeleted) {
            return BaseResponse.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Product not found")
                    .success(false)
                    .build();
        }

        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Product deleted successfully")
                .success(true)
                .build();
    }

    @Override
    public boolean saleProduct(Long id, int quantity) {
        return productRepository.saleProduct(id, quantity);
    }
}
