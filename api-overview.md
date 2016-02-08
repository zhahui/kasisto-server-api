# Kasisto Integration API Overview

## Customer Methods
### POST /validate_otp
Validate One-Time Password and return new user token

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| validate_otp_request | body | False |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 200 | token response |
| 451 | Invalid One-Time Password |
| 452 | Expired One-Time Password |
| 453 | Too Many One-Time Password Failures |
| 403 | Access Denied |
| 401 | Authentication Failed |
### POST /customer
Get customer object

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| customer_request | body | True |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 450 | One-Time Password is required |
| 200 | customer response |
| 403 | Access Denied |
| 401 | Authentication Failed |
### POST /token
Get access token for a customer

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token_credentials | body | False |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 200 | token response |
| 403 | Access Denied |
| 401 | Authentication Failed |

## Accounts Methods
### POST /accounts
Get customer accounts

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| accounts_request | body | True |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 450 | One-Time Password is required |
| 200 | accounts response |
| 403 | Access Denied |
| 401 | Authentication Failed |

## Transactions Methods
### POST /merchants
Get merchants

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| merchants_request | body | False |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 200 | merchants response |
### POST /transactions
Search customer transactions

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| transaction_criteria | body | True |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 450 | One-Time Password is required |
| 200 | transactions |
| 403 | Access Denied |
| 401 | Authentication Failed |
### POST /categories
Get transaction categories

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| categories_request | body | False |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 200 | categories response |

## Transfers Methods
### POST /transfer
Transfer funds between two accounts

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| transfer_request | body | False |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 450 | One-Time Password is required |
| 200 | transfer response |
| 403 | Access Denied |
| 401 | Authentication Failed |

## Payments Methods
### POST /payment
Pay funds to a payee

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| payment_request | body | False |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 450 | One-Time Password is required |
| 200 | payment response |
| 403 | Access Denied |
| 401 | Authentication Failed |
### POST /payees
Get list of payees for a user

#### Request Parameters
| Parameter | Location | Required | Description |
| ------ | ----------- | -------- | ----------- |
| secret | header | True |  |
| token | header | True |  |
| payees_request | body | False |  |
#### Responses
| Status | Description |
| ------ | ----------- |
| 200 | payees response |

