package org.dev.posapi.infrastructure.adapter.repository.interfaces;

import org.dev.posapi.domain.model.ProductEntity;
import org.dev.posapi.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getByUsername(String username);
}
