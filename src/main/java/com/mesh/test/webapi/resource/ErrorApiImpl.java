package com.mesh.test.webapi.resource;

import com.mesh.test.service.ExceptionManager;
import com.mesh.test.webapi.ErrorApi;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class ErrorApiImpl implements ErrorApi {
    ExceptionManager exceptionManager;

    public ErrorApiImpl(ExceptionManager exceptionManager) {
        this.exceptionManager = exceptionManager;
    }

    @Override
    public Response getErrorLast() {
        return Response.ok()
                .entity(exceptionManager.getLastMessage())
                .build();
    }
}
