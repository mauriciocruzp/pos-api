package org.dev.posapi.infrastructure.adapter.repository;

import org.dev.posapi.application.port.out.ProductRepository;
import org.dev.posapi.domain.model.ProductEntity;
import org.dev.posapi.infrastructure.adapter.repository.interfaces.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return iProductRepository.save(productEntity);
    }
}
