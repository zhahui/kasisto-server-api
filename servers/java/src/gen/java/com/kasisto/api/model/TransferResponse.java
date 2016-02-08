package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.kasisto.api.model.AuthInfo;
import com.kasisto.api.model.Transfer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransferResponse   {
  
  private AuthInfo authInfo = null;
  private Transfer transfer = null;

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("auth_info")
  public AuthInfo getAuthInfo() {
    return authInfo;
  }
  public void setAuthInfo(AuthInfo authInfo) {
    this.authInfo = authInfo;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("transfer")
  public Transfer getTransfer() {
    return transfer;
  }
  public void setTransfer(Transfer transfer) {
    this.transfer = transfer;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferResponse transferResponse = (TransferResponse) o;
    return Objects.equals(authInfo, transferResponse.authInfo) &&
        Objects.equals(transfer, transferResponse.transfer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authInfo, transfer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferResponse {\n");
    
    sb.append("    authInfo: ").append(toIndentedString(authInfo)).append("\n");
    sb.append("    transfer: ").append(toIndentedString(transfer)).append("\n");
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

