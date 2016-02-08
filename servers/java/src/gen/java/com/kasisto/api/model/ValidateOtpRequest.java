package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class ValidateOtpRequest   {
  
  private String userId = null;
  private String otp = null;

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("user_id")
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("otp")
  public String getOtp() {
    return otp;
  }
  public void setOtp(String otp) {
    this.otp = otp;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateOtpRequest validateOtpRequest = (ValidateOtpRequest) o;
    return Objects.equals(userId, validateOtpRequest.userId) &&
        Objects.equals(otp, validateOtpRequest.otp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, otp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateOtpRequest {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    otp: ").append(toIndentedString(otp)).append("\n");
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

