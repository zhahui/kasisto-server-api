package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.CategoriesApiService;
import com.kasisto.api.factories.CategoriesApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Category;
import com.kasisto.api.model.CategoriesRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/categories")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the categories API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class CategoriesApi  {
   private final CategoriesApiService delegate = CategoriesApiServiceFactory.getCategoriesApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Get transaction categories", response = Category.class, responseContainer = "List", tags={ "Transactions" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "categories response", response = Category.class, responseContainer = "List") })

    public Response categoriesPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ) CategoriesRequest categoriesRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.categoriesPost(secret,token,categoriesRequest,securityContext);
    }
}
