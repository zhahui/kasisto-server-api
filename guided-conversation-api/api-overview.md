# Kasisto Dynamic Guided Conversations<br>Webhook API Overview

### Version information
*Version* : 0.9 alpha 1


### Contact information
*Contact* : Kasisto  
*Contact Email* : info@kasisto.com

## Table of Contents
- [Authentication](#authentication)
- [Authorization](#authorization)
- [Tracking](#tracking)
- [Multi-language support](#multi-language-support)
- [Exception handling](#exception-handling)
- [Guided Conversation Methods](#guided-conversation-methods)
  * [/start_conversation](#start-conversation)
  * [/send_user_input](#send-user-input)
- [Schema definitions](#schema-definitions)

## Authentication
The Kasisto API requires all requests to include a secret key header value used for request authentication. Kasisto will include the secret key header in each request from our servers. API implementations must validate the secret is correct.
Server implementations should return a 401 HTTP status code response if authentication fails.

## Authorization
The Kasisto API allows requests to include a user authorization token header value.  This token should be validated on the server implementation to match the provided user_id value and that is has the necessary privileges to access the requested information.
Server implementations should return a 403 HTTP status code response if authorization fails.

## Tracking
The Kasisto API requests include a unique request identifier. This identifier is provided as a request_id field in the HTTP Request header. This request_id can be used to track the requests when investigating execution logs.

## Multi-language support
It should be noted that Server's implementing Webhooks are responsible for supporting internationalization when interpreting results as well as generating user outputs through NLG. KAI requests sent to the Webhook include the HTTP request header parameter *locale*. This parameter can be used to distinguish different locales before generating a response.

## Exception handling
All services using the Kasisto API should follow the same exception handling mechanism.

1) When the customer is authenticated, KAI receives a token from the Server. (Please check the KAI Conversational API specs for details on the available login flows)
<br>Once KAI has a token for a customer, it provides it in the HTTP headers fields of the request.<br>The Server's services are in charge of verifying the access rights before returning the data.

2) When a service executes successfully, it should return a HTTP status 200.

3) When an error occurs, the server should return a different HTTP status code depending on the type of the error and the response should follow the [error_response](#error_response) format.

| Status | Description | Trigger | 
| ------ | ----------- | ----------- | 
| 401 | Authentication Failed | The backend service failed to authenticate the user.<br>This error can occur when the token provided by KAI is invalid or missing.| 
| 403 | Access Denied |  The token provided by KAI is invalid or it expired.<br>KAI should obtain another token before retrying the call. |
| 450 | One-Time Password is required | *not yet supported* |
| 500 | Server Error | A server error occurred when processing the request.<br>When this error is returned, KAI terminates the form input and take over the conversation. |

## Guided Conversation Methods
### Start conversation

```
POST /start_conversation
```

This service initiates a new conversation between the User and the Webhook.

#### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header |
| token | header |
| locale | header |
| request_id | header |
| Date | header |
| [start_conversation_request](#start_conversation_request) | body |

#### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | conversation response | [conversation_response](#conversation_response) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |

#### Sample Request 

```http
POST /start_conversation HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
```
```json
{
    "user_id": "string",
    "form_name": "renew_card",
    "user_inputs": [
        { "name": "card_number", "value": "1234" },
        { "name": "card_expiry_date", "value": "19/02/2019" }
    ]
}
```

##### Notes:

1) Authenticated and unauthenticated user can trigger a conversation.

    a) If the user is authenticated, KAI will include a session *token* in the HTTP request header and a *user_id* in the request payload.

    b) If the user is not authenticated, the 2 fields **will not be set**.

    c) The Webhook should check for authorizations as explained in the [Exception handling](#exception-handling) section. 

    d) For unauthenticated users, depending on the form the Webhook should ask the user to login or allow him to proceed unauthenticated.

2) When KAI starts a new conversation, it sends the form name to use in the *form_name* field. Note that *form_name* is the unique identifier of a form. Different forms can't share the same name.

3) If the user's sentence contains *slots*, KAI identifies the *slots* values and pushes them to the service in the *user_inputs* structure.  

4) The definition of the *form name* and for the possible *slots* should be in sync between KAI and the Webhook. For each form, we should define a shared definition:

| Form name | Field name | Field type |
| --------- | -------- | -------- |
| renew_card | card_number<br> card_expiry_date |Number<br>Datetime |


#### Sample Response 

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
{
    "form_id": "string",
    "message_contents": [
        {
            "type" : "TEXT",
            "payload": {
                "text": "What is the expiration date of your card?"
            }
        }
    ],
    "form_state": "pending_user",
    "request_user_input": {
        "name": "card_expiry_date",
        "type": "Datetime"
    }
}
```

##### Notes:

1) When the conversation state is initiated in the Webhook, the Webhook returns to KAI a unique *form_id*. This field will be used during the conversation to send additional user inputs to the Webhook.

2) The Webhook is in charge of the Natural Language Generation (NLG). It will create all the messages sent to the user to ask for clarifications or to provide him with information. KAI will only pass-through the messages. Check [NLG Message templates](nlg-message-templates.md) for more details.

3) The *form_state* field indicates to KAI the status of the form.
Possible values are [ *pending_user*, *completed*, *cancelled*, *failed* ].

4) If the Webhook needs additional user inputs to process the user request, it can ask KAI to capture it with a *request_user_input* block.
The *request_user_input* specifies:

    a) The *name* of the input to be captured. 

    b) The *type* of the expected input. This type will tell KAI what type of input it should expect from the user (a date, a number, etc.). Check [NLU User input types](nlu-input-types.md) for more details.


### Send user input

```
POST /send_user_input
```

This service submits a user input to the Webhook to continue an existing conversation.

#### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header |
| token | header |
| locale | header |
| request_id | header |
| Date | header |
| [send_user_input_request](#send_user_input_request) | body |

#### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | conversation response | [conversation_response](#conversation_response) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |

#### Sample Request 

```http
POST /send_user_input HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
```
```json
{
    "user_id": "string",
    "form_id": "string",
    "user_inputs": [
        { "name": "card_expiry_date", "value": "19/02/2019" }
    ]
}
```

##### Notes:

1) This service is called when the user is in the middle of a guided conversation and KAI receives an input from the user that matches the input type expected by the Webhook.

2) The request contains the *form_id* of the conversation that was initiated by the *start_conversation* service.

3) The *user_inputs* bloc contains the *name* of the field that the Webhook asked to capture in the previous call.

4) The data in the *value* field is normalized:
| Input type | Pattern | Comment |
| --------- | -------- | -------- |
| Boolean | "true" / "false" | String value of the boolean |
| Number | - | String value of the number |
| String | - | Contains the full text input from the user |
| Datetime | "yyyy-MM-dd’T’HH:mm:ssZ" | In ISO-8601 format |
| Email | xxx@xxx.xxx | Email address |

#### Sample Response 

This service uses the exact same response object as the *start_conversation* service.

## Schema Definitions

#### start_conversation_request

```json
{
    "user_id": "string",
    "form_name": "string",
    "user_inputs": [
        { "name": "string", "value": "string" }
    ]
}
```

#### send_user_input_request

```json
{
    "user_id": "string",
    "form_id": "string",
    "user_inputs": [
        { "name": "string", "value": "string" }
    ]
}
```

#### conversation_response

```json
{
    "form_id": "string",
    "message_contents": [
        {
            "type" : "TEXT",
            "payload": {
                "text": "string"
            }
        }
    ],
    "form_state": "string",
    "request_user_input": {
        "name": "string",
        "type": "string"
    }
}
```

#### error_response

```json
{
    "message": "string",
    "code": "string",
    "otp_details": "string",
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]
}
```
