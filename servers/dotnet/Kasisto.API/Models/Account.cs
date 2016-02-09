using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace Kasisto.API.Models
{
    /// <summary>
    /// 
    /// </summary>
    public partial class Account :  IEquatable<Account>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Account" /> class.
        /// </summary>
        public Account()
        {
            
        }

        
        /// <summary>
        /// internal ID used by bank for transaction search API
        /// </summary>
        /// <value>internal ID used by bank for transaction search API</value>
        public string AccountId { get; set; }

        
        /// <summary>
        /// number used by kasisto - may be masked
        /// </summary>
        /// <value>number used by kasisto - may be masked</value>
        public string AccountNumber { get; set; }

        
        /// <summary>
        /// account name or nickname
        /// </summary>
        /// <value>account name or nickname</value>
        public string AccountName { get; set; }

        
        /// <summary>
        /// checking,savings,loan,credit_card
        /// </summary>
        /// <value>checking,savings,loan,credit_card</value>
        public string AccountType { get; set; }

        
        /// <summary>
        /// currency of amounts (USD, etc.)
        /// </summary>
        /// <value>currency of amounts (USD, etc.)</value>
        public string CurrencyCode { get; set; }

        
        /// <summary>
        /// Gets or Sets AvailableBalance
        /// </summary>
        public float? AvailableBalance { get; set; }

        
        /// <summary>
        /// Gets or Sets CurrentBalance
        /// </summary>
        public float? CurrentBalance { get; set; }

        
        /// <summary>
        /// (for credit_card only)
        /// </summary>
        /// <value>(for credit_card only)</value>
        public string AvailableCredit { get; set; }

        
        /// <summary>
        /// (for credit_card and loan)
        /// </summary>
        /// <value>(for credit_card and loan)</value>
        public DateTime? PaymentDueDate { get; set; }

        
        /// <summary>
        /// (for credit_card and loan)
        /// </summary>
        /// <value>(for credit_card and loan)</value>
        public float? PaymentDueAmount { get; set; }

        
        /// <summary>
        /// Interest rate if applicable
        /// </summary>
        /// <value>Interest rate if applicable</value>
        public float? InterestRate { get; set; }

        
        /// <summary>
        /// Optional data if needed for application
        /// </summary>
        /// <value>Optional data if needed for application</value>
        public List<MetaField> Meta { get; set; }

        

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Account {\n");
            sb.Append("  AccountId: ").Append(AccountId).Append("\n");
            sb.Append("  AccountNumber: ").Append(AccountNumber).Append("\n");
            sb.Append("  AccountName: ").Append(AccountName).Append("\n");
            sb.Append("  AccountType: ").Append(AccountType).Append("\n");
            sb.Append("  CurrencyCode: ").Append(CurrencyCode).Append("\n");
            sb.Append("  AvailableBalance: ").Append(AvailableBalance).Append("\n");
            sb.Append("  CurrentBalance: ").Append(CurrentBalance).Append("\n");
            sb.Append("  AvailableCredit: ").Append(AvailableCredit).Append("\n");
            sb.Append("  PaymentDueDate: ").Append(PaymentDueDate).Append("\n");
            sb.Append("  PaymentDueAmount: ").Append(PaymentDueAmount).Append("\n");
            sb.Append("  InterestRate: ").Append(InterestRate).Append("\n");
            sb.Append("  Meta: ").Append(Meta).Append("\n");
            
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != GetType()) return false;
            return Equals((Account)obj);
        }

        /// <summary>
        /// Returns true if Account instances are equal
        /// </summary>
        /// <param name="other">Instance of Account to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Account other)
        {

            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    this.AccountId == other.AccountId ||
                    this.AccountId != null &&
                    this.AccountId.Equals(other.AccountId)
                ) && 
                (
                    this.AccountNumber == other.AccountNumber ||
                    this.AccountNumber != null &&
                    this.AccountNumber.Equals(other.AccountNumber)
                ) && 
                (
                    this.AccountName == other.AccountName ||
                    this.AccountName != null &&
                    this.AccountName.Equals(other.AccountName)
                ) && 
                (
                    this.AccountType == other.AccountType ||
                    this.AccountType != null &&
                    this.AccountType.Equals(other.AccountType)
                ) && 
                (
                    this.CurrencyCode == other.CurrencyCode ||
                    this.CurrencyCode != null &&
                    this.CurrencyCode.Equals(other.CurrencyCode)
                ) && 
                (
                    this.AvailableBalance == other.AvailableBalance ||
                    this.AvailableBalance != null &&
                    this.AvailableBalance.Equals(other.AvailableBalance)
                ) && 
                (
                    this.CurrentBalance == other.CurrentBalance ||
                    this.CurrentBalance != null &&
                    this.CurrentBalance.Equals(other.CurrentBalance)
                ) && 
                (
                    this.AvailableCredit == other.AvailableCredit ||
                    this.AvailableCredit != null &&
                    this.AvailableCredit.Equals(other.AvailableCredit)
                ) && 
                (
                    this.PaymentDueDate == other.PaymentDueDate ||
                    this.PaymentDueDate != null &&
                    this.PaymentDueDate.Equals(other.PaymentDueDate)
                ) && 
                (
                    this.PaymentDueAmount == other.PaymentDueAmount ||
                    this.PaymentDueAmount != null &&
                    this.PaymentDueAmount.Equals(other.PaymentDueAmount)
                ) && 
                (
                    this.InterestRate == other.InterestRate ||
                    this.InterestRate != null &&
                    this.InterestRate.Equals(other.InterestRate)
                ) && 
                (
                    this.Meta == other.Meta ||
                    this.Meta != null &&
                    this.Meta.SequenceEqual(other.Meta)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            // credit: http://stackoverflow.com/a/263416/677735
            unchecked // Overflow is fine, just wrap
            {
                int hash = 41;
                // Suitable nullity checks etc, of course :)
                
                    if (this.AccountId != null)
                    hash = hash * 59 + this.AccountId.GetHashCode();
                
                    if (this.AccountNumber != null)
                    hash = hash * 59 + this.AccountNumber.GetHashCode();
                
                    if (this.AccountName != null)
                    hash = hash * 59 + this.AccountName.GetHashCode();
                
                    if (this.AccountType != null)
                    hash = hash * 59 + this.AccountType.GetHashCode();
                
                    if (this.CurrencyCode != null)
                    hash = hash * 59 + this.CurrencyCode.GetHashCode();
                
                    if (this.AvailableBalance != null)
                    hash = hash * 59 + this.AvailableBalance.GetHashCode();
                
                    if (this.CurrentBalance != null)
                    hash = hash * 59 + this.CurrentBalance.GetHashCode();
                
                    if (this.AvailableCredit != null)
                    hash = hash * 59 + this.AvailableCredit.GetHashCode();
                
                    if (this.PaymentDueDate != null)
                    hash = hash * 59 + this.PaymentDueDate.GetHashCode();
                
                    if (this.PaymentDueAmount != null)
                    hash = hash * 59 + this.PaymentDueAmount.GetHashCode();
                
                    if (this.InterestRate != null)
                    hash = hash * 59 + this.InterestRate.GetHashCode();
                
                    if (this.Meta != null)
                    hash = hash * 59 + this.Meta.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(Account left, Account right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(Account left, Account right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
