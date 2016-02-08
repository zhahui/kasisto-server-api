package com.kasisto.api.impl;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Transfer;
import com.kasisto.api.model.TransferRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransferApiServiceImpl extends TransferApiService {
  
      @Override
      public Response transferPost(String secret,String token,TransferRequest transferRequest,SecurityContext securityContext)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
  
}
