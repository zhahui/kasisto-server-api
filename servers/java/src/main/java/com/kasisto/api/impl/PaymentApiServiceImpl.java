package com.kasisto.api.impl;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Payment;
import com.kasisto.api.model.Payment.StatusEnum;
import com.kasisto.api.model.PaymentRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class PaymentApiServiceImpl extends PaymentApiService {
  
      @Override
      public Response paymentPost(String secret,String token,PaymentRequest paymentRequest,SecurityContext securityContext)
      throws NotFoundException {
      
      Payment payment=new Payment();

      payment.setPaymentId("1234567");
      payment.setReferenceNumber("1234523423");
      payment.setStatus(StatusEnum.PROCESSED);
      
      
      return Response.ok().entity(payment).build();
  }
  
}
