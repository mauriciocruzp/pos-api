package org.dev.posapi.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.dev.posapi.domain.model.ProductEntity;
import org.dev.posapi.domain.model.SaleEntity;

@Getter
@Setter
public class CreateSaleItemRequest {
    private SaleEntity sale;
    private ProductEntity product;
    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;
}
