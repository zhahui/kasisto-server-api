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
    public partial class TransferResponse :  IEquatable<TransferResponse>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="TransferResponse" /> class.
        /// </summary>
        public TransferResponse()
        {
            
        }

        
        /// <summary>
        /// Gets or Sets AuthInfo
        /// </summary>
        public AuthInfo AuthInfo { get; set; }

        
        /// <summary>
        /// Gets or Sets Transfer
        /// </summary>
        public Transfer Transfer { get; set; }

        

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class TransferResponse {\n");
            sb.Append("  AuthInfo: ").Append(AuthInfo).Append("\n");
            sb.Append("  Transfer: ").Append(Transfer).Append("\n");
            
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
            return Equals((TransferResponse)obj);
        }

        /// <summary>
        /// Returns true if TransferResponse instances are equal
        /// </summary>
        /// <param name="other">Instance of TransferResponse to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(TransferResponse other)
        {

            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    this.AuthInfo == other.AuthInfo ||
                    this.AuthInfo != null &&
                    this.AuthInfo.Equals(other.AuthInfo)
                ) && 
                (
                    this.Transfer == other.Transfer ||
                    this.Transfer != null &&
                    this.Transfer.Equals(other.Transfer)
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
                
                    if (this.AuthInfo != null)
                    hash = hash * 59 + this.AuthInfo.GetHashCode();
                
                    if (this.Transfer != null)
                    hash = hash * 59 + this.Transfer.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(TransferResponse left, TransferResponse right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(TransferResponse left, TransferResponse right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
