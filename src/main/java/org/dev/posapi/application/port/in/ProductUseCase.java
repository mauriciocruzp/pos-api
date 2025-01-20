package org.dev.posapi.application.port.in;

import org.dev.posapi.application.dto.request.CreateProductRequest;
import org.dev.posapi.application.dto.request.UpdateProductRequest;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;

public interface ProductUseCase {
    BaseResponse createProduct(CreateProductRequest request);
    BaseResponse getProducts();
    BaseResponse getProductById(Long id);
    BaseResponse updateProduct(Long id, UpdateProductRequest request);
    BaseResponse deleteProduct(Long id);
    boolean saleProduct(Long id, int quantity);
}
