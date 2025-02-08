package org.dev.posapi.infrastructure.adapter.rest.controller;

import org.dev.posapi.application.dto.request.LoginRequest;
import org.dev.posapi.application.port.in.UserUseCase;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserUseCase userUseCase;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequest request) {
        return userUseCase.login(request).apply();
    }
}
