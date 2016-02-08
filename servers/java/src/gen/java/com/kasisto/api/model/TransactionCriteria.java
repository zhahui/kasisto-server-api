package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class TransactionCriteria   {
  
  private String userId = null;
  private List<String> accountIds = new ArrayList<String>();
  private Integer limit = null;

  
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
  @JsonProperty("account_ids")
  public List<String> getAccountIds() {
    return accountIds;
  }
  public void setAccountIds(List<String> accountIds) {
    this.accountIds = accountIds;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionCriteria transactionCriteria = (TransactionCriteria) o;
    return Objects.equals(userId, transactionCriteria.userId) &&
        Objects.equals(accountIds, transactionCriteria.accountIds) &&
        Objects.equals(limit, transactionCriteria.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, accountIds, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionCriteria {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    accountIds: ").append(toIndentedString(accountIds)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

