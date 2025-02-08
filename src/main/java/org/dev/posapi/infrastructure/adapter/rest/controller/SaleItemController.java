package org.dev.posapi.infrastructure.adapter.rest.controller;

import org.dev.posapi.application.port.in.SaleItemUseCase;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/sale-items")
public class SaleItemController {
    @Autowired
    SaleItemUseCase saleItemUseCase;

    @GetMapping("/sales-by-date/")
    public ResponseEntity<BaseResponse> getSalesByDate(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        return saleItemUseCase.getSalesByDates(startDate, endDate).apply();
    }

    @GetMapping("/sales-by-product/")
    public ResponseEntity<BaseResponse> getBestSellingProduct() {
        return saleItemUseCase.getBestSellingProducts().apply();
    }
}
