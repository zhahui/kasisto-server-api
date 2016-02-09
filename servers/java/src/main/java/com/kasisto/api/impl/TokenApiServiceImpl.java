package com.kasisto.api.impl;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.TokenResponse;
import com.kasisto.api.model.TokenCredentials;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TokenApiServiceImpl extends TokenApiService {
  
      @Override
      public Response tokenPost(String secret,TokenCredentials tokenCredentials,SecurityContext securityContext)
      throws NotFoundException {
      
      TokenResponse tokenResponse=new TokenResponse();
      
      tokenResponse.setUserId("1234567890");
      tokenResponse.setToken("12345-56788-434343-131123131");
      
      return Response.ok().entity(tokenResponse).build();
  }
  
}
