package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.kasisto.api.model.MetaField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import java.util.Date;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class Transaction   {
  
  private String accountId = null;
  private String transactionId = null;


  public enum TransactionTypeEnum {
    ATM("atm"),
    CASH("cash"),
    CHECK("check"),
    CHECK_DEPOSIT("check_deposit"),
    CREDIT("credit"),
    DEBIT("debit"),
    FEE("fee"),
    DIVIDEND("dividend"),
    INTEREST("interest"),
    UNSPECIFIED("unspecified");

    private String value;

    TransactionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private TransactionTypeEnum transactionType = null;
  private Float amount = null;
  private String currencyCode = null;
  private String category = null;


  public enum StatusEnum {
    POSTED("posted"),
    PENDING("pending"),
    CANCELLED("cancelled"),
    UNSPECIFIED("unspecified");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private StatusEnum status = null;
  private Integer checkNumber = null;
  private Date transactionDate = null;
  private Date postDate = null;
  private List<MetaField> meta = new ArrayList<MetaField>();

  
  /**
   * ID of account transaction is from
   **/
  
  @ApiModelProperty(value = "ID of account transaction is from")
  @JsonProperty("account_id")
  public String getAccountId() {
    return accountId;
  }
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  
  /**
   * ID of this transaction
   **/
  
  @ApiModelProperty(value = "ID of this transaction")
  @JsonProperty("transaction_id")
  public String getTransactionId() {
    return transactionId;
  }
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  
  /**
   * Type of transaction
   **/
  
  @ApiModelProperty(value = "Type of transaction")
  @JsonProperty("transaction_type")
  public TransactionTypeEnum getTransactionType() {
    return transactionType;
  }
  public void setTransactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
  }

  
  /**
   * Amount of transaction (can be positive or negative)
   **/
  
  @ApiModelProperty(value = "Amount of transaction (can be positive or negative)")
  @JsonProperty("amount")
  public Float getAmount() {
    return amount;
  }
  public void setAmount(Float amount) {
    this.amount = amount;
  }

  
  /**
   * Currency type of the amount
   **/
  
  @ApiModelProperty(value = "Currency type of the amount")
  @JsonProperty("currency_code")
  public String getCurrencyCode() {
    return currencyCode;
  }
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  
  /**
   * Category of transaction if provided
   **/
  
  @ApiModelProperty(value = "Category of transaction if provided")
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }

  
  /**
   * Status of transaction
   **/
  
  @ApiModelProperty(value = "Status of transaction")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   * Check number of transaction is a check
   **/
  
  @ApiModelProperty(value = "Check number of transaction is a check")
  @JsonProperty("check_number")
  public Integer getCheckNumber() {
    return checkNumber;
  }
  public void setCheckNumber(Integer checkNumber) {
    this.checkNumber = checkNumber;
  }

  
  /**
   * Date of transaction
   **/
  
  @ApiModelProperty(value = "Date of transaction")
  @JsonProperty("transaction_date")
  public Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  
  /**
   * Date of transaction
   **/
  
  @ApiModelProperty(value = "Date of transaction")
  @JsonProperty("post_date")
  public Date getPostDate() {
    return postDate;
  }
  public void setPostDate(Date postDate) {
    this.postDate = postDate;
  }

  
  /**
   * Optional data if needed for application
   **/
  
  @ApiModelProperty(value = "Optional data if needed for application")
  @JsonProperty("meta")
  public List<MetaField> getMeta() {
    return meta;
  }
  public void setMeta(List<MetaField> meta) {
    this.meta = meta;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(accountId, transaction.accountId) &&
        Objects.equals(transactionId, transaction.transactionId) &&
        Objects.equals(transactionType, transaction.transactionType) &&
        Objects.equals(amount, transaction.amount) &&
        Objects.equals(currencyCode, transaction.currencyCode) &&
        Objects.equals(category, transaction.category) &&
        Objects.equals(status, transaction.status) &&
        Objects.equals(checkNumber, transaction.checkNumber) &&
        Objects.equals(transactionDate, transaction.transactionDate) &&
        Objects.equals(postDate, transaction.postDate) &&
        Objects.equals(meta, transaction.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, transactionId, transactionType, amount, currencyCode, category, status, checkNumber, transactionDate, postDate, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    checkNumber: ").append(toIndentedString(checkNumber)).append("\n");
    sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n");
    sb.append("    postDate: ").append(toIndentedString(postDate)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

