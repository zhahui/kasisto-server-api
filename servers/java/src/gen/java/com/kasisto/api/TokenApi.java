package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.TokenApiService;
import com.kasisto.api.factories.TokenApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.TokenResponse;
import com.kasisto.api.model.TokenCredentials;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/token")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the token API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TokenApi  {
   private final TokenApiService delegate = TokenApiServiceFactory.getTokenApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Get access token for a customer", response = TokenResponse.class, tags={ "Customer" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "token response", response = TokenResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "", response = TokenResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Access Denied", response = TokenResponse.class) })

    public Response tokenPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ) TokenCredentials tokenCredentials,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.tokenPost(secret,tokenCredentials,securityContext);
    }
}
