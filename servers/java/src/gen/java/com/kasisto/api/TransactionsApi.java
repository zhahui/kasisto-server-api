package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.TransactionsApiService;
import com.kasisto.api.factories.TransactionsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.TransactionCriteria;
import com.kasisto.api.model.Transaction;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/transactions")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the transactions API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransactionsApi  {
   private final TransactionsApiService delegate = TransactionsApiServiceFactory.getTransactionsApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Search customer transactions", response = Transaction.class, responseContainer = "List", tags={ "Transactions" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "transactions", response = Transaction.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "", response = Transaction.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Access Denied", response = Transaction.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 450, message = "One-Time Password is required", response = Transaction.class, responseContainer = "List") })

    public Response transactionsPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ,required=true) TransactionCriteria transactionCriteria,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.transactionsPost(secret,token,transactionCriteria,securityContext);
    }
}
