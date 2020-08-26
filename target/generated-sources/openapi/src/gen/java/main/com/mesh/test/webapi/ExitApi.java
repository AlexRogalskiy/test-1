package com.mesh.test.webapi;

import com.mesh.test.model.ResponseDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/exit")
@Api(description = "the exit API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2020-08-26T23:44:37.813287300+03:00[Europe/Moscow]")
public interface ExitApi {

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Завершить работу приложения", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class) })
    Response getExit();
}
