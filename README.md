# Kasisto Integration API 1.0
Kasisto Integration API Specification for Banks and Financial Institutions

Integrate your customer data with Kasisto.

This page describes the Kasisto Integration API version 1.0.

## Quick links

- [Registering for an API secret key](register-for-a-key.md)
- [API Overview](api-overview.md)
- [Swagger API Specification](kasisto-swagger.json)

## Swagger Open API Initiative
Kasisto utylizes <a href="http://swagger.io" target="_blank">Swagger</a>.
You can turn our API spec into server-side code with <a href="https://github.com/swagger-api/swagger-codegen" target="_blank">Swagger Codegen</a>.

## Security and Authentication
The following requirements must be met:

* HTTPS
* Secret Key in request headers must be verified
* User token in request headers must be validated
* Signed payload header must be validated

## Server Side Sample Code
Server Side code samples to get you started.  Code is available for multiple languages.

### The code for these languages are up-to-date with support for all major functionality
- [Java](servers/java)
- [Python](servers/python)
- [C#](servers/dotnet)

### Additional server code can be generated using the Swagger code generator
The kasisto-swagger.json file can be used to generate server stubs in additional languages.
You can turn our API spec into server-side code with <a href="https://github.com/swagger-api/swagger-codegen" target="_blank">Swagger Codegen</a>.

