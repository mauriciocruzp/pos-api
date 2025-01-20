package org.dev.posapi.infrastructure.adapter.repository;

import org.dev.posapi.application.port.out.SaleRepository;
import org.dev.posapi.domain.model.SaleEntity;
import org.dev.posapi.infrastructure.adapter.repository.interfaces.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleRepositoryImpl implements SaleRepository {
    @Autowired
    private ISaleRepository iSaleRepository;

    @Override
    public SaleEntity save(SaleEntity saleEntity) {
        return iSaleRepository.save(saleEntity);
    }

    @Override
    public List<SaleEntity> findAll() {
        return List.of();
    }

    @Override
    public SaleEntity findById(Long id) {
        return null;
    }

    @Override
    public SaleEntity update(Long id, SaleEntity saleEntity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
