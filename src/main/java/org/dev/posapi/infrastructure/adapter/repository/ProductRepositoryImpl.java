package org.dev.posapi.infrastructure.adapter.repository;

import org.dev.posapi.application.port.out.ProductRepository;
import org.dev.posapi.domain.model.ProductEntity;
import org.dev.posapi.infrastructure.adapter.repository.interfaces.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return iProductRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity update(Long id, ProductEntity productEntity) {
        ProductEntity product = iProductRepository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setStock(productEntity.getStock());
        product.setStatus(productEntity.getStatus());

        return iProductRepository.save(productEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        if (iProductRepository.existsById(id)) {
            iProductRepository.deleteById(id);

            return true;
        }
            return false;
    }

    @Override
    public boolean saleProduct(Long id, int quantity) {
        ProductEntity product = iProductRepository.findById(id).orElse(null);

        if (product == null) {
            return false;
        }

        if (product.getStock() < quantity) {
            return false;
        }

        product.setStock(product.getStock() - quantity);
        iProductRepository.save(product);

        return true;
    }
}
