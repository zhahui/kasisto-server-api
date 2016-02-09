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
    public partial class PaymentRequest :  IEquatable<PaymentRequest>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="PaymentRequest" /> class.
        /// </summary>
        public PaymentRequest()
        {
            
        }

        
        /// <summary>
        /// source account of payment
        /// </summary>
        /// <value>source account of payment</value>
        public string SourceAccountId { get; set; }

        
        /// <summary>
        /// destination payee of payment
        /// </summary>
        /// <value>destination payee of payment</value>
        public string PayeeId { get; set; }

        
        /// <summary>
        /// amount of transfer
        /// </summary>
        /// <value>amount of transfer</value>
        public float? Amount { get; set; }

        
        /// <summary>
        /// currency of amounts (USD, etc.)
        /// </summary>
        /// <value>currency of amounts (USD, etc.)</value>
        public string CurrencyCode { get; set; }

        
        /// <summary>
        /// date of payment
        /// </summary>
        /// <value>date of payment</value>
        public DateTime? Date { get; set; }

        

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class PaymentRequest {\n");
            sb.Append("  SourceAccountId: ").Append(SourceAccountId).Append("\n");
            sb.Append("  PayeeId: ").Append(PayeeId).Append("\n");
            sb.Append("  Amount: ").Append(Amount).Append("\n");
            sb.Append("  CurrencyCode: ").Append(CurrencyCode).Append("\n");
            sb.Append("  Date: ").Append(Date).Append("\n");
            
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
            return Equals((PaymentRequest)obj);
        }

        /// <summary>
        /// Returns true if PaymentRequest instances are equal
        /// </summary>
        /// <param name="other">Instance of PaymentRequest to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(PaymentRequest other)
        {

            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    this.SourceAccountId == other.SourceAccountId ||
                    this.SourceAccountId != null &&
                    this.SourceAccountId.Equals(other.SourceAccountId)
                ) && 
                (
                    this.PayeeId == other.PayeeId ||
                    this.PayeeId != null &&
                    this.PayeeId.Equals(other.PayeeId)
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
                    this.Date == other.Date ||
                    this.Date != null &&
                    this.Date.Equals(other.Date)
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
                
                    if (this.SourceAccountId != null)
                    hash = hash * 59 + this.SourceAccountId.GetHashCode();
                
                    if (this.PayeeId != null)
                    hash = hash * 59 + this.PayeeId.GetHashCode();
                
                    if (this.Amount != null)
                    hash = hash * 59 + this.Amount.GetHashCode();
                
                    if (this.CurrencyCode != null)
                    hash = hash * 59 + this.CurrencyCode.GetHashCode();
                
                    if (this.Date != null)
                    hash = hash * 59 + this.Date.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(PaymentRequest left, PaymentRequest right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(PaymentRequest left, PaymentRequest right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
