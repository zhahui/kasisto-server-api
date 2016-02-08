package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class Merchant   {
  
  private String merchantId = null;
  private String name = null;
  private List<String> alias = new ArrayList<String>();

  
  /**
   * ID of merchant
   **/
  
  @ApiModelProperty(value = "ID of merchant")
  @JsonProperty("merchant_id")
  public String getMerchantId() {
    return merchantId;
  }
  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  
  /**
   * Name of merchant
   **/
  
  @ApiModelProperty(value = "Name of merchant")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Optional alternative names for this merchant
   **/
  
  @ApiModelProperty(value = "Optional alternative names for this merchant")
  @JsonProperty("alias")
  public List<String> getAlias() {
    return alias;
  }
  public void setAlias(List<String> alias) {
    this.alias = alias;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Merchant merchant = (Merchant) o;
    return Objects.equals(merchantId, merchant.merchantId) &&
        Objects.equals(name, merchant.name) &&
        Objects.equals(alias, merchant.alias);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantId, name, alias);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Merchant {\n");
    
    sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
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

