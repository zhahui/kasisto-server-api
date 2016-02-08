package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class Payee   {
  
  private String payeeId = null;
  private String name = null;
  private List<String> alias = new ArrayList<String>();

  
  /**
   * ID of payee
   **/
  
  @ApiModelProperty(value = "ID of payee")
  @JsonProperty("payee_id")
  public String getPayeeId() {
    return payeeId;
  }
  public void setPayeeId(String payeeId) {
    this.payeeId = payeeId;
  }

  
  /**
   * Name of payee
   **/
  
  @ApiModelProperty(value = "Name of payee")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Optional alternative names for this payee
   **/
  
  @ApiModelProperty(value = "Optional alternative names for this payee")
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
    Payee payee = (Payee) o;
    return Objects.equals(payeeId, payee.payeeId) &&
        Objects.equals(name, payee.name) &&
        Objects.equals(alias, payee.alias);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payeeId, name, alias);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payee {\n");
    
    sb.append("    payeeId: ").append(toIndentedString(payeeId)).append("\n");
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

