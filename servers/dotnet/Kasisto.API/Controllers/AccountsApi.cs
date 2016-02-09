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
    public class AccountsApiController : Controller
    { 

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Get customer accounts</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="accountsRequest"></param>
        /// <response code="200">accounts response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        /// <response code="450">One-Time Password is required</response>
        [HttpPost]
        [Route("/accounts")]
        [SwaggerOperation("AccountsPost")]
        [SwaggerResponse(200, type: typeof(List<Account>))]
        public IActionResult AccountsPost([FromHeader]string secret, [FromHeader]string token, [FromBody]AccountsRequest accountsRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<List<Account>>(exampleJson)
            : default(List<Account>);
            
            return new ObjectResult(example);
        }
    }
}
