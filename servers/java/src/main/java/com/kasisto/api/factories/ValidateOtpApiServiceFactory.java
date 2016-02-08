package com.kasisto.api.factories;

import com.kasisto.api.ValidateOtpApiService;
import com.kasisto.api.impl.ValidateOtpApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class ValidateOtpApiServiceFactory {

   private final static ValidateOtpApiService service = new ValidateOtpApiServiceImpl();

   public static ValidateOtpApiService getValidateOtpApi()
   {
      return service;
   }
}
