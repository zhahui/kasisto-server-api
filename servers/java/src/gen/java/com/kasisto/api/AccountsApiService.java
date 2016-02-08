package com.kasisto.api;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Account;
import com.kasisto.api.model.AccountsRequest;

import java.util.List;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public abstract class AccountsApiService {
  
      public abstract Response accountsPost(String secret,String token,AccountsRequest accountsRequest,SecurityContext securityContext)
      throws NotFoundException;
  
}
