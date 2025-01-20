package org.dev.posapi.application.port.out;

import org.dev.posapi.domain.model.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    ProductEntity save(ProductEntity productEntity);
    List<ProductEntity> findAll();
    ProductEntity findById(Long id);
    ProductEntity update(Long id, ProductEntity productEntity);
    boolean deleteById(Long id);
    boolean saleProduct(Long id, int quantity);
}
