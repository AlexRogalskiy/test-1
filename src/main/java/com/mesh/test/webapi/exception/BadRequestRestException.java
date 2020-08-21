package com.mesh.test.webapi.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class BadRequestRestException extends WebApplicationException {
    public BadRequestRestException(String message) {
        super(message, Response.Status.BAD_REQUEST);
    }
}
