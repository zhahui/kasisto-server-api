package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.PayeesApiService;
import com.kasisto.api.factories.PayeesApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.PayeesRequest;
import com.kasisto.api.model.Payee;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/payees")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the payees API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class PayeesApi  {
   private final PayeesApiService delegate = PayeesApiServiceFactory.getPayeesApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Get list of payees for a user", response = Payee.class, responseContainer = "List", tags={ "Payments" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "payees response", response = Payee.class, responseContainer = "List") })

    public Response payeesPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ) PayeesRequest payeesRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.payeesPost(secret,token,payeesRequest,securityContext);
    }
}
