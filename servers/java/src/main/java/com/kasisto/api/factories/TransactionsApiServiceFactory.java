package com.kasisto.api.factories;

import com.kasisto.api.TransactionsApiService;
import com.kasisto.api.impl.TransactionsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransactionsApiServiceFactory {

   private final static TransactionsApiService service = new TransactionsApiServiceImpl();

   public static TransactionsApiService getTransactionsApi()
   {
      return service;
   }
}
