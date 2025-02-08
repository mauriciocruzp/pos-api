package org.dev.posapi.infrastructure.adapter.repository;

import org.dev.posapi.application.port.out.SaleItemRepository;
import org.dev.posapi.domain.model.SaleItemEntity;
import org.dev.posapi.infrastructure.adapter.repository.interfaces.ISaleItemRepository;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class SaleItemRepositoryImpl implements SaleItemRepository {
    @Autowired
    private ISaleItemRepository iSaleItemRepository;

    @Override
    public SaleItemEntity save(SaleItemEntity saleItemEntity) {
        return iSaleItemRepository.save(saleItemEntity);
    }

    @Override
    public BaseResponse getSalesByDates(String startDate, String endDate) throws ParseException {
        Date startDateCast = new SimpleDateFormat("yyyy-MM-dd").parse(startDate.trim().replace("\"", ""));
        Date endDateCast = new SimpleDateFormat("yyyy-MM-dd").parse(endDate.trim().replace("\"", ""));
        List<Object[]> sales = iSaleItemRepository.findSalesByDate(startDateCast, endDateCast);
        System.out.println(sales.size());
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Sales retrieved successfully")
                .success(true)
                .data(sales)
                .build();
    }

    @Override
    public BaseResponse getBestSellingProducts() {
        List<Object[]> products = iSaleItemRepository.findBestSellingProducts();
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Best selling products retrieved successfully")
                .success(true)
                .data(products)
                .build();
    }

    @Override
    public BaseResponse getSalesByProduct() {
        return null;
    }

}
