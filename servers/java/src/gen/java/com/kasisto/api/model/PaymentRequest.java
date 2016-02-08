package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class PaymentRequest   {
  
  private String sourceAccountId = null;
  private String payeeId = null;
  private Float amount = null;
  private String currencyCode = null;
  private Date date = null;

  
  /**
   * source account of payment
   **/
  
  @ApiModelProperty(value = "source account of payment")
  @JsonProperty("source_account_id")
  public String getSourceAccountId() {
    return sourceAccountId;
  }
  public void setSourceAccountId(String sourceAccountId) {
    this.sourceAccountId = sourceAccountId;
  }

  
  /**
   * destination payee of payment
   **/
  
  @ApiModelProperty(value = "destination payee of payment")
  @JsonProperty("payee_id")
  public String getPayeeId() {
    return payeeId;
  }
  public void setPayeeId(String payeeId) {
    this.payeeId = payeeId;
  }

  
  /**
   * amount of transfer
   **/
  
  @ApiModelProperty(value = "amount of transfer")
  @JsonProperty("amount")
  public Float getAmount() {
    return amount;
  }
  public void setAmount(Float amount) {
    this.amount = amount;
  }

  
  /**
   * currency of amounts (USD, etc.)
   **/
  
  @ApiModelProperty(value = "currency of amounts (USD, etc.)")
  @JsonProperty("currency_code")
  public String getCurrencyCode() {
    return currencyCode;
  }
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  
  /**
   * date of payment
   **/
  
  @ApiModelProperty(value = "date of payment")
  @JsonProperty("date")
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequest paymentRequest = (PaymentRequest) o;
    return Objects.equals(sourceAccountId, paymentRequest.sourceAccountId) &&
        Objects.equals(payeeId, paymentRequest.payeeId) &&
        Objects.equals(amount, paymentRequest.amount) &&
        Objects.equals(currencyCode, paymentRequest.currencyCode) &&
        Objects.equals(date, paymentRequest.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceAccountId, payeeId, amount, currencyCode, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequest {\n");
    
    sb.append("    sourceAccountId: ").append(toIndentedString(sourceAccountId)).append("\n");
    sb.append("    payeeId: ").append(toIndentedString(payeeId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

