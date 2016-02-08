package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.AccountsApiService;
import com.kasisto.api.factories.AccountsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Account;
import com.kasisto.api.model.AccountsRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/accounts")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the accounts API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class AccountsApi  {
   private final AccountsApiService delegate = AccountsApiServiceFactory.getAccountsApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Get customer accounts", response = Account.class, responseContainer = "List", tags={ "Accounts" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "accounts response", response = Account.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "", response = Account.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Access Denied", response = Account.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 450, message = "One-Time Password is required", response = Account.class, responseContainer = "List") })

    public Response accountsPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ,required=true) AccountsRequest accountsRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountsPost(secret,token,accountsRequest,securityContext);
    }
}
