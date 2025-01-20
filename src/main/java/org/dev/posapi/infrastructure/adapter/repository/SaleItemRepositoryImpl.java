package org.dev.posapi.infrastructure.adapter.repository;

import org.dev.posapi.application.port.out.SaleItemRepository;
import org.dev.posapi.domain.model.SaleItemEntity;
import org.dev.posapi.infrastructure.adapter.repository.interfaces.ISaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleItemRepositoryImpl implements SaleItemRepository {
    @Autowired
    private ISaleItemRepository iSaleItemRepository;

    @Override
    public SaleItemEntity save(SaleItemEntity saleItemEntity) {
        return iSaleItemRepository.save(saleItemEntity);
    }

    @Override
    public List<SaleItemEntity> findAll() {
        return List.of();
    }

    @Override
    public SaleItemEntity findById(Long id) {
        return null;
    }

    @Override
    public SaleItemEntity update(Long id, SaleItemEntity saleItemEntity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
