package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class Category   {
  
  private String categoryId = null;
  private String name = null;
  private List<String> alias = new ArrayList<String>();

  
  /**
   * ID of transaction category
   **/
  
  @ApiModelProperty(value = "ID of transaction category")
  @JsonProperty("category_id")
  public String getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  
  /**
   * Name of transaction category
   **/
  
  @ApiModelProperty(value = "Name of transaction category")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Optional alternative names for this category
   **/
  
  @ApiModelProperty(value = "Optional alternative names for this category")
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
    Category category = (Category) o;
    return Objects.equals(categoryId, category.categoryId) &&
        Objects.equals(name, category.name) &&
        Objects.equals(alias, category.alias);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, name, alias);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
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

