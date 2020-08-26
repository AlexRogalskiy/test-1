package com.mesh.test.webapi;

import com.mesh.test.model.ResponseDTO;
import com.mesh.test.model.SignUserResponseDTO;
import com.mesh.test.model.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/sign")
@Api(description = "the sign API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2020-08-26T21:20:49.755125300+03:00[Europe/Moscow]")
public interface SignApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Создать пользователя", notes = "", tags={ "sign" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = SignUserResponseDTO.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ResponseDTO.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class) })
    Response postSign(@Valid UserDTO userDTO);
}
