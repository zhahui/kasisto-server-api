package com.kasisto.api.impl;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.Account;
import com.kasisto.api.model.Account.AccountTypeEnum;
import com.kasisto.api.model.AccountsRequest;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.kasisto.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class AccountsApiServiceImpl extends AccountsApiService {
  
      @Override
      public Response accountsPost(String secret,String token,AccountsRequest accountsRequest,SecurityContext securityContext)
      throws NotFoundException {
        
          Account a=new Account();
         
          a.setAccountId("1234567890");
          a.setAccountNumber("xxxx1234");
          a.setAccountName("Demo Account A");
          a.setAccountType(AccountTypeEnum.CHECKING);
          a.setAvailableBalance(1235.50f);
          a.setCurrentBalance(1235.50f);

          Account b=new Account();
         
          b.setAccountId("987654321");
          b.setAccountNumber("xxxx6789");
          b.setAccountName("Demo Account B");
          b.setAccountType(AccountTypeEnum.SAVINGS);
          b.setAvailableBalance(1235.50f);
          b.setCurrentBalance(1235.50f);

          List<Account> accounts=new ArrayList<Account>();

          accounts.add(a);
          accounts.add(b);
           
          return Response.ok().entity(accounts).build();
  }
}
