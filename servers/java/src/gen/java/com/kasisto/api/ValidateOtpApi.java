package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.ValidateOtpApiService;
import com.kasisto.api.factories.ValidateOtpApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.ValidateOtpResponse;
import com.kasisto.api.model.ValidateOtpRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/validate_otp")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the validate_otp API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class ValidateOtpApi  {
   private final ValidateOtpApiService delegate = ValidateOtpApiServiceFactory.getValidateOtpApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Validate One-Time Password and return new user token", response = ValidateOtpResponse.class, tags={ "Customer" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "token response", response = ValidateOtpResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "", response = ValidateOtpResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Access Denied", response = ValidateOtpResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 451, message = "Invalid One-Time Password", response = ValidateOtpResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 452, message = "Expired One-Time Password", response = ValidateOtpResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 453, message = "Too Many One-Time Password Failures", response = ValidateOtpResponse.class) })

    public Response validateOtpPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ) ValidateOtpRequest validateOtpRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.validateOtpPost(secret,token,validateOtpRequest,securityContext);
    }
}
