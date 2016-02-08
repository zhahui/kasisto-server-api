package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.TransferApiService;
import com.kasisto.api.factories.TransferApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Transfer;
import com.kasisto.api.model.TransferRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/transfer")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the transfer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransferApi  {
   private final TransferApiService delegate = TransferApiServiceFactory.getTransferApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Transfer funds between two accounts", response = Transfer.class, tags={ "Transfers" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "transfer response", response = Transfer.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "", response = Transfer.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Access Denied", response = Transfer.class),
        
        @io.swagger.annotations.ApiResponse(code = 450, message = "One-Time Password is required", response = Transfer.class) })

    public Response transferPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ) TransferRequest transferRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.transferPost(secret,token,transferRequest,securityContext);
    }
}
