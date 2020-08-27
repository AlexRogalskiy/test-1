package com.mesh.test.webapi.resource;

import com.mesh.test.service.ExceptionService;
import com.mesh.test.webapi.ErrorApi;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class ErrorApiImpl implements ErrorApi {
    private final ExceptionService exceptionService;

    ErrorApiImpl(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @Override
    public Response getErrorLast() {
        return Response.ok()
                .entity(exceptionService.getLastMessage())
                .build();
    }
}
