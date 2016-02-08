package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.MerchantsApiService;
import com.kasisto.api.factories.MerchantsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Merchant;
import com.kasisto.api.model.MerchantsRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/merchants")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the merchants API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class MerchantsApi  {
   private final MerchantsApiService delegate = MerchantsApiServiceFactory.getMerchantsApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Get merchants", response = Merchant.class, responseContainer = "List", tags={ "Transactions" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "merchants response", response = Merchant.class, responseContainer = "List") })

    public Response merchantsPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ) MerchantsRequest merchantsRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.merchantsPost(secret,token,merchantsRequest,securityContext);
    }
}
