package org.dev.posapi.application.port.out;

import org.dev.posapi.domain.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    UserEntity login(String username, String password);
}
