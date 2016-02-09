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
    public partial class TokenCredentials :  IEquatable<TokenCredentials>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="TokenCredentials" /> class.
        /// </summary>
        public TokenCredentials()
        {
            
        }

        
        /// <summary>
        /// Gets or Sets Username
        /// </summary>
        public string Username { get; set; }

        
        /// <summary>
        /// Gets or Sets Password
        /// </summary>
        public string Password { get; set; }

        

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class TokenCredentials {\n");
            sb.Append("  Username: ").Append(Username).Append("\n");
            sb.Append("  Password: ").Append(Password).Append("\n");
            
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
            return Equals((TokenCredentials)obj);
        }

        /// <summary>
        /// Returns true if TokenCredentials instances are equal
        /// </summary>
        /// <param name="other">Instance of TokenCredentials to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(TokenCredentials other)
        {

            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    this.Username == other.Username ||
                    this.Username != null &&
                    this.Username.Equals(other.Username)
                ) && 
                (
                    this.Password == other.Password ||
                    this.Password != null &&
                    this.Password.Equals(other.Password)
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
                
                    if (this.Username != null)
                    hash = hash * 59 + this.Username.GetHashCode();
                
                    if (this.Password != null)
                    hash = hash * 59 + this.Password.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(TokenCredentials left, TokenCredentials right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(TokenCredentials left, TokenCredentials right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
