package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.CustomerApiService;
import com.kasisto.api.factories.CustomerApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.CustomerRequest;
import com.kasisto.api.model.Customer;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/customer")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the customer API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class CustomerApi  {
   private final CustomerApiService delegate = CustomerApiServiceFactory.getCustomerApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Get customer object", response = Customer.class, tags={ "Customer" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "customer response", response = Customer.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "", response = Customer.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Access Denied", response = Customer.class),
        
        @io.swagger.annotations.ApiResponse(code = 450, message = "One-Time Password is required", response = Customer.class) })

    public Response customerPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ,required=true) CustomerRequest customerRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.customerPost(secret,token,customerRequest,securityContext);
    }
}
