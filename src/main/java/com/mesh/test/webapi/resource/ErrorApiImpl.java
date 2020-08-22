package com.mesh.test.webapi.resource;

import com.mesh.test.service.ExceptionService;
import com.mesh.test.webapi.ErrorApi;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class ErrorApiImpl implements ErrorApi {
    @Override
    public Response getErrorLast() {
        return Response.ok()
                .entity(ExceptionService.getLastMessage())
                .build();
    }
}
