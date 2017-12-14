# Kasisto Enterprise API Overview
Version 1.3 beta

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
- [Bank Locations Methods](#bank-locations-methods)
  * [/bank_locations](#bank-locations)
- [Customer Action Methods](#customer-action-methods)
  * [/customer_action](#customer_action)


## Authentication
The Kasisto API requires all requests to include a secret key header value used for request authentication.  Kasisto will include the secret key header in each request from our servers. API implementations must validate the secret is correct.
Server implementations should return a 401 HTTP status code response if authentication fails.

## Authorization
The Kasisto API allows requests to include a user authorization token header value.  This token should be validated on the server implementation to match the provided user_id value and that is has the neccessary privilages to access the requested information.
Server implementations should return a 403 HTTP status code response if authorization fails.

## Tracking
The Kasisto API requests include a unique request identifier. This identifier is provided as a request_id field in the HTTP Request header. This request_id can be used to track the requests when investigating execution logs.

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
| locale | header |
| request_id | header |
| Date | header |
| [validate_otp_request](#validate_otp_request) | body |

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | token response | [token_response](#token_response) |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
```
```json
{
    "otp": "string",
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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
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
    "user_id": "string",
    "first_name": "string",
    "last_name": "string",
    "full_name": "string",
    "email": "string",
    "mobile_number" : "string",
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]
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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
```
```json
{
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]
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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
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
    "account_id": "string",
    "account_type": "string",
    "account_number": "string",
    "account_name": "string",
    "account_nickname": "string",
    "account_status": "string", // New field to manage states (active / inactive /blocked). Some status values may be applicable only for certain account types. (Blocked could be only used for card for instance)
   
   // "currency_code": "string", I think we should remove this field as we request the bank to provide local currency only in current_balance and available_balance.
    "current_balance": 0,
    "available_balance": 0,

    // I propose to spec these foreing currency codes in regular fields that we can document here
    "currency_code_wallet": "string",
    "current_balance_wallet": 0,
    "available_balance_wallet": 0,

    "credit_limit": 0,
    "interest_rate": 0,
    "available_credit": 0,
    "statement_date": "2016-01-01", // new date of statement creation for Credit card
    "payment_due_amount": 0,
    "payment_due_date": "2016-01-30",
    "minimum_payment_due_amount": 0,
    
    // New reward points and other fields
    "reward_points": 0,
    "reward_miles": 0,
    "reward_cashback": 0,
    
    "can_transfer_to": false, 
    "can_transfer_from": false, 
    "can_pay_payee": false, // New field for P2P to match what we have for transfer
    "can_waive_fee": false, // New field for fee waiver to match what we have for transfer
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]
}]
```

##### Notes:
1) The field "account_type" in response should be one of the following:
    "cd","checking","credit_card","heloc","ira","investment","loc","loan","money_market","mortgage","overdraft_protection”,
    "sloc","savings","wire".

2) The field "account_status" in response should be one of the following:
    "active","inactive".

3) The field "payment_due_date" in response should be in "yyyy-MM-dd” Date format.

4) If there is no meta then pass empty array.

5) As a guidance, we show the supported features per account type in the table below.
The mapping can change from Bank to Bank: 

| Feature | Certificate of deposit | Checking | Credit Card | Loan | Mortgage | Savings |
| --------- | :-------------: | :-------------: | :-------------: | :-------------: | :-------------: | :-------------: |
| account_id | x | x | x | x | x | x |
| account_type | cd |checking | credit_card | loan | mortgage |savings |
| account_number | x | x | x | x | x | x |
| account_name | x | x | x | x | x | x |
| account_nickname | x | x | x | x | x | x |
| account_status | x | x | x | x | x | x |   
| current_balance  | x | x | x | x | x | x |
| available_balance  | x | x | x | x | x | x |
| currency_code_wallet  |  | x |  |  |  | x |
| current_balance_wallet |  | x |  |  |  | x |
| available_balance_wallet |  | x |  |  |  | x |
| credit_limit |  | x | x |  |  | x |
| interest_rate | x | x | x | x | x | x |
| available_credit |  |  | x |  |  |  |
| statement_date | x | x | x | x | x | x |
| payment_due_amount |  |  | x | x | x |  |
| payment_due_date |  |  | x | x | x |  |
| minimum_payment_due_amount |  |  | x | x | x |  |
| reward_points |  | x | x |  |  | x |
| reward_miles |  | x | x |  |  | x |
| reward_cashback |  | x | x |  |  | x |
| can_transfer_to | x | x | x | x | x | x |
| can_transfer_from |  | x | x |  |  | x |
| can_pay_payee |  | x | x |  |  | x |
| can_waive_fee | x | x | x | x | x | x |

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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
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
        "string"
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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
```
```json
{
    "user_id": "string",
    "limit": 0,
    "account_ids": [
        "string"
    ],
    "end_date": "2017-08-01T03:59:59Z",
    "start_date": "2017-07-01T04:00Z"
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
    "currency_code": "string",
    "transaction_id": "string",
    "transaction_type": "string",
    "post_date": "2016-01-30T00:00:00Z",
    "amount": 0,
    "transaction_date": "2016-01-30T00:00:00Z",
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ],
    "location": {
        "address": "string",
        "city": "string",
        "state": "string", 
        "zip": "string",
        "country": "string",
        "coordinates": {
          "lat": 0.0,
          "long": 0.0
        }
    },
    "check_number": 0,
    "categories": [
        "string"
    ],
    "account_id": "string"
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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
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
        "string"
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

##### Notes:
1) The field "transaction_type" in response should be one of the following:
   "credit","debit”.

2) The field "status" in response should be one of the following:
   "posted","pending","cancelled".

3) The fields "transaction_date" and "post_date" in response should be in ISO-8601 format "yyyy-MM-dd’T’HH:mm:ssZ” Date format.

4) If there is no meta or categories then pass empty array.

5) We prefer that API do not implement filtering by category, payee or merchant and instead rely on Kai adapter to do that filtering.

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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
```
```json
{
    "user_id": "string", 
    "dest_account_id": "string",
    "source_account_id": "string",
    "amount": 0,
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ],
    "date": "2016-01-30T00:00:00Z",
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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
```
```json
{
    "user_id": "string", 
    "payee_id": "string", 
    "source_account_id": "string",
    "amount": 0,
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ],
    "date": "2016-01-30T00:00:00Z",
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
| locale | header |
| request_id | header |
| Date | header |
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
locale: string
request_id: string
Date: Tue, 01 Jan 2017 00:00:00 GMT
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
        "string"
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


### Bank Locations Methods

#### Bank Locations

```
POST /bank_locations
```

Search for bank locations

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header |
| token | header |
| locale | header |
| request_id | header |
| Date | header |
| [bank_locations_criteria](#bank_locations_criteria) | body |

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | bank_locations | Array of [bank_location](#bank_location) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /bank_locations HTTP/1.1
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
    "location": {
        "address": "string",
        "city": "string",
        "state": "string", 
        "zip": "string",
        "country": "String",
        "coordinates": {
          "lat": 0.0,
          "long": 0.0
        }
    }
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
[{
    "location_id": "string",
    "location_type": "string",
    "location_name": "string",
    "location_url": "string",
    "location": {
        "address": "string",
        "city": "string",
        "state": "string",
        "zip": "string",
        "country": "string",
        "coordinates": {
            "lat": 0.0,
            "long": 0.0
        },
    },
    "phone_number": "string",
    "services": [
        "string"
    ],
    "opening_hours": [
        "string"
    ],
    "opening_days": [
        "string"
    ],
    "languages": [
        "string"
    ]
}]
```

##### Notes:
1) The field "location" in the request can be ommitted in request when KAI searches for all locations.

2) The field "opening_hours" contains a text description of the opening hours. The description should be returned in the language matching the request "locale" parameter.

    a) If locale is set to en_XX (en_US, en_HK, en_SG, etc..), the opening hours should be returned in English.

    b) If locale is set to zh_HK, the opening hours shouldbe returned in Cantonese.

