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
    public class TransactionsApiController : Controller
    { 

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Get transaction categories</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="categoriesRequest"></param>
        /// <response code="200">categories response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        [HttpPost]
        [Route("/categories")]
        [SwaggerOperation("CategoriesPost")]
        [SwaggerResponse(200, type: typeof(List<Category>))]
        public IActionResult CategoriesPost([FromHeader]string secret, [FromHeader]string token, [FromBody]CategoriesRequest categoriesRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<List<Category>>(exampleJson)
            : default(List<Category>);
            
            return new ObjectResult(example);
        }


        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Get merchants</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="merchantsRequest"></param>
        /// <response code="200">merchants response</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        [HttpPost]
        [Route("/merchants")]
        [SwaggerOperation("MerchantsPost")]
        [SwaggerResponse(200, type: typeof(List<Merchant>))]
        public IActionResult MerchantsPost([FromHeader]string secret, [FromHeader]string token, [FromBody]MerchantsRequest merchantsRequest)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<List<Merchant>>(exampleJson)
            : default(List<Merchant>);
            
            return new ObjectResult(example);
        }


        /// <summary>
        /// 
        /// </summary>
        /// <remarks>Search customer transactions</remarks>
        /// <param name="secret"></param>
        /// <param name="token"></param>
        /// <param name="transactionCriteria"></param>
        /// <response code="200">transactions</response>
        /// <response code="401">Authentication Failed</response>
        /// <response code="403">Access Denied</response>
        /// <response code="450">One-Time Password is required</response>
        [HttpPost]
        [Route("/transactions")]
        [SwaggerOperation("TransactionsPost")]
        [SwaggerResponse(200, type: typeof(List<Transaction>))]
        public IActionResult TransactionsPost([FromHeader]string secret, [FromHeader]string token, [FromBody]TransactionCriteria transactionCriteria)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<List<Transaction>>(exampleJson)
            : default(List<Transaction>);
            
            return new ObjectResult(example);
        }
    }
}
