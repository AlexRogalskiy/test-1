package com.mesh.test.webapi.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ForbiddenRestException extends WebApplicationException {
    public ForbiddenRestException(String message) {
        super(message, Response.Status.FORBIDDEN);
    }
}
