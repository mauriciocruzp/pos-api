package org.dev.posapi.application.port.in;

import org.dev.posapi.application.dto.request.CreateSaleItemRequest;
import org.dev.posapi.domain.model.SaleItemEntity;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;

import java.text.ParseException;

public interface SaleItemUseCase {
    SaleItemEntity createSaleItem(CreateSaleItemRequest request);
    BaseResponse getSalesByDates(String startDate, String endDate) throws ParseException;
    BaseResponse getBestSellingProducts();
    BaseResponse getSalesByProduct();
}
