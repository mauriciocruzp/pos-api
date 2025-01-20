package org.dev.posapi.application.port.out;

import org.dev.posapi.domain.model.SaleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository {
    SaleEntity save(SaleEntity saleEntity);
    List<SaleEntity> findAll();
    SaleEntity findById(Long id);
    SaleEntity update(Long id, SaleEntity saleEntity);
    boolean deleteById(Long id);
}
