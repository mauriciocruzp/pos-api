package org.dev.posapi.infrastructure.adapter.rest.controller;

import org.dev.posapi.application.dto.request.CreateSaleRequest;
import org.dev.posapi.application.port.in.SaleUseCase;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    SaleUseCase saleUseCase;

    @PostMapping
    public ResponseEntity<BaseResponse> createSale(@RequestBody CreateSaleRequest request) {
        return saleUseCase.createSale(request).apply();
    }
}
