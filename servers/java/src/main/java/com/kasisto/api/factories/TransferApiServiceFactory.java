package com.kasisto.api.factories;

import com.kasisto.api.TransferApiService;
import com.kasisto.api.impl.TransferApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransferApiServiceFactory {

   private final static TransferApiService service = new TransferApiServiceImpl();

   public static TransferApiService getTransferApi()
   {
      return service;
   }
}
