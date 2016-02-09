package com.kasisto.api.impl;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.PayeesRequest;
import com.kasisto.api.model.Payee;

import java.util.List;
import java.util.ArrayList;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class PayeesApiServiceImpl extends PayeesApiService {
  
      @Override
      public Response payeesPost(String secret,String token,PayeesRequest payeesRequest,SecurityContext securityContext)
      throws NotFoundException {
     
      List<Payee> payees=new ArrayList<Payee>();
        
      for(int i=0;i<10;i++)
      {
        Payee payee=new Payee();
        payee.setPayeeId("payee"+i);
        payee.setName("Joe Payee"+i);
        List<String> aliases=new ArrayList<String>();
        aliases.add("Joe"+i);
        aliases.add("Joseph"+i);
        payee.setAlias(aliases);
        payees.add(payee);
      }
      
      return Response.ok().entity(payees).build();
  }
  
}
