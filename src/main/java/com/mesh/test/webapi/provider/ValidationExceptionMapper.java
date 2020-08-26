package com.mesh.test.webapi.provider;

import com.mesh.test.model.ResponseDTO;
import com.mesh.test.service.ExceptionService;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Inject
    ExceptionService exceptionService;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        exceptionService.setLastMessage(exception.getMessage());

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ResponseDTO().msg(exception.getMessage()))
                .build();
    }
}
