package org.dev.posapi.application.port.in;

import org.dev.posapi.application.dto.request.CreateProductRequest;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;

public interface ProductUseCase {
    BaseResponse createProduct(CreateProductRequest request);
}
