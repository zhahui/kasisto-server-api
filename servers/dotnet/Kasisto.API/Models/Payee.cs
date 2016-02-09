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
    public partial class Payee :  IEquatable<Payee>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Payee" /> class.
        /// </summary>
        public Payee()
        {
            
        }

        
        /// <summary>
        /// ID of payee
        /// </summary>
        /// <value>ID of payee</value>
        public string PayeeId { get; set; }

        
        /// <summary>
        /// Name of payee
        /// </summary>
        /// <value>Name of payee</value>
        public string Name { get; set; }

        
        /// <summary>
        /// Optional alternative names for this payee
        /// </summary>
        /// <value>Optional alternative names for this payee</value>
        public List<string> Alias { get; set; }

        

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Payee {\n");
            sb.Append("  PayeeId: ").Append(PayeeId).Append("\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  Alias: ").Append(Alias).Append("\n");
            
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
            return Equals((Payee)obj);
        }

        /// <summary>
        /// Returns true if Payee instances are equal
        /// </summary>
        /// <param name="other">Instance of Payee to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Payee other)
        {

            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    this.PayeeId == other.PayeeId ||
                    this.PayeeId != null &&
                    this.PayeeId.Equals(other.PayeeId)
                ) && 
                (
                    this.Name == other.Name ||
                    this.Name != null &&
                    this.Name.Equals(other.Name)
                ) && 
                (
                    this.Alias == other.Alias ||
                    this.Alias != null &&
                    this.Alias.SequenceEqual(other.Alias)
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
                
                    if (this.PayeeId != null)
                    hash = hash * 59 + this.PayeeId.GetHashCode();
                
                    if (this.Name != null)
                    hash = hash * 59 + this.Name.GetHashCode();
                
                    if (this.Alias != null)
                    hash = hash * 59 + this.Alias.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(Payee left, Payee right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(Payee left, Payee right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
