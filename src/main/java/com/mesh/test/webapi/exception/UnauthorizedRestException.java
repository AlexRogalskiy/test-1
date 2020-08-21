package com.mesh.test.webapi.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class UnauthorizedRestException extends WebApplicationException {
    public UnauthorizedRestException(String message) {
        super(message, Response.Status.UNAUTHORIZED);
    }
}
