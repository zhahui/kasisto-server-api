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
    public class PaymentsApiController : Controller
    { 

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Get list of payees for a user</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="payeesRequest"></param>
        /// <response code="200">payees response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        [HttpPost]
        [Route("/payees")]
        [SwaggerOperation("PayeesPost")]
        [SwaggerResponse(200, type: typeof(List<Payee>))]
        public IActionResult PayeesPost([FromHeader]string secret, [FromHeader]string token, [FromBody]PayeesRequest payeesRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<List<Payee>>(exampleJson)
            : default(List<Payee>);
            
            return new ObjectResult(example);
        }


        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Pay funds to a payee</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="paymentRequest"></param>
        /// <response code="200">payment response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        /// <response code="450">One-Time Password is required</response>
        [HttpPost]
        [Route("/payment")]
        [SwaggerOperation("PaymentPost")]
        [SwaggerResponse(200, type: typeof(Payment))]
        public IActionResult PaymentPost([FromHeader]string secret, [FromHeader]string token, [FromBody]PaymentRequest paymentRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<Payment>(exampleJson)
            : default(Payment);
            
            return new ObjectResult(example);
        }
    }
}
