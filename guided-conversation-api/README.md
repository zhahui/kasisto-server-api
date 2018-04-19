# Kasisto Dynamic Guided Conversations 

### Version information
*Version* : 0.9 alpha 1


### Contact information
*Contact* : Kasisto  
*Contact Email* : info@kasisto.com


## Overview

This document describes the Kasisto Enterprise API Specification for Dynamic Guided Conversations.

Dynamic Guided Conversations are simple conversation that can be added to KAI. The main difference with traditional intents is that KAI delegates the execution of the conversation to a Server component called *Guided Conversation Webhook*. During the conversation, this Webhook takes over KAI to orchestrate the interactions with the user. It uses KAI as a NLU processing engine and to process other requests such as FAQs or other intents available in KAI.

## Quick links

- [Flow Overview](flow-overview.md)

This section is an introduction to the Dymanic Guided Conversation framework illustrated with a sample form. 

- [Webhook API Overview](api-overview.md)

This section details the Service that needs to be implemented by the Server as part of the *Guided Conversation Webhook*.

- [NLG Message templates](nlg-message-templates.md)

This section details the different message templates available to the *Guided Conversation Webhook*. The Webhook can generate messages to the user using any combination of templates.

- [NLU User input types](nlu-input-types.md)

This section details the different type of data the *Guided Conversation Webhook* can ask KAI to understand from the user inputs.


