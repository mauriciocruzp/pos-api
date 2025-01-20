package org.dev.posapi.application.port.in;

import org.dev.posapi.application.dto.request.CreateSaleRequest;
import org.dev.posapi.application.dto.request.UpdateSaleRequest;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;

public interface SaleUseCase {
    BaseResponse createSale(CreateSaleRequest request);
    BaseResponse getSales();
    BaseResponse getSaleById(Long id);
    BaseResponse updateSale(Long id, UpdateSaleRequest request);
    BaseResponse deleteSale(Long id);
}
