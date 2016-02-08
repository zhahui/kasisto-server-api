package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.kasisto.api.model.MetaField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class Payment   {
  
  private String paymentId = null;
  private String referenceNumber = null;


  public enum StatusEnum {
    PROCESSED("processed"),
    PENDING("pending"),
    CANCELLED("cancelled"),
    FAILED("failed"),
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
  private List<MetaField> meta = new ArrayList<MetaField>();

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("payment_id")
  public String getPaymentId() {
    return paymentId;
  }
  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("reference_number")
  public String getReferenceNumber() {
    return referenceNumber;
  }
  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
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
    Payment payment = (Payment) o;
    return Objects.equals(paymentId, payment.paymentId) &&
        Objects.equals(referenceNumber, payment.referenceNumber) &&
        Objects.equals(status, payment.status) &&
        Objects.equals(meta, payment.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId, referenceNumber, status, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    referenceNumber: ").append(toIndentedString(referenceNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

