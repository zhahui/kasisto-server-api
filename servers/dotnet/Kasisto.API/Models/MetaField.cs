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
    public partial class MetaField :  IEquatable<MetaField>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="MetaField" /> class.
        /// </summary>
        public MetaField()
        {
            
        }

        
        /// <summary>
        /// Name of data field
        /// </summary>
        /// <value>Name of data field</value>
        public string Name { get; set; }

        
        /// <summary>
        /// Value of data field
        /// </summary>
        /// <value>Value of data field</value>
        public string Value { get; set; }

        

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class MetaField {\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  Value: ").Append(Value).Append("\n");
            
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
            return Equals((MetaField)obj);
        }

        /// <summary>
        /// Returns true if MetaField instances are equal
        /// </summary>
        /// <param name="other">Instance of MetaField to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MetaField other)
        {

            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    this.Name == other.Name ||
                    this.Name != null &&
                    this.Name.Equals(other.Name)
                ) && 
                (
                    this.Value == other.Value ||
                    this.Value != null &&
                    this.Value.Equals(other.Value)
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
                
                    if (this.Name != null)
                    hash = hash * 59 + this.Name.GetHashCode();
                
                    if (this.Value != null)
                    hash = hash * 59 + this.Value.GetHashCode();
                
                return hash;
            }
        }

        #region Operators

        public static bool operator ==(MetaField left, MetaField right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(MetaField left, MetaField right)
        {
            return !Equals(left, right);
        }

        #endregion Operators

    }
}
