package org.dev.posapi.infrastructure.adapter.repository.interfaces;

import org.dev.posapi.domain.model.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<SaleEntity, Long> { }
