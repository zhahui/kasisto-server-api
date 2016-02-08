package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransferRequest   {
  
  private String sourceAccountId = null;
  private String destAccountId = null;
  private Float amount = null;
  private String currencyCode = null;
  private Date date = null;

  
  /**
   * source account of transfer
   **/
  
  @ApiModelProperty(value = "source account of transfer")
  @JsonProperty("source_account_id")
  public String getSourceAccountId() {
    return sourceAccountId;
  }
  public void setSourceAccountId(String sourceAccountId) {
    this.sourceAccountId = sourceAccountId;
  }

  
  /**
   * destination account of transfer
   **/
  
  @ApiModelProperty(value = "destination account of transfer")
  @JsonProperty("dest_account_id")
  public String getDestAccountId() {
    return destAccountId;
  }
  public void setDestAccountId(String destAccountId) {
    this.destAccountId = destAccountId;
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
   * date of transfer
   **/
  
  @ApiModelProperty(value = "date of transfer")
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
    TransferRequest transferRequest = (TransferRequest) o;
    return Objects.equals(sourceAccountId, transferRequest.sourceAccountId) &&
        Objects.equals(destAccountId, transferRequest.destAccountId) &&
        Objects.equals(amount, transferRequest.amount) &&
        Objects.equals(currencyCode, transferRequest.currencyCode) &&
        Objects.equals(date, transferRequest.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceAccountId, destAccountId, amount, currencyCode, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferRequest {\n");
    
    sb.append("    sourceAccountId: ").append(toIndentedString(sourceAccountId)).append("\n");
    sb.append("    destAccountId: ").append(toIndentedString(destAccountId)).append("\n");
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

