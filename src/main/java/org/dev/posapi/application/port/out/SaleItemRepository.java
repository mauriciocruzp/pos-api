package org.dev.posapi.application.port.out;

import org.dev.posapi.domain.model.SaleItemEntity;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Repository
public interface SaleItemRepository {
    SaleItemEntity save(SaleItemEntity saleItemEntity);
    BaseResponse getSalesByDates(String startDate, String endDate) throws ParseException;
    BaseResponse getBestSellingProducts();
    BaseResponse getSalesByProduct();
}
