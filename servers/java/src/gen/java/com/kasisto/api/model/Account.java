package com.kasisto.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.kasisto.api.model.MetaField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;
import java.util.Date;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-02-08T11:56:06.345-05:00")
public class Account   {
  
  private String accountId = null;
  private String accountNumber = null;
  private String accountName = null;


  public enum AccountTypeEnum {
    CD("cd"),
    CHECKING("checking"),
    CREDIT_CARD("credit_card"),
    HELOC("heloc"),
    IRA("ira"),
    INVESTMENT("investment"),
    LOC("loc"),
    LOAN("loan"),
    MONEY_MARKET("money_market"),
    MORTGAGE("mortgage"),
    OVERDRAFT_PROTECTION("overdraft_protection"),
    SLOC("sloc"),
    SAVINGS("savings"),
    WIRE("wire"),
    UNSPECIFIED("unspecified");

    private String value;

    AccountTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private AccountTypeEnum accountType = null;
  private String currencyCode = null;
  private Float availableBalance = null;
  private Float currentBalance = null;
  private Float availableCredit = null;
  private Date paymentDueDate = null;
  private Float paymentDueAmount = null;
  private Float interestRate = null;
  private List<MetaField> meta = new ArrayList<MetaField>();

  
  /**
   * internal ID used by bank for transaction search API
   **/
  
  @ApiModelProperty(value = "internal ID used by bank for transaction search API")
  @JsonProperty("account_id")
  public String getAccountId() {
    return accountId;
  }
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  
  /**
   * number used by kasisto - may be masked
   **/
  
  @ApiModelProperty(value = "number used by kasisto - may be masked")
  @JsonProperty("account_number")
  public String getAccountNumber() {
    return accountNumber;
  }
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  
  /**
   * account name or nickname
   **/
  
  @ApiModelProperty(value = "account name or nickname")
  @JsonProperty("account_name")
  public String getAccountName() {
    return accountName;
  }
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  
  /**
   * checking,savings,loan,credit_card
   **/
  
  @ApiModelProperty(value = "checking,savings,loan,credit_card")
  @JsonProperty("account_type")
  public AccountTypeEnum getAccountType() {
    return accountType;
  }
  public void setAccountType(AccountTypeEnum accountType) {
    this.accountType = accountType;
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
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("available_balance")
  public Float getAvailableBalance() {
    return availableBalance;
  }
  public void setAvailableBalance(Float availableBalance) {
    this.availableBalance = availableBalance;
  }

  
  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("current_balance")
  public Float getCurrentBalance() {
    return currentBalance;
  }
  public void setCurrentBalance(Float currentBalance) {
    this.currentBalance = currentBalance;
  }

  
  /**
   * (for credit_card only)
   **/
  
  @ApiModelProperty(value = "(for credit_card only)")
  @JsonProperty("available_credit")
  public Float getAvailableCredit() {
    return availableCredit;
  }
  public void setAvailableCredit(Float availableCredit) {
    this.availableCredit = availableCredit;
  }

  
  /**
   * (for credit_card and loan)
   **/
  
  @ApiModelProperty(value = "(for credit_card and loan)")
  @JsonProperty("payment_due_date")
  public Date getPaymentDueDate() {
    return paymentDueDate;
  }
  public void setPaymentDueDate(Date paymentDueDate) {
    this.paymentDueDate = paymentDueDate;
  }

  
  /**
   * (for credit_card and loan)
   **/
  
  @ApiModelProperty(value = "(for credit_card and loan)")
  @JsonProperty("payment_due_amount")
  public Float getPaymentDueAmount() {
    return paymentDueAmount;
  }
  public void setPaymentDueAmount(Float paymentDueAmount) {
    this.paymentDueAmount = paymentDueAmount;
  }

  
  /**
   * Interest rate if applicable
   **/
  
  @ApiModelProperty(value = "Interest rate if applicable")
  @JsonProperty("interest_rate")
  public Float getInterestRate() {
    return interestRate;
  }
  public void setInterestRate(Float interestRate) {
    this.interestRate = interestRate;
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
    Account account = (Account) o;
    return Objects.equals(accountId, account.accountId) &&
        Objects.equals(accountNumber, account.accountNumber) &&
        Objects.equals(accountName, account.accountName) &&
        Objects.equals(accountType, account.accountType) &&
        Objects.equals(currencyCode, account.currencyCode) &&
        Objects.equals(availableBalance, account.availableBalance) &&
        Objects.equals(currentBalance, account.currentBalance) &&
        Objects.equals(availableCredit, account.availableCredit) &&
        Objects.equals(paymentDueDate, account.paymentDueDate) &&
        Objects.equals(paymentDueAmount, account.paymentDueAmount) &&
        Objects.equals(interestRate, account.interestRate) &&
        Objects.equals(meta, account.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountNumber, accountName, accountType, currencyCode, availableBalance, currentBalance, availableCredit, paymentDueDate, paymentDueAmount, interestRate, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    currentBalance: ").append(toIndentedString(currentBalance)).append("\n");
    sb.append("    availableCredit: ").append(toIndentedString(availableCredit)).append("\n");
    sb.append("    paymentDueDate: ").append(toIndentedString(paymentDueDate)).append("\n");
    sb.append("    paymentDueAmount: ").append(toIndentedString(paymentDueAmount)).append("\n");
    sb.append("    interestRate: ").append(toIndentedString(interestRate)).append("\n");
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

