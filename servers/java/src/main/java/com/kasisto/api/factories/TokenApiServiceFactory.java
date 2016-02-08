package com.kasisto.api.factories;

import com.kasisto.api.TokenApiService;
import com.kasisto.api.impl.TokenApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TokenApiServiceFactory {

   private final static TokenApiService service = new TokenApiServiceImpl();

   public static TokenApiService getTokenApi()
   {
      return service;
   }
}
