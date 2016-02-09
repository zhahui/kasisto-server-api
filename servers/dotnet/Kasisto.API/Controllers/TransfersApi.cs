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
    public class TransfersApiController : Controller
    { 

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Transfer funds between two accounts</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="transferRequest"></param>
        /// <response code="200">transfer response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        /// <response code="450">One-Time Password is required</response>
        [HttpPost]
        [Route("/transfer")]
        [SwaggerOperation("TransferPost")]
        [SwaggerResponse(200, type: typeof(Transfer))]
        public IActionResult TransferPost([FromHeader]string secret, [FromHeader]string token, [FromBody]TransferRequest transferRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<Transfer>(exampleJson)
            : default(Transfer);
            
            return new ObjectResult(example);
        }
    }
}
