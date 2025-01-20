package org.dev.posapi.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSaleRequest {
    private Long userId;
    private Double total;
    private Long[] products;
}
