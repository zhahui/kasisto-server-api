package com.kasisto.api.impl;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.CustomerRequest;
import com.kasisto.api.model.Customer;

import java.util.List;
import java.util.ArrayList;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class CustomerApiServiceImpl extends CustomerApiService {
  
      @Override
      public Response customerPost(String secret,String token,CustomerRequest customerRequest,SecurityContext securityContext)
      throws NotFoundException {
      
      Customer customer=new Customer();
    
      customer.setUserId("1234567890");
      customer.setFullName("Joe Tester");
      customer.setFirstName("Joe");
      customer.setLastName("Tester");

      List<MetaField> meta=new ArrayList<MetaField>();
      
      MetaField field=new MetaField();
      field.setName("email");
      field.setValue("joe.tester@someplace.net");
      meta.add(field);

      customer.setMeta(meta); 
      
      return Response.ok().entity(customer).build();
  }
}
