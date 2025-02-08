package org.dev.posapi.application.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.dev.posapi.application.dto.request.LoginRequest;
import org.dev.posapi.application.port.in.UserUseCase;
import org.dev.posapi.application.port.out.UserRepository;
import org.dev.posapi.domain.model.UserEntity;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserUseCase {
    @Autowired
    UserRepository userRepository;

    @Override
    public BaseResponse login(LoginRequest request) {
        UserEntity userEntity = userRepository.login(request.getUsername(), request.getPassword());

        UserEntity userResponse = new UserEntity();

        userResponse.setId(userEntity.getId());
        userResponse.setUsername(userEntity.getUsername());
        userResponse.setRole(userEntity.getRole());

        if (userEntity != null) {
            return BaseResponse.builder()
                    .status(HttpStatus.OK)
                    .statusCode(200)
                    .message("Login success")
                    .data(userResponse)
                    .build();
        }

        return BaseResponse.builder()
                .status(HttpStatus.UNAUTHORIZED)
                .statusCode(401)
                .message("Login failed")
                .build();
    }
}
