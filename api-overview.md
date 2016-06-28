# Kasisto Integration API Overview
Version 1.0 beta

- [Authentication](#authentication)
- [Authorization](#authorization)
- [Schema](#schema)
- [User Registration Methods](#user-registration-methods)
  * [/register_user](#register-user)
  * [/unregister_user](#unregister-user)
- [Customer Methods](#customer-methods)
  * [/validate_otp](#validate-otp)
  * [/customer](#customer)
  * [/token](#token)
  * [/session_token](#session-token)
  * [/revoke_token](#revoke-token)
- [Accounts Methods](#accounts-methods)
  * [/accounts](#accounts)
- [Transactions Methods](#transactions-methods)
  * [/merchants](#merchants)
  * [/transactions](#transactions)
  * [/categories](#categories)
- [Transfers Methods](#transfers-methods)
  * [/transfer](#transfer)
- [Payments Methods](#payments-methods)
  * [/payment](#payment)
  * [/payees](#payees)

## Authentication
The Kasisto API requires all requests to include a secret key header value used for request authentication.  Kasisto will include the secret key header in each request from our servers. API implementations must validate the secret is correct.
Server implementations should return a 401 HTTP status code response if authentication fails.

## Authorization
The Kasisto API allows requests to include a user authorization token header value.  This token should be validated on the server implementation to match the provided user_id value and that is has the neccessary privilages to access the requested information.
Server implementations should return a 403 HTTP status code response if authorization fails.

## Schema
All API access must be over HTTPS.  All data is sent and received as JSON.
Schema definitions are described [here](#schema-definitions).

### User Registration Methods

#### Register User

```
POST /register_user
```

Register a new KAI user with associated platform and institution accounts.

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| [register_user_request](#register_user_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | token response | [register_user_response](#register_user_response) |
| 403 | Access Denied | [error_response](#error-response) |
| 500 | Server Error | [error_response](#error-response) |

##### Sample Request / Response

```http
POST /register_user HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
```
```json
{
    "kai_user":{
        "email":"joe.smith@someplace.com",
        "first_name":"Joe",
        "last_name":"Smith"
    },
    "platform_accounts":[{
        "platform_type":"facebook",
        "account_id":"1234567890"
    }],
    "institution_accounts":[{
        "institution_name":"XYZ",
        "institution_username":"100123456789",
        "institution_token":"ABC98123018270170193810923" 
    }]
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
```
```json
{
    "user_registered": {
        "kai_user": {
            "first_name": "Joe",
            "last_name": "Smith",
            "email":"joe.smith@someplace.com"
        }
    }
}
```


#### register_user_request

```json
{
    "kai_user": {
        "email":"string (optional if platform account can provide it)",
        "first_name":"string (optional if platform account can provide it)",
        "last_name":"string (optional if platform account can provide it)"
    },
    "platform_accounts":[{
        "platform_type":"string (facebook, etc.)",
        "platform_id":"string (user's facebook ID)"
    }],
    "institution_accounts":[{
        "institution_id":"string (ID of the institution supported by KAI)",
        "institution_username":"string (username or user ID of institution account)",
        "institution_token":"string (encrypted authorization token for user)"
    }]
}
```
#### register_user_response

```json
{
    "user_registered": {
        "kai_user": {
            "first_name": "string",
            "last_name": "string",
            "email": "string"
        }
    }
}
```

#### error response

```json
{
    "error":"string",
    "message": "string"
}
```


### Customer Methods

#### Validate OTP

```
POST /validate_otp
```

Validate One-Time Password and return new user token

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [validate_otp_request](#validate_otp_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | token response | [validate_otp_response](#validate_otp_response) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 451 | Invalid One-Time Password | [error_response](#error_response) |
| 452 | Expired One-Time Password | [error_response](#error_response) |
| 453 | Too Many One-Time Password Failures | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /validate_otp HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "otp": "string", 
    "user_id": "string",
    "otp_id": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "token": "string", 
    "user_id": "string"
}
```

#### Customer

```
POST /customer
```

Get customer object

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [customer_request](#customer_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | customer response | [customer](#customer) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /customer HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "user_id": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "first_name": "string", 
    "last_name": "string", 
    "user_id": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "full_name": "string"
}
```

#### Token

```
POST /token
```

Get access token for a customer

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| [token_credentials](#token_credentials) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | token response | [token_response](#token_response) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /token HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
```
```json
{
    "username": "string", 
    "password": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "token": "string", 
    "user_id": "string"
}
```
#### Session Token

```
POST /session_token
```

Get session/refresh token for a customer

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [session_token_request](#session_token_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | token response | [token_response](#token_response) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /session_token HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
```
```json
{
    "user_id": "string", 
    "token": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "token": "string", 
    "user_id": "string"
}
```
#### Revoke Token

```
POST /revoke_token
```

Revoke a token or customer

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | token response | [token_response](#token_response) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /revoke_token HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "token": "string", 
    "user_id": "string"
}
```
### Accounts Methods

#### Accounts

```
POST /accounts
```

Get customer accounts

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [accounts_request](#accounts_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | accounts response | Array of [account](#account) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /accounts HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "user_id": "string", 
    "account_id": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
[{
    "available_credit": 0, 
    "account_type": "string", 
    "account_id": "string", 
    "payment_due_amount": 0, 
    "current_balance": 0, 
    "interest_rate": 0, 
    "payment_due_date": "2016-02-26T00:00:00.000+0000", 
    "available_balance": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "account_number": "string", 
    "account_name": "string", 
    "currency_code": "string"
}]
```

##### Notes:
1) The field "account_type" in response should be one of the following:
    "cd","checking","credit_card","heloc","ira","investment","loc","loan","money_market","mortgage","overdraft_protection”,
    "sloc","savings","wire","unspecified".
    
2) The field "payment_due_date" in response should be in "yyyy-MM-dd’T’HH:mm:ss.SSSZ” Date format.

3) If there is no meta then pass empty array.

### Transactions Methods

#### Merchants

```
POST /merchants
```

Get merchants

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [merchants_request](#merchants_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | merchants response | Array of [merchant](#merchant) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /merchants HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "user_id": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
[{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "merchant_id": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "name": "string"
}]
```

#### Transactions

```
POST /transactions
```

Search customer transactions

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [transaction_criteria](#transaction_criteria) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | transactions | Array of [transaction](#transaction) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /transactions HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "user_id": "string", 
    "limit": 0, 
    "account_ids": [
        {
            "type": "string"
        }
    ], 
    "categories": [
        {
            "type": "string"
        }
    ], 
     "payees": [
        {
            "type": "string"
        }
    ], 
     "merchants": [
        {
            "type": "string"
        }
    ], 
    "end_date": "2016-01-30", 
    "start_date": "2016-01-30"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
[{
    "merchant": "string", 
    "status": "string", 
    "description": "string", 
    "title": "string", 
    "transaction_id": "string", 
    "transaction_type": "string", 
    "post_date": "2016-01-30T00:00:00.000+0000", 
    "amount": 0, 
    "transaction_date": "2016-01-30T00:00:00.000+0000", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "currency_code": "string", 
    "check_number": 0, 
    "categories": [
        {
            "type": "string"
        }
    ], 
    "account_id": "string"
}]
```

##### Notes:
1) The field "transaction_type" in response should be one of the following:
   "atm","cash","check","check_deposit","credit","debit”,"fee","dividend","interest","unspecified”.

2) The field "status" in response should be one of the following:
   "posted","pending","cancelled","unspecified".
   
3) The fields "transaction_date" and "post_date" in response should be in "yyyy-MM-dd’T’HH:mm:ss.SSSZ” Date format.

4) If there is no meta or categories then pass empty array. 

5) We prefer that API do not implement filtering by category, payee or merchant and instead rely on Kai adapter to do that filtering.

#### Categories

```
POST /categories
```

Get transaction categories

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [categories_request](#categories_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | categories response | Array of [category](#category) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /categories HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "user_id": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
[{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "category_id": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "name": "string"
}]
```


### Transfers Methods

#### Transfer

```
POST /transfer
```

Transfer funds between two accounts

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [transfer_request](#transfer_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | transfer response | [transfer](#transfer) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /transfer HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "dest_account_id": "string", 
    "source_account_id": "string", 
    "amount": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "date": "2016-01-30", 
    "currency_code": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "transfer_id": "string", 
    "reference_number": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "status": "string"
}
```


### Payments Methods

#### Payment

```
POST /payment
```

Pay funds to a payee

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [payment_request](#payment_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | payment response | [payment](#payment) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /payment HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "source_account_id": "string", 
    "payee_id": "string", 
    "amount": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "date": "2016-01-30", 
    "currency_code": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "payment_id": "string", 
    "reference_number": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "status": "string"
}
```

#### Payees

```
POST /payees
```

Get list of payees for a user

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header | 
| token | header | 
| [payees_request](#payees_request) | body | 

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | payees response | Array of [payee](#payee) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /payees HTTP/1.1
Content-Type: application/json
Accept: application/json
secret: string
token: string
```
```json
{
    "user_id": "string"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
[{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "payee_id": "string", 
    "name": "string"
}]
```


### Schema Definitions

#### account

```json
{
    "available_credit": 0, 
    "account_type": "string", 
    "account_id": "string", 
    "payment_due_amount": 0, 
    "current_balance": 0, 
    "interest_rate": 0, 
    "payment_due_date": "2016-01-30", 
    "available_balance": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "account_number": "string", 
    "account_name": "string", 
    "currency_code": "string"
}
```

#### accounts_request

```json
{
    "user_id": "string", 
    "account_id": "string"
}
```

#### auth_info

```json
{
    "token": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ]
}
```

#### categories_request

```json
{
    "user_id": "string"
}
```

#### category

```json
{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "category_id": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "name": "string"
}
```

#### customer

```json
{
    "first_name": "string", 
    "last_name": "string", 
    "user_id": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "full_name": "string"
}
```

#### customer_request

```json
{
    "user_id": "string"
}
```

#### error_response

```json
{
    "message": "string", 
    "code": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ]
}
```

#### merchant

```json
{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "merchant_id": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "name": "string"
}
```

#### merchants_request

```json
{
    "user_id": "string"
}
```

#### meta_field

```json
{
    "name": "string", 
    "value": "string"
}
```

#### payee

```json
{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "payee_id": "string", 
    "name": "string"
}
```

#### payees_request

```json
{
    "user_id": "string"
}
```

#### payment

```json
{
    "payment_id": "string", 
    "reference_number": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "status": "string"
}
```

#### payment_request

```json
{
    "source_account_id": "string", 
    "payee_id": "string", 
    "amount": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "date": "2016-01-30", 
    "currency_code": "string"
}
```

#### token_credentials

```json
{
    "username": "string", 
    "password": "string"
}
```

#### token_response

```json
{
    "token": "string", 
    "user_id": "string"
}
```

#### transaction

```json
{
    "merchant": "string", 
    "status": "string", 
    "description": "string", 
    "title": "string", 
    "transaction_id": "string", 
    "transaction_type": "string", 
    "post_date": "2016-01-30", 
    "amount": 0, 
    "transaction_date": "2016-01-30", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "currency_code": "string", 
    "check_number": 0, 
    "categories": [
        {
            "type": "string"
        }
    ], 
    "account_id": "string"
}
```

#### transaction_criteria

```json
{
    "user_id": "string", 
    "limit": 0, 
    "account_ids": [
        {
            "type": "string"
        }
    ], 
    "categories": [
        {
            "type": "string"
        }
    ], 
     "payees": [
        {
            "type": "string"
        }
    ], 
     "merchants": [
        {
            "type": "string"
        }
    ], 
    "end_date": "2016-01-30", 
    "start_date": "2016-01-30"
}
```

#### transfer

```json
{
    "transfer_id": "string", 
    "reference_number": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "status": "string"
}
```

#### transfer_request

```json
{
    "dest_account_id": "string", 
    "source_account_id": "string", 
    "amount": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "date": "2016-01-30", 
    "currency_code": "string"
}
```

#### transfer_response

```json
{
    "transfer": "string", 
    "auth_info": "string"
}
```

#### validate_otp_request

```json
{
    "otp": "string", 
    "user_id": "string",
    "otp_id": "string"
}
```

#### validate_otp_response

```json
{
    "token": "string", 
    "user_id": "string"
}
```
#### session_token_request

```json
{
    "user_id": "string",
    "token": "string
}
```
