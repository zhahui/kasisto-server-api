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
  * [Custom types](#custom-types)
- [List of options](#list-of-options)
  * [Quick replies input mode](#quick-replies-input-mode)
  * [Carousel input mode](#carousel-input-mode)
  * [List input mode](#list-input-mode)

# User input types

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
        "type": "CURRENCY_CODE"
    }
}
```

The captured currency code is captured in ISO-4217 alphabetic code ("USD", "SGD", "HKD, etc.).

### Custom types
The KAI NLU can be extended with additional custom *Normalizers*.
Custom normalizer could be added to recognize different types of user inputs:
- Product names
- Product types
- Request types
- etc.


# List of options

In addition to the *input type*, the Webhook can define lists of available options to restrict the user choices. 

If a predefined set of options is defined, KAI will propose the available options to the user using one of the following input capture modes:
- [Quick replies input mode](#quick-replies-input-mode) : The user is proposed with the list of options as quick replies.

- [Carousel input mode](#carousel-input-mode) : The user is proposed with a carousel containing the list of options.

- [List input mode](#list-input-mode) : The user is proposed with a list of options.

#### Quick replies input mode

The user is proposed with the list of options as quick replies.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "NUMBER",
        "input_mode": "QUICK_REPLIES",
        "options": [
            {
                "value": "2345",
                "label": "Renew card 2345"
            },
            {
                "value": "3456",
                "label": "Renew card 3456"
            }
        ]
    }
}
```

KAI displays the *label* to the user and sends the *value* of the selected option to the Webhook.
The Webhook should return the following details for each quick reply:

| Field name | type |  mandatory | max length| Description |
| --------- | -------- | -------- | -------- | -------- |
| value | string | yes | - | The *value* of the option that will be sent to the Webkook when the user selects this option |
| label | string| yes if enabled | 20 | Label of the select button |



#### Carousel input mode

The user is proposed with a carousel containing the list of options.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "NUMBER",
        "input_mode": "CAROUSEL",
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

KAI displays a card for each option. The Webhook should return the following details for each card:

| Field name | type |  mandatory | max length| Description |
| --------- | -------- | -------- | -------- | -------- |
| value | string | yes | - | The *value* of the option that will be sent to the Webkook when the user selects this option |
| enabled | boolean | yes | - | The *enabled* flag is used to enable or disable the option. If the option is disabled, KAI will show the option to the user but the user will not be able to select it. |
| medium | object | no | - | The *medium* object is optional. If a medium is returned containing the full URL to an image, KAI will display it to the user. |
| title | string | yes | 80 | Title of the card. Contains the name of the option |
| subtitle | string | no | 80 |  Title of the card. Contains the name of the option |
| label | string| yes if enabled | 20 | Label of the select button |

#### List input mode

The user is proposed with a list of options.
```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [],
    "request_user_input": {
        "name": "string",
        "type": "NUMBER",
        "input_mode": "LIST",
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

KAI displays a list of options. The Webhook should return the following details for each entry:

| Field name | type |  mandatory | max length| Description |
| --------- | -------- | -------- | -------- | -------- |
| value | string | yes | - | The *value* of the option that will be sent to the Webkook when the user selects this option |
| enabled | boolean | yes | - | The *enabled* flag is used to enable or disable the option. If the option is disabled, KAI will show the option to the user but the user will not be able to select it. |
| medium | object | no | - | The *medium* object is optional. If a medium is returned containing the full URL to an image, KAI will display it to the user. |
| title | string | yes | 80 | Title of the card. Contains the name of the option |
| subtitle | string | no | 80 |  Title of the card. Contains the name of the option |
| label | string| yes if enabled | 20 | Label of the select button |
