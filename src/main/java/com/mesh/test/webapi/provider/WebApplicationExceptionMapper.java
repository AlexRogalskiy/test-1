package com.mesh.test.webapi.provider;

import com.mesh.test.model.ResponseDTO;
import com.mesh.test.service.ExceptionService;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Inject
    ExceptionService exceptionService;

    @Override
    public Response toResponse(WebApplicationException exception) {
        exceptionService.setLastMessage(exception.getMessage());

        return Response
                .status(exception.getResponse().getStatusInfo())
                .entity(new ResponseDTO()
                        .msg(exception.getMessage()))
                .build();
    }
}