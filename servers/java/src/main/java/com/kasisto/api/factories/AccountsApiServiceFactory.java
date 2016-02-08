package com.kasisto.api.factories;

import com.kasisto.api.AccountsApiService;
import com.kasisto.api.impl.AccountsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class AccountsApiServiceFactory {

   private final static AccountsApiService service = new AccountsApiServiceImpl();

   public static AccountsApiService getAccountsApi()
   {
      return service;
   }
}
