package com.mesh.test.webapi;

import com.mesh.test.model.ErrorLastResponseDTO;
import com.mesh.test.model.ResponseDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/error")
@Api(description = "the error API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2020-08-26T21:20:49.755125300+03:00[Europe/Moscow]")
public interface ErrorApi {

    @GET
    @Path("/last")
    @Produces({ "application/json" })
    @ApiOperation(value = "Получить сообщение последней ошибки", notes = "", authorizations = {
        @Authorization(value = "oauth2", scopes = {
            @AuthorizationScope(scope = "read", description = "Чтение")
        })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ErrorLastResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class) })
    Response getErrorLast();
}
