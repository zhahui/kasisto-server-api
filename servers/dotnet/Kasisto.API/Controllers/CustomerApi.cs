using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using Microsoft.AspNet.Mvc;
using Newtonsoft.Json;
using Swashbuckle.SwaggerGen.Annotations;
using Kasisto.API.Models;

namespace Kasisto.API.Controllers
{ 
    /// <summary>
    /// 
    /// </summary>
    public class CustomerApiController : Controller
    { 

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Get customer object</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="customerRequest"></param>
        /// <response code="200">customer response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        /// <response code="450">One-Time Password is required</response>
        [HttpPost]
        [Route("/customer")]
        [SwaggerOperation("CustomerPost")]
        [SwaggerResponse(200, type: typeof(Customer))]
        public IActionResult CustomerPost([FromHeader]string secret, [FromHeader]string token, [FromBody]CustomerRequest customerRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<Customer>(exampleJson)
            : default(Customer);
            
            return new ObjectResult(example);
        }


        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Get access token for a customer</remarks>
        /// <param name="secret"></param>
        /// <param name="tokenCredentials"></param>
        /// <response code="200">token response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        [HttpPost]
        [Route("/token")]
        [SwaggerOperation("TokenPost")]
        [SwaggerResponse(200, type: typeof(TokenResponse))]
        public IActionResult TokenPost([FromHeader]string secret, [FromBody]TokenCredentials tokenCredentials)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<TokenResponse>(exampleJson)
            : default(TokenResponse);
            
            return new ObjectResult(example);
        }


        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Validate One-Time Password and return new user token</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="validateOtpRequest"></param>
        /// <response code="200">token response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        /// <response code="451">Invalid One-Time Password</response>
        /// <response code="452">Expired One-Time Password</response>
        /// <response code="453">Too Many One-Time Password Failures</response>
        [HttpPost]
        [Route("/validate_otp")]
        [SwaggerOperation("ValidateOtpPost")]
        [SwaggerResponse(200, type: typeof(ValidateOtpResponse))]
        public IActionResult ValidateOtpPost([FromHeader]string secret, [FromHeader]string token, [FromBody]ValidateOtpRequest validateOtpRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<ValidateOtpResponse>(exampleJson)
            : default(ValidateOtpResponse);
            
            return new ObjectResult(example);
        }
    }
}
