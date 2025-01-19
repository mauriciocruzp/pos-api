package org.dev.posapi.application.port.out;

import org.dev.posapi.domain.model.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
    public ProductEntity save(ProductEntity productEntity);
}
