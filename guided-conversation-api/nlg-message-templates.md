# Kasisto Dynamic Guided Conversations<br>NLG Message Templates

### Version information
*Version* : 0.9 alpha 1


### Contact information
*Contact* : Kasisto  
*Contact Email* : info@kasisto.com

## Overview
- [Message structure](#message-structure)
    + [Text message](#text-message)
    + [Button message](#button-message)
    + [Card message](#card-message)
    + [Carousel message](#carousel-message)
    + [List message](#list-message)

## Message structure 

With Dynamic Guided Conversations, the webhook is in charge of the generation of the messages to display to the user. The message content generated can contain variable types of elements to provide the user with rich content.

Each time KAI invokes the webhook, the webhook generates a message to the user.

The message content can contain multiple elements:

```json
{
    "form_id": "string",
    "form_state": "string",
    "message_contents": [
        {
            "type": "TEXT",
            "payload": {
                "text": "Before we get started please check our Disclaimer."
            }
        },
        {
            "type": "BUTTON",
            "payload": {
                "label": "View Website",
                "type": "HYPERLINK",
                "payload": "http://www.xxxbank.com/disclaimer.html"
            }
        },
        {
            "type": "TEXT",
            "payload": {
                "text": "Please tell us your bithday."
            }
        }
    ]
}
```

**Note:**
The version 0.9 of the Kasisto Dynamic Guided Conversations supports only TEXT message. 
For the following versions, complex nessages with multiple content elements will be supported. The message format follows what is defined in the KAI Conversational API. 

### Text message

A simple text message that will be displayed to the user in a single chat bubble.

```json
"message_contents": [
    {
        "type": "TEXT",
        "payload": {
            "text": "Please tell us your bithday."
        }
    }
]
```

The value in *payload.text* can contain unformatted text or it can be enriched with HTML formatting.  

### Button message

A simple button message that will be displayed to the user in a single chat bubble.

```json
"message_contents": [
    {
        "type": "BUTTON",
        "payload": {
            "label": "View Website",
            "type": "HYPERLINK",
            "payload": "http://www.xxxbank.com/disclaimer.html"
        }
    }
]
```

### Card message

A Card.

```json
"message_contents": [
    {
        "type": "CARD",
        "payload": {
            "medium": {
                "medium_url": "http://www.xxxbank.com/image.jpg",
                "hyperlink_url": null
            },
            "title": "Offers",
            "subtitle": "Please click below",
            "buttons": [
                {
                    "label": "View Website",
                    "type": "HYPERLINK",
                    "payload": "http://www.xxxbank.com/page.html"
                }
            ]
        }
    }
]
```

### Carousel message

A carousel view

```json
"message_contents": [
    {
        "type": "CONTAINER",
        "payload": {
            "mode": "CAROUSEL",
            "contents": [
                {
                    "type": "CARD",
                    "payload": {
                        "title": "Card1",
                        "subtitle": "Please click below",
                        "buttons": [
                            {
                                "label": "View Website",
                                "type": "HYPERLINK",
                                "payload": "http://www.xxxbank.com/page1.html"
                            }
                        ]
                    }
                },
                {
                    "type": "CARD",
                    "payload": {
                        "title": "Card2",
                        "subtitle": "Please click below",
                        "buttons": [
                            {
                                "label": "View Website",
                                "type": "HYPERLINK",
                                "payload": "http://www.xxxbank.com/page2.html"
                            }
                        ]
                    }
                }
            ]
        }
    }
]
```

### List message

A listview

```json
"message_contents": [
    {
        "type": "CONTAINER",
        "payload": {
            "mode": "LIST",
            "contents": [
                {
                    "type": "CARD",
                    "payload": {
                        "title": "Card1",
                        "subtitle": "Please click below",
                        "buttons": [
                            {
                                "label": "View Website",
                                "type": "HYPERLINK",
                                "payload": "http://www.xxxbank.com/page1.html"
                            }
                        ]
                    }
                },
                {
                    "type": "CARD",
                    "payload": {
                        "title": "Card2",
                        "subtitle": "Please click below",
                        "buttons": [
                            {
                                "label": "View Website",
                                "type": "HYPERLINK",
                                "payload": "http://www.xxxbank.com/page2.html"
                            }
                        ]
                    }
                }
            ]
        }
    }
]
```


