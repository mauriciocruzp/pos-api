package org.dev.posapi.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private String name;
    private Double price;
    private Integer stock;
    private Status status;
    private enum Status {
        active, inactive
    }
}
