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
    public partial class AuthInfo :  IEquatable<AuthInfo>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="AuthInfo" /> class.
        /// </summary>
        public AuthInfo()
        {
            
        }

        
        /// <summary>
        /// New valid token if using SSO tokens
        /// </summary>
        /// <value>New valid token if using SSO tokens</value>
        public string Token { get; set; }

        
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
            sb.Append("class AuthInfo {\n");
            sb.Append("  Token: ").Append(Token).Append("\n");
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
            return Equals((AuthInfo)obj);
        }

        /// <summary>
        /// Returns true if AuthInfo instances are equal
        /// </summary>
        /// <param name="other">Instance of AuthInfo to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(AuthInfo other)
        {

            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    this.Token == other.Token ||
                    this.Token != null &&
                    this.Token.Equals(other.Token)
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
                
                    if (this.Token != null)
                    hash = hash * 59 + this.Token.GetHashCode();
                
                    if (this.Meta != null)
                    hash = hash * 59 + this.Meta.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(AuthInfo left, AuthInfo right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(AuthInfo left, AuthInfo right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
