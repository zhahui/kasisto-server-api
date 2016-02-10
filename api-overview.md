# Kasisto Integration API Overview
Version 1.0

- [Authentication](#authentication)
- [Authorization](#authorization)
- [Schema](#schema)
- [Customer Methods](#customer-methods)
  * [/validate_otp](#validate-otp)
  * [/customer](#customer)
  * [/token](#token)
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
{
    "first_name": "string", 
    "full_name": "string", 
    "last_name": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "user_id": "string"
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
[{
    "account_id": "string", 
    "account_name": "string", 
    "account_number": "string", 
    "account_type": "string", 
    "available_balance": 0, 
    "available_credit": 0, 
    "currency_code": "string", 
    "current_balance": 0, 
    "interest_rate": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "payment_due_amount": 0, 
    "payment_due_date": "2016-01-30"
}]
```


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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
[{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "merchant_id": "string", 
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
[{
    "account_id": "string", 
    "amount": 0, 
    "category": "string", 
    "check_number": "string", 
    "currency_code": "string", 
    "description": "string", 
    "merchant": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "post_date": "2016-01-30", 
    "status": "string", 
    "transaction_date": "2016-01-30", 
    "transaction_id": "string", 
    "transaction_type": "string"
}]
```

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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
[{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "category_id": "string", 
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
{
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "reference_number": "string", 
    "status": "string", 
    "transfer_id": "string"
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
{
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "payment_id": "string", 
    "reference_number": "string", 
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

```http
HTTP/1.1 200 OK
Content-Type: application/json
```

```json
[{
    "alias": [
        {
            "type": "string"
        }
    ], 
    "name": "string", 
    "payee_id": "string"
}]
```


### Schema Definitions

#### account

```json
{
    "account_id": "string", 
    "account_name": "string", 
    "account_number": "string", 
    "account_type": "string", 
    "available_balance": 0, 
    "available_credit": 0, 
    "currency_code": "string", 
    "current_balance": 0, 
    "interest_rate": 0, 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "payment_due_amount": 0, 
    "payment_due_date": "2016-01-30"
}
```

#### accounts_request

```json
{
    "account_id": "string", 
    "user_id": "string"
}
```

#### auth_info

```json
{
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "token": "string"
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
    "name": "string"
}
```

#### customer

```json
{
    "first_name": "string", 
    "full_name": "string", 
    "last_name": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "user_id": "string"
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
    "code": "string", 
    "message": "string"
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
    "name": "string", 
    "payee_id": "string"
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
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "payment_id": "string", 
    "reference_number": "string", 
    "status": "string"
}
```

#### payment_request

```json
{
    "amount": 0, 
    "currency_code": "string", 
    "date": "2016-01-30", 
    "payee_id": "string", 
    "source_account_id": "string"
}
```

#### token_credentials

```json
{
    "password": "string", 
    "username": "string"
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
    "account_id": "string", 
    "amount": 0, 
    "category": "string", 
    "check_number": "string", 
    "currency_code": "string", 
    "description": "string", 
    "merchant": "string", 
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "post_date": "2016-01-30", 
    "status": "string", 
    "transaction_date": "2016-01-30", 
    "transaction_id": "string", 
    "transaction_type": "string"
}
```

#### transaction_criteria

```json
{
    "account_ids": [
        {
            "type": "string"
        }
    ], 
    "limit": "string", 
    "user_id": "string"
}
```

#### transfer

```json
{
    "meta": [
        {
            "name": "string", 
            "value": "string"
        }
    ], 
    "reference_number": "string", 
    "status": "string", 
    "transfer_id": "string"
}
```

#### transfer_request

```json
{
    "amount": 0, 
    "currency_code": "string", 
    "date": "2016-01-30", 
    "dest_account_id": "string", 
    "source_account_id": "string"
}
```

#### transfer_response

```json
{
    "auth_info": "string", 
    "transfer": "string"
}
```

#### validate_otp_request

```json
{
    "otp": "string", 
    "user_id": "string"
}
```

#### validate_otp_response

```json
{
    "token": "string", 
    "user_id": "string"
}
```

