package com.kasisto.api.factories;

import com.kasisto.api.CategoriesApiService;
import com.kasisto.api.impl.CategoriesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class CategoriesApiServiceFactory {

   private final static CategoriesApiService service = new CategoriesApiServiceImpl();

   public static CategoriesApiService getCategoriesApi()
   {
      return service;
   }
}
