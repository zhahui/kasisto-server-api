package com.kasisto.api;

import com.kasisto.api.model.*;
import com.kasisto.api.PaymentApiService;
import com.kasisto.api.factories.PaymentApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Payment;
import com.kasisto.api.model.PaymentRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/payment")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the payment API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class PaymentApi  {
   private final PaymentApiService delegate = PaymentApiServiceFactory.getPaymentApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Pay funds to a payee", response = Payment.class, tags={ "Payments" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "payment response", response = Payment.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "", response = Payment.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Access Denied", response = Payment.class),
        
        @io.swagger.annotations.ApiResponse(code = 450, message = "One-Time Password is required", response = Payment.class) })

    public Response paymentPost(@ApiParam(value = "" ,required=true)@HeaderParam("secret") String secret,@ApiParam(value = "" ,required=true)@HeaderParam("token") String token,@ApiParam(value = "" ) PaymentRequest paymentRequest,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.paymentPost(secret,token,paymentRequest,securityContext);
    }
}
