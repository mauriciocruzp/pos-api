package org.dev.posapi.application.port.in;

import org.dev.posapi.application.dto.request.LoginRequest;
import org.dev.posapi.infrastructure.adapter.rest.dto.respose.BaseResponse;

public interface UserUseCase {
    BaseResponse login(LoginRequest request);
}
