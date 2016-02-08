package com.kasisto.api.factories;

import com.kasisto.api.MerchantsApiService;
import com.kasisto.api.impl.MerchantsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class MerchantsApiServiceFactory {

   private final static MerchantsApiService service = new MerchantsApiServiceImpl();

   public static MerchantsApiService getMerchantsApi()
   {
      return service;
   }
}
