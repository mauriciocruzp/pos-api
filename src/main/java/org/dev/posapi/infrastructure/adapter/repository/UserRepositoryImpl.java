package org.dev.posapi.infrastructure.adapter.repository;

import org.dev.posapi.application.port.out.UserRepository;
import org.dev.posapi.domain.model.UserEntity;
import org.dev.posapi.infrastructure.adapter.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserEntity login(String username, String password) {
        UserEntity userEntity = iUserRepository.getByUsername(username);
        if (userEntity != null && userEntity.getPassword().equals(password)) {
            return userEntity;
        }
        return null;
    }
}
