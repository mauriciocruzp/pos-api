package org.dev.posapi.application.port.out;

import org.dev.posapi.domain.model.SaleItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleItemRepository {
    SaleItemEntity save(SaleItemEntity saleItemEntity);
    List<SaleItemEntity> findAll();
    SaleItemEntity findById(Long id);
    SaleItemEntity update(Long id, SaleItemEntity saleItemEntity);
    boolean deleteById(Long id);
}
