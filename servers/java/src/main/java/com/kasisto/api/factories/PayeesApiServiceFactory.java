package com.kasisto.api.factories;

import com.kasisto.api.PayeesApiService;
import com.kasisto.api.impl.PayeesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class PayeesApiServiceFactory {

   private final static PayeesApiService service = new PayeesApiServiceImpl();

   public static PayeesApiService getPayeesApi()
   {
      return service;
   }
}
