package com.kasisto.api.impl;

import com.kasisto.api.*;
import com.kasisto.api.model.*;

import com.sun.jersey.multipart.FormDataParam;

import com.kasisto.api.model.TransactionCriteria;
import com.kasisto.api.model.Transaction;
import com.kasisto.api.model.Transaction.StatusEnum;
import com.kasisto.api.model.Transaction.TransactionTypeEnum;

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
public class TransactionsApiServiceImpl extends TransactionsApiService {
  
      @Override
      public Response transactionsPost(String secret,String token,TransactionCriteria transactionCriteria,SecurityContext securityContext)
      throws NotFoundException {
      
      List<Transaction> transactions=new ArrayList<Transaction>();
    
      Transaction t=new Transaction();
    

        t.setAccountId("123123213");
        t.setTransactionId("23432433");
        t.setDescription("A sample transaction");        
        t.setTransactionType(TransactionTypeEnum.DEBIT);
        t.setAmount(123.0f);
        t.setCurrencyCode("USD");
        t.setCategory("food");
        t.setStatus(StatusEnum.POSTED);
        t.setTransactionDate(new Date());
        t.setPostDate(new Date());

      transactions.add(t);
      
      
      
      
      
      return Response.ok().entity(transactions).build();
  }
  
}
