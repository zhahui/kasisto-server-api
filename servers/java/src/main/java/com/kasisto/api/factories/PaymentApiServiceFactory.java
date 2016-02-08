package com.kasisto.api.factories;

import com.kasisto.api.PaymentApiService;
import com.kasisto.api.impl.PaymentApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class PaymentApiServiceFactory {

   private final static PaymentApiService service = new PaymentApiServiceImpl();

   public static PaymentApiService getPaymentApi()
   {
      return service;
   }
}
