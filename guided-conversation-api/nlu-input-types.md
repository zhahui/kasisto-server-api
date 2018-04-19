# Kasisto Dynamic Guided Conversations<br>NLU Input types

### Version information
*Version* : 0.9 alpha 1


### Contact information
*Contact* : Kasisto  
*Contact Email* : info@kasisto.com

## Table of Contents
- [User input types](#user-input-types)
  * [Boolean](#boolean)
  * [Number](#number)
  * [String](#string)
  * [Date](#date)
  * [Email](#email)
  * [Currency Code](#currency-code)
  * [List of options](#list-of-options)
- [Custom types](#custom-types)
- [Schema definitions](#schema-definitions)

## User input types

**TODO more here**

KAI supports out of the box the following types of user inputs.

### Boolean

Captures a true/false, yes/no input.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "BOOLEAN"
    }
}
```

The captured Boolean will be sent to the Webhook in string format ("true" / "false").

### Number

Captures a number input. 
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "NUMBER"
    }
}
```

The captured Number will be sent to the Webhook formatted as a string.
If the user input is a decimal number, format will be "11111111111.1".

### String

Captures any string from the user input.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "STRING"
    }
}
```

The captured String will be sent to the Webhook mostly unprocessed as KAI can't use NLU on strings. Using strings is not generally recommended as it puts the burden of interpretation to the Webhook.

### Date

Captures a date from the user input.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "DATETIME"
    }
}
```

The captured date will be sent to the Webhook in ISO-8601 format "yyyy-MM-dd’T’HH:mm:ssZ".

### Email
Captures an email address from the user input.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "EMAIL"
    }
}
```

### Currency Code
Captures a currency code from the user input.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "EMAIL"
    }
}
```

The captured currency code is captured in ISO-4217 alphabetic code ("USD", "SGD", "HKD, etc.).

### List of options

Captures an input from a pre-defined list of options.

```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "OPTIONS",
        "options": [
            {
                "value": "2345",
                "enabled": true,
                "medium": {
                    "medium_url": "http:///www.xxxbank.com/visa_card.jpg",
                },
                "title": "Visa (2345)",
                "subtitle": "Expiring 20/10/2020",
                "label": "Renew card 2345"
            },
            {
                "value": "3456",
                "enabled": true,
                "medium": {
                    "medium_url": "http:///www.xxxbank.com/amex_card.jpg",
                },
                "title": "Amex (3456)",
                "subtitle": "Expiring 10/02/2024",
                "label": "Renew card 3456"
            }
        ]
    }
}
```

KAI porpose the list of available options to the user. The user select one.

KAI sends the selected *value* to the Webhook.

## Custom types
The KAI NLU can be extended with additional custom *Normalizers*.
Custom normalizer could be added to recognize different types of user inputs:
- Product names
- Product types
- Request types
- etc.

## Schema Definitions

**TODO more here** 

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
