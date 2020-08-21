package com.mesh.test.webapi.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class NotFoundRestException extends WebApplicationException {
    public NotFoundRestException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }
}
