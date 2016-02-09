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
    public partial class Transaction :  IEquatable<Transaction>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Transaction" /> class.
        /// </summary>
        public Transaction()
        {
            
        }

        
        /// <summary>
        /// ID of account transaction is from
        /// </summary>
        /// <value>ID of account transaction is from</value>
        public string AccountId { get; set; }

        
        /// <summary>
        /// ID of this transaction
        /// </summary>
        /// <value>ID of this transaction</value>
        public string TransactionId { get; set; }

        
        /// <summary>
        /// Type of transaction
        /// </summary>
        /// <value>Type of transaction</value>
        public string TransactionType { get; set; }

        
        /// <summary>
        /// Amount of transaction (can be positive or negative)
        /// </summary>
        /// <value>Amount of transaction (can be positive or negative)</value>
        public float? Amount { get; set; }

        
        /// <summary>
        /// Currency type of the amount
        /// </summary>
        /// <value>Currency type of the amount</value>
        public string CurrencyCode { get; set; }

        
        /// <summary>
        /// Category of transaction if provided
        /// </summary>
        /// <value>Category of transaction if provided</value>
        public string Category { get; set; }

        
        /// <summary>
        /// Status of transaction
        /// </summary>
        /// <value>Status of transaction</value>
        public string Status { get; set; }

        
        /// <summary>
        /// Check number of transaction is a check
        /// </summary>
        /// <value>Check number of transaction is a check</value>
        public int? CheckNumber { get; set; }

        
        /// <summary>
        /// Date of transaction
        /// </summary>
        /// <value>Date of transaction</value>
        public DateTime? TransactionDate { get; set; }

        
        /// <summary>
        /// Date of transaction
        /// </summary>
        /// <value>Date of transaction</value>
        public DateTime? PostDate { get; set; }

        
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
            sb.Append("class Transaction {\n");
            sb.Append("  AccountId: ").Append(AccountId).Append("\n");
            sb.Append("  TransactionId: ").Append(TransactionId).Append("\n");
            sb.Append("  TransactionType: ").Append(TransactionType).Append("\n");
            sb.Append("  Amount: ").Append(Amount).Append("\n");
            sb.Append("  CurrencyCode: ").Append(CurrencyCode).Append("\n");
            sb.Append("  Category: ").Append(Category).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  CheckNumber: ").Append(CheckNumber).Append("\n");
            sb.Append("  TransactionDate: ").Append(TransactionDate).Append("\n");
            sb.Append("  PostDate: ").Append(PostDate).Append("\n");
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
            return Equals((Transaction)obj);
        }

        /// <summary>
        /// Returns true if Transaction instances are equal
        /// </summary>
        /// <param name="other">Instance of Transaction to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Transaction other)
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
                    this.TransactionId == other.TransactionId ||
                    this.TransactionId != null &&
                    this.TransactionId.Equals(other.TransactionId)
                ) && 
                (
                    this.TransactionType == other.TransactionType ||
                    this.TransactionType != null &&
                    this.TransactionType.Equals(other.TransactionType)
                ) && 
                (
                    this.Amount == other.Amount ||
                    this.Amount != null &&
                    this.Amount.Equals(other.Amount)
                ) && 
                (
                    this.CurrencyCode == other.CurrencyCode ||
                    this.CurrencyCode != null &&
                    this.CurrencyCode.Equals(other.CurrencyCode)
                ) && 
                (
                    this.Category == other.Category ||
                    this.Category != null &&
                    this.Category.Equals(other.Category)
                ) && 
                (
                    this.Status == other.Status ||
                    this.Status != null &&
                    this.Status.Equals(other.Status)
                ) && 
                (
                    this.CheckNumber == other.CheckNumber ||
                    this.CheckNumber != null &&
                    this.CheckNumber.Equals(other.CheckNumber)
                ) && 
                (
                    this.TransactionDate == other.TransactionDate ||
                    this.TransactionDate != null &&
                    this.TransactionDate.Equals(other.TransactionDate)
                ) && 
                (
                    this.PostDate == other.PostDate ||
                    this.PostDate != null &&
                    this.PostDate.Equals(other.PostDate)
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
                
                    if (this.TransactionId != null)
                    hash = hash * 59 + this.TransactionId.GetHashCode();
                
                    if (this.TransactionType != null)
                    hash = hash * 59 + this.TransactionType.GetHashCode();
                
                    if (this.Amount != null)
                    hash = hash * 59 + this.Amount.GetHashCode();
                
                    if (this.CurrencyCode != null)
                    hash = hash * 59 + this.CurrencyCode.GetHashCode();
                
                    if (this.Category != null)
                    hash = hash * 59 + this.Category.GetHashCode();
                
                    if (this.Status != null)
                    hash = hash * 59 + this.Status.GetHashCode();
                
                    if (this.CheckNumber != null)
                    hash = hash * 59 + this.CheckNumber.GetHashCode();
                
                    if (this.TransactionDate != null)
                    hash = hash * 59 + this.TransactionDate.GetHashCode();
                
                    if (this.PostDate != null)
                    hash = hash * 59 + this.PostDate.GetHashCode();
                
                    if (this.Meta != null)
                    hash = hash * 59 + this.Meta.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(Transaction left, Transaction right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(Transaction left, Transaction right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
