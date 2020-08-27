package com.mesh.test.security.error;

import com.mesh.test.service.ExceptionService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ExceptionService exceptionService;

    RestAuthenticationEntryPoint(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        exceptionService.securityResponse(httpServletResponse);
    }
}