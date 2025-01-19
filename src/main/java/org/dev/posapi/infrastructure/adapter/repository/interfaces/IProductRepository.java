package org.dev.posapi.infrastructure.adapter.repository.interfaces;

import org.dev.posapi.domain.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> { }
