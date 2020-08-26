package com.mesh.test.webapi;

import com.mesh.test.model.ProfileDTO;
import com.mesh.test.model.ProfilesGetRequestDTO;
import com.mesh.test.model.ProfilesSetRequestDTO;
import com.mesh.test.model.ProfilesSetResponseDTO;
import com.mesh.test.model.ResponseDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/profiles")
@Api(description = "the profiles API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2020-08-26T21:20:49.755125300+03:00[Europe/Moscow]")
public interface ProfilesApi {

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Получить список профилей", notes = "", authorizations = {
        @Authorization(value = "oauth2", scopes = {
            @AuthorizationScope(scope = "read", description = "Чтение")
        })
    }, tags={ "profile",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProfileDTO.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class, responseContainer = "List") })
    Response getProfiles();

    @GET
    @Path("/{ID}")
    @Produces({ "application/json", "application/xml",  })
    @ApiOperation(value = "Получить профиль по ID", notes = "", authorizations = {
        @Authorization(value = "oauth2", scopes = {
            @AuthorizationScope(scope = "read", description = "Чтение")
        })
    }, tags={ "profile",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProfileDTO.class),
        @ApiResponse(code = 404, message = "Not Found", response = ResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class) })
    Response getProfilesId(@PathParam("ID") @ApiParam("Id профиля") Integer ID);

    @GET
    @Path("/last")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Получить последний добавленный профиль", notes = "", authorizations = {
        @Authorization(value = "oauth2", scopes = {
            @AuthorizationScope(scope = "read", description = "Чтение")
        })
    }, tags={ "profile",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProfileDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class) })
    Response getProfilesLast();

    @POST
    @Path("/get")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Получить профиль по email", notes = "", authorizations = {
        @Authorization(value = "oauth2", scopes = {
            @AuthorizationScope(scope = "read", description = "Чтение")
        })
    }, tags={ "profile",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProfileDTO.class),
        @ApiResponse(code = 404, message = "Not Found", response = ResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class) })
    Response postProfilesGet(@Valid ProfilesGetRequestDTO profilesGetRequestDTO);

    @POST
    @Path("/set")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Добавить профиль", notes = "", authorizations = {
        @Authorization(value = "oauth2", scopes = {
            @AuthorizationScope(scope = "write", description = "Запись")
        })
    }, tags={ "profile" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProfilesSetResponseDTO.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ResponseDTO.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseDTO.class) })
    Response postProfilesSet(@Valid ProfilesSetRequestDTO profilesSetRequestDTO);
}