```json
"opening_hours": [ 
    "Mon – Fri: 9am to 5pm",
    "Sat 9am to 1pm",
    "public holidays: closed"
]
```

```json
"opening_hours": [ 
    "星期一至星期五: 上午九時至下午五時",
    "星期六上午九時至下午一時"
]
```

3) The field "opening_days" in the response should be one of the following: "monday", "tuesday", "wednesday", "thursday, "friday", "saturday", "sunday". The values should always be in English.

### Customer Action Methods

#### Customer Action

```
POST /customer_action
```

Submits a customer action

##### Request Parameters

| Parameter | Location |
| --------- | -------- |
| secret | header |
| token | header |
| locale | header |
| request_id | header |
| Date | header |
| [customer_action_request](#customer_action_request) | body |

##### Responses

| Status | Description | Schema |
| ------ | ----------- | ------ |
| 200 | Customer action response | [customer_action_response](#customer_action_response) |
| 401 | Authentication Failed | [error_response](#error_response) |
| 403 | Access Denied | [error_response](#error_response) |
| 450 | One-Time Password is required | [error_response](#error_response) |
| 500 | Server Error | [error_response](#error_response) |
| 501 | Not Implemented | [error_response](#error_response) |

##### Sample Request / Response

```http
POST /customer_action HTTP/1.1
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
    "action": "string",
    "parameters:": [
        { 
            "name": "string", 
            "value": "string"
        }
    ]
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
token: string (optional)
```
```json
{
    "reference_id": "string",
    "reference_number": "string",
    "status": "string",
    "display_message_id": "string",
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]
}
```

| Intent | Action name | Parameter name | Parameter description | 
| --------- | -------- | -------- | -------- |
| Credit Card Fee Waiver | credit_card_waive_fee | account_id | Id of the credit card to waive fees |
| Credit Card Activation | credit_card_activate | account_id | Id of the credit card to activate |
| Pay Payee | pay_payee | from_account_id | Id of the account to pay from |
| | | to_payee_id | Id of the payee to pay to |
| | | amount | Amount of the payment |
| | | currency | Currency of the payment |
| | | reference | Reference of the payment |
| | | date | Payment date |

### Schema Definitions

#### account

```json
{
    "account_id": "string",
    "account_type": "string",
    "account_number": "string",
    "account_name": "string",
    "account_nickname": "string",
    "account_status": "string",
    "current_balance": 0,
    "available_balance": 0,
    "currency_code_wallet": "string",
    "current_balance_wallet": 0,
    "available_balance_wallet": 0,
    "credit_limit": 0,
    "interest_rate": 0,
    "available_credit": 0,
    "statement_date": "2016-01-01",
    "payment_due_amount": 0,
    "payment_due_date": "2016-01-30",
    "minimum_payment_due_amount": 0,
    "reward_points": 0,
    "reward_miles": 0,
    "reward_cashback": 0,
    "can_transfer_to": false,
    "can_transfer_from": false,
    "can_pay_payee": false,
    "can_waive_fee": false,
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]
}
```

#### accounts_request

```json
{
    "user_id": "string",
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]


}
```

#### bank_location

```json
{
    "location_id": "string",
    "location_type": "string",
    "location_name": "string",
    "location_url": "string",
    "location": {
        "address": "string",
        "city": "string",
        "state": "string",
        "zip": "string",
        "country": "string",
        "coordinates": {
            "lat": 0.0,
            "long": 0.0
        }
    },
    "phone_number": "string",
    "services": [
        "string"
    ],
    "opening_hours": [
        "string"
    ],
    "opening_days": [
        "string"
    ],
    "languages": [
        "string"
    ]
}
```

#### bank_locations_criteria

```json
{
    "user_id": "string",
    "location": {
        "address": "string",
        "city": "string",
        "state": "string", 
        "zip": "string",
        "country": "string",
        "coordinates": {
          "lat": 0.0,
          "long": 0.0
        }
    }
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
        "string"
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
    "full_name": "string",
    "email": "string",
    "mobile_number" : "string"
}
```

#### customer_request

```json
{
    "user_id": "string"
}
```

#### customer_action_request

```json
{
    "user_id": "string",
    "action": "string",
    "parameters:": [
        { 
            "name": "string", 
            "value": "string"
        }
    ]
}
```

#### customer_action_response

```json
{
    "reference_id": "string",
    "reference_number": "string",
    "status": "string",
    "display_message_id": "string",
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ]
}
```

#### error_response

```json
{
    "message": "string",
    "code": "string",
    "otp_details": null,
    "display_message_id": "string", 
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
        "string"
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

#### payee

```json
{
    "alias": [
        "string"
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
    "user_id": "string", 
    "payee_id": "string", 
    "source_account_id": "string",
    "amount": 0,
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ],
    "date": "2016-01-30T00:00:00Z",
    "currency_code": "string"
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
    "currency_code": "string",
    "transaction_id": "string",
    "transaction_type": "string",
    "post_date": "2016-01-30T00:00:00Z",
    "amount": 0,
    "transaction_date": "2016-01-30T00:00:00Z",
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ],
    "location": {
        "address": "string",
        "city": "string",
        "state": "string", 
        "zip": "string",
        "country": "string",
        "coordinates": {
          "lat": 0.0,
          "long": 0.0
        }
    },
    "check_number": 0,
    "categories": [
        "string"
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
        "string"
    ],
    "end_date": "2016-01-30T00:00:00Z",
    "start_date": "2016-01-29T00:00:00Z"
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
    "user_id": "string", 
    "dest_account_id": "string",
    "source_account_id": "string",
    "amount": 0,
    "meta": [
        {
            "name": "string",
            "value": "string"
        }
    ],
    "date": "2016-01-30T00:00:00Z",
    "currency_code": "string"
}
```

#### validate_otp_request

```json
{
    "otp": "string",
    "user_id": "string"
}
```

