# Kasisto Integration API Overview
Version 1.0

- [Authentication](#authentication)
- [Authorization](#authorization)
- [Schema](#schema)
- [Customer Methods](#customer-methods)
  * [/validate_otp](#/validate_otp)
  * [/customer](#/customer)
  * [/token](#/token)
- [Accounts Methods](#accounts-methods)
  * [/accounts](#/accounts)
- [Transactions Methods](#transactions-methods)
  * [/merchants](#/merchants)
  * [/transactions](#/transactions)
  * [/categories](#/categories)
- [Transfers Methods](#transfers-methods)
  * [/transfer](#/transfer)
- [Payments Methods](#payments-methods)
  * [/payment](#/payment)
  * [/payees](#/payees)

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


