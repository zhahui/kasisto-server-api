# Kasisto Dynamic Guided Conversations<br>NLU Input types

### Version information
*Version* : 0.9 alpha 1


### Contact information
*Contact* : Kasisto  
*Contact Email* : info@kasisto.com

## Overview
- [User input types](#user-input-types)
  * [Boolean](#boolean)
  * [Number](#number)
  * [String](#string)
  * [Date](#date)
  * [Email](#email)
  * [Currency Code](#currency-code)
  * [List of options](#list-of-options)
-[Custom types](#custom-types)
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

The captured Boolean will be sent to the Webhook mostly unprocessed as KAI can't use NLU on strings. Using strings is not recommended.

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
            {"value": "option1", "title": "First option"},
            {"value": "option2", "title": "Second option"},
            {"value": "option3", "title": "Third option"}
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
