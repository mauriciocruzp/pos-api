package org.dev.posapi.infrastructure.adapter.repository.interfaces;

import org.dev.posapi.domain.model.SaleItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleItemRepository extends JpaRepository<SaleItemEntity, Long> { }
