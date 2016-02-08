package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.kasisto.api.model.MetaField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class AuthInfo   {
  
  private String token = null;
  private List<MetaField> meta = new ArrayList<MetaField>();

  
  /**
   * New valid token if using SSO tokens
   **/
  
  @ApiModelProperty(value = "New valid token if using SSO tokens")
  @JsonProperty("token")
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
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
    AuthInfo authInfo = (AuthInfo) o;
    return Objects.equals(token, authInfo.token) &&
        Objects.equals(meta, authInfo.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthInfo {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

