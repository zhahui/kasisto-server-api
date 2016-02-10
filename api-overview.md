# Kasisto Integration API Overview
Version 1.0

- [Authentication](#authentication)
- [Authorization](#authorization)
- [Schema](#schema)
- [Customer Methods](### customer-methods)
  * [/validate_otp](#### validate-otp)
  * [/customer](#### customer)
  * [/token](#### token)
- [Accounts Methods](### accounts-methods)
  * [/accounts](#### accounts)
- [Transactions Methods](### transactions-methods)
  * [/merchants](#### merchants)
  * [/transactions](#### transactions)
  * [/categories](#### categories)
- [Transfers Methods](### transfers-methods)
  * [/transfer](#### transfer)
- [Payments Methods](### payments-methods)
  * [/payment](#### payment)
  * [/payees](#### payees)

## Authentication
The Kasisto API requires all requests to include a secret key header value used for request authentication.  Kasisto will include the secret key header in each request from our servers. API implementations must validate the secret is correct.
Server implementations should return a 401 HTTP status code response if authentication fails.

## Authorization
The Kasisto API allows requests to include a user authorization token header value.  This token should be validated on the server implementation to match the provided user_id value and that is has the neccessary privilages to access the requested information.
Server implementations should return a 403 HTTP status code response if authorization fails.

## Schema
All API access must be over HTTPS.  All data is sent and received as JSON.

### Customer Methods

#### Validate OTP

```
POST /validate_otp
```

Validate One-Time Password and return new user token

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| validate_otp_request | body | False |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | token response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 451 | Invalid One-Time Password |
| 452 | Expired One-Time Password |
| 453 | Too Many One-Time Password Failures |
| 500 | Server Error |
| 501 | Not Implemented |

#### Customer

```
POST /customer
```

Get customer object

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| customer_request | body | True |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | customer response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 450 | One-Time Password is required |
| 500 | Server Error |
| 501 | Not Implemented |

#### Token

```
POST /token
```

Get access token for a customer

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token_credentials | body | False |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | token response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 500 | Server Error |
| 501 | Not Implemented |


### Accounts Methods

#### Accounts

```
POST /accounts
```

Get customer accounts

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| accounts_request | body | True |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | accounts response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 450 | One-Time Password is required |
| 500 | Server Error |
| 501 | Not Implemented |


### Transactions Methods

#### Merchants

```
POST /merchants
```

Get merchants

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| merchants_request | body | False |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | merchants response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 500 | Server Error |
| 501 | Not Implemented |

#### Transactions

```
POST /transactions
```

Search customer transactions

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| transaction_criteria | body | True |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | transactions |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 450 | One-Time Password is required |
| 500 | Server Error |
| 501 | Not Implemented |

#### Categories

```
POST /categories
```

Get transaction categories

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| categories_request | body | False |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | categories response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 500 | Server Error |
| 501 | Not Implemented |


### Transfers Methods

#### Transfer

```
POST /transfer
```

Transfer funds between two accounts

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| transfer_request | body | False |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | transfer response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 450 | One-Time Password is required |
| 500 | Server Error |
| 501 | Not Implemented |


### Payments Methods

#### Payment

```
POST /payment
```

Pay funds to a payee

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| payment_request | body | False |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | payment response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 450 | One-Time Password is required |
| 500 | Server Error |
| 501 | Not Implemented |

#### Payees

```
POST /payees
```

Get list of payees for a user

##### Request Parameters

| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| payees_request | body | False |  |

##### Responses

| Status | Description |
| ------ | ----------- |
| 200 | payees response |
| 401 | Authentication Failed |
| 403 | Access Denied |
| 500 | Server Error |
| 501 | Not Implemented |


### Definitions

#### account

```json
{"available_credit": 0, "account_type": "string", "account_id": "string", "payment_due_amount": 0, "current_balance": 0, "interest_rate": 0, "payment_due_date": "2016-01-30", "available_balance": 0, "meta": [{"$ref": "#/definitions/meta_field"}], "account_number": "string", "account_name": "string", "currency_code": "string"}
```

#### accounts_request

```json
{"user_id": "string", "account_id": "string"}
```

#### auth_info

```json
{"token": "string", "meta": [{"$ref": "#/definitions/meta_field"}]}
```

#### categories_request

```json
{"user_id": "string"}
```

#### category

```json
{"alias": [{"type": "string"}], "category_id": "string", "name": "string"}
```

#### customer

```json
{"first_name": "string", "last_name": "string", "user_id": "string", "meta": [{"$ref": "#/definitions/meta_field"}], "full_name": "string"}
```

#### customer_request

```json
{"user_id": "string"}
```

#### error_response

```json
{"message": "string", "code": "string"}
```

#### merchant

```json
{"alias": [{"type": "string"}], "merchant_id": "string", "name": "string"}
```

#### merchants_request

```json
{"user_id": "string"}
```

#### meta_field

```json
{"name": "string", "value": "string"}
```

#### payee

```json
{"alias": [{"type": "string"}], "payee_id": "string", "name": "string"}
```

#### payees_request

```json
{"user_id": "string"}
```

#### payment

```json
{"payment_id": "string", "reference_number": "string", "meta": [{"$ref": "#/definitions/meta_field"}], "status": "string"}
```

#### payment_request

```json
{"date": "2016-01-30", "source_account_id": "string", "amount": 0, "payee_id": "string", "currency_code": "string"}
```

#### token_credentials

```json
{"username": "string", "password": "string"}
```

#### token_response

```json
{"token": "string", "user_id": "string"}
```

#### transaction

```json
{"category": "string", "merchant": "string", "account_id": "string", "transaction_date": "2016-01-30", "transaction_type": "string", "post_date": "2016-01-30", "amount": 0, "meta": [{"$ref": "#/definitions/meta_field"}], "status": "string", "currency_code": "string", "check_number": "string", "transaction_id": "string", "description": "string"}
```

#### transaction_criteria

```json
{"user_id": "string", "limit": "string", "account_ids": [{"type": "string"}]}
```

#### transfer

```json
{"transfer_id": "string", "reference_number": "string", "meta": [{"$ref": "#/definitions/meta_field"}], "status": "string"}
```

#### transfer_request

```json
{"date": "2016-01-30", "amount": 0, "source_account_id": "string", "currency_code": "string", "dest_account_id": "string"}
```

#### transfer_response

```json
{"transfer": "string", "auth_info": "string"}
```

#### validate_otp_request

```json
{"otp": "string", "user_id": "string"}
```

#### validate_otp_response

```json
{"token": "string", "user_id": "string"}
```

