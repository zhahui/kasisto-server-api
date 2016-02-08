# Kasisto API

<div class="app-desc">Kasisto Integration API for</div>

<div class="app-desc">More information: [http://kasisto.com](http://kasisto.com)</div>

<div class="app-desc">Contact Info: [info@kasisto.com](info@kasisto.com)</div>

<div class="app-desc">Version: 1.0.0</div>

<div class="license-info">All rights reserved</div>

<div class="license-url">http://apache.org/licenses/LICENSE-2.0.html</div>

## Access

<div class="method-summary">Customize this message as you see fit!</div>

## Methods

<div class="method">

<div class="method-path">

```
post: /accounts
```

</div>

<div class="method-tags"><span class="method-tag">Accounts</span></div>

<div class="method-summary"><span class="nickname">accountsPost</span></div>

<div class="method-notes">Get customer accounts</div>

### Parameters

<div class="field-items">

<div class="param">secret (required)</div>

<div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

<div class="param">token (required)</div>

<div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

<div class="param">accountsRequest (required)</div>

<div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

</div>

### Return type

<div class="return-type">[array[account]](#array)</div>

### Example data

<div class="example-data-content-type">Content-Type: application/json</div>

```
[ {
  "account_number" : "aeiou",
    "account_type" : "aeiou",
      "account_id" : "aeiou",
        "meta" : [ {
            "name" : "aeiou",
                "value" : "aeiou"
                  } ],
                    "account_name" : "aeiou",
                      "current_balance" : 1.23,
                        "payment_due_date" : "2016-02-08T16:39:06.069+0000",
                          "interest_rate" : 1.23,
                            "available_balance" : 1.23,
                              "payment_due_amount" : 1.23,
                                "currency_code" : "aeiou",
                                  "available_credit" : "aeiou"
                                  } ]
                                  ```

                                  </div>

                                  * * *

                                  <div class="method">

                                  <div class="method-path">

                                  ```
                                  post: /categories
                                  ```

                                  </div>

                                  <div class="method-tags"><span class="method-tag">Transactions</span></div>

                                  <div class="method-summary"><span class="nickname">categoriesPost</span></div>

                                  <div class="method-notes">Get transaction categories</div>

                                  ### Parameters

                                  <div class="field-items">

                                  <div class="param">secret (required)</div>

                                  <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                  <div class="param">token (required)</div>

                                  <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                  <div class="param">categoriesRequest (optional)</div>

                                  <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                  </div>

                                  ### Return type

                                  <div class="return-type">[array[category]](#array)</div>

                                  ### Example data

                                  <div class="example-data-content-type">Content-Type: application/json</div>

                                  ```
                                  [ {
                                    "category_id" : "aeiou",
                                      "name" : "aeiou",
                                        "alias" : [ "aeiou" ]
                                        } ]
                                        ```

                                        </div>

                                        * * *

                                        <div class="method">

                                        <div class="method-path">

                                        ```
                                        post: /customer
                                        ```

                                        </div>

                                        <div class="method-tags"><span class="method-tag">Customer</span></div>

                                        <div class="method-summary"><span class="nickname">customerPost</span></div>

                                        <div class="method-notes">Get customer object</div>

                                        ### Parameters

                                        <div class="field-items">

                                        <div class="param">secret (required)</div>

                                        <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                        <div class="param">token (required)</div>

                                        <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                        <div class="param">customerRequest (required)</div>

                                        <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                        </div>

                                        ### Return type

                                        <div class="return-type">[customer](#)</div>

                                        ### Example data

                                        <div class="example-data-content-type">Content-Type: application/json</div>

                                        ```
                                        {
                                          "full_name" : "aeiou",
                                            "user_id" : "aeiou",
                                              "meta" : [ {
                                                  "name" : "aeiou",
                                                      "value" : "aeiou"
                                                        } ],
                                                          "last_name" : "aeiou",
                                                            "first_name" : "aeiou"
                                                            }
                                                            ```

                                                            </div>

                                                            * * *

                                                            <div class="method">

                                                            <div class="method-path">

                                                            ```
                                                            post: /merchants
                                                            ```

                                                            </div>

                                                            <div class="method-tags"><span class="method-tag">Transactions</span></div>

                                                            <div class="method-summary"><span class="nickname">merchantsPost</span></div>

                                                            <div class="method-notes">Get merchants</div>

                                                            ### Parameters

                                                            <div class="field-items">

                                                            <div class="param">secret (required)</div>

                                                            <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                            <div class="param">token (required)</div>

                                                            <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                            <div class="param">merchantsRequest (optional)</div>

                                                            <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                                            </div>

                                                            ### Return type

                                                            <div class="return-type">[array[merchant]](#array)</div>

                                                            ### Example data

                                                            <div class="example-data-content-type">Content-Type: application/json</div>

                                                            ```
                                                            [ {
                                                              "name" : "aeiou",
                                                                "alias" : [ "aeiou" ],
                                                                  "merchant_id" : "aeiou"
                                                                  } ]
                                                                  ```

                                                                  </div>

                                                                  * * *

                                                                  <div class="method">

                                                                  <div class="method-path">

                                                                  ```
                                                                  post: /payees
                                                                  ```

                                                                  </div>

                                                                  <div class="method-tags"><span class="method-tag">Payments</span></div>

                                                                  <div class="method-summary"><span class="nickname">payeesPost</span></div>

                                                                  <div class="method-notes">Get list of payees for a user</div>

                                                                  ### Parameters

                                                                  <div class="field-items">

                                                                  <div class="param">secret (required)</div>

                                                                  <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                  <div class="param">token (required)</div>

                                                                  <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                  <div class="param">payeesRequest (optional)</div>

                                                                  <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                                                  </div>

                                                                  ### Return type

                                                                  <div class="return-type">[array[payee]](#array)</div>

                                                                  ### Example data

                                                                  <div class="example-data-content-type">Content-Type: application/json</div>

                                                                  ```
                                                                  [ {
                                                                    "name" : "aeiou",
                                                                      "alias" : [ "aeiou" ],
                                                                        "payee_id" : "aeiou"
                                                                        } ]
                                                                        ```

                                                                        </div>

                                                                        * * *

                                                                        <div class="method">

                                                                        <div class="method-path">

                                                                        ```
                                                                        post: /payment
                                                                        ```

                                                                        </div>

                                                                        <div class="method-tags"><span class="method-tag">Payments</span></div>

                                                                        <div class="method-summary"><span class="nickname">paymentPost</span></div>

                                                                        <div class="method-notes">Pay funds to a payee</div>

                                                                        ### Parameters

                                                                        <div class="field-items">

                                                                        <div class="param">secret (required)</div>

                                                                        <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                        <div class="param">token (required)</div>

                                                                        <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                        <div class="param">paymentRequest (optional)</div>

                                                                        <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                                                        </div>

                                                                        ### Return type

                                                                        <div class="return-type">[payment](#)</div>

                                                                        ### Example data

                                                                        <div class="example-data-content-type">Content-Type: application/json</div>

                                                                        ```
                                                                        {
                                                                          "payment_id" : "aeiou",
                                                                            "meta" : [ {
                                                                                "name" : "aeiou",
                                                                                    "value" : "aeiou"
                                                                                      } ],
                                                                                        "reference_number" : "aeiou",
                                                                                          "status" : "aeiou"
                                                                                          }
                                                                                          ```

                                                                                          </div>

                                                                                          * * *

                                                                                          <div class="method">

                                                                                          <div class="method-path">

                                                                                          ```
                                                                                          post: /token
                                                                                          ```

                                                                                          </div>

                                                                                          <div class="method-tags"><span class="method-tag">Customer</span></div>

                                                                                          <div class="method-summary"><span class="nickname">tokenPost</span></div>

                                                                                          <div class="method-notes">Get access token for a customer</div>

                                                                                          ### Parameters

                                                                                          <div class="field-items">

                                                                                          <div class="param">secret (required)</div>

                                                                                          <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                                          <div class="param">tokenCredentials (optional)</div>

                                                                                          <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                                                                          </div>

                                                                                          ### Return type

                                                                                          <div class="return-type">[token_response](#)</div>

                                                                                          ### Example data

                                                                                          <div class="example-data-content-type">Content-Type: application/json</div>

                                                                                          ```
                                                                                          {
                                                                                            "user_id" : "aeiou",
                                                                                              "token" : "aeiou"
                                                                                              }
                                                                                              ```

                                                                                              </div>

                                                                                              * * *

                                                                                              <div class="method">

                                                                                              <div class="method-path">

                                                                                              ```
                                                                                              post: /transactions
                                                                                              ```

                                                                                              </div>

                                                                                              <div class="method-tags"><span class="method-tag">Transactions</span></div>

                                                                                              <div class="method-summary"><span class="nickname">transactionsPost</span></div>

                                                                                              <div class="method-notes">Search customer transactions</div>

                                                                                              ### Parameters

                                                                                              <div class="field-items">

                                                                                              <div class="param">secret (required)</div>

                                                                                              <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                                              <div class="param">token (required)</div>

                                                                                              <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                                              <div class="param">transactionCriteria (required)</div>

                                                                                              <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                                                                              </div>

                                                                                              ### Return type

                                                                                              <div class="return-type">[array[transaction]](#array)</div>

                                                                                              ### Example data

                                                                                              <div class="example-data-content-type">Content-Type: application/json</div>

                                                                                              ```
                                                                                              [ {
                                                                                                "transaction_id" : "aeiou",
                                                                                                  "transaction_date" : "2016-02-08T16:39:06.112+0000",
                                                                                                    "amount" : 1.23,
                                                                                                      "check_number" : 123,
                                                                                                        "account_id" : "aeiou",
                                                                                                          "post_date" : "2016-02-08T16:39:06.112+0000",
                                                                                                            "meta" : [ {
                                                                                                                "name" : "aeiou",
                                                                                                                    "value" : "aeiou"
                                                                                                                      } ],
                                                                                                                        "transaction_type" : "aeiou",
                                                                                                                          "category" : "aeiou",
                                                                                                                            "currency_code" : "aeiou",
                                                                                                                              "status" : "aeiou"
                                                                                                                              } ]
                                                                                                                              ```

                                                                                                                              </div>

                                                                                                                              * * *

                                                                                                                              <div class="method">

                                                                                                                              <div class="method-path">

                                                                                                                              ```
                                                                                                                              post: /transfer
                                                                                                                              ```

                                                                                                                              </div>

                                                                                                                              <div class="method-tags"><span class="method-tag">Transfers</span></div>

                                                                                                                              <div class="method-summary"><span class="nickname">transferPost</span></div>

                                                                                                                              <div class="method-notes">Transfer funds between two accounts</div>

                                                                                                                              ### Parameters

                                                                                                                              <div class="field-items">

                                                                                                                              <div class="param">secret (required)</div>

                                                                                                                              <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                                                                              <div class="param">token (required)</div>

                                                                                                                              <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                                                                              <div class="param">transferRequest (optional)</div>

                                                                                                                              <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                                                                                                              </div>

                                                                                                                              ### Return type

                                                                                                                              <div class="return-type">[transfer](#)</div>

                                                                                                                              ### Example data

                                                                                                                              <div class="example-data-content-type">Content-Type: application/json</div>

                                                                                                                              ```
                                                                                                                              {
                                                                                                                                "meta" : [ {
                                                                                                                                    "name" : "aeiou",
                                                                                                                                        "value" : "aeiou"
                                                                                                                                          } ],
                                                                                                                                            "transfer_id" : "aeiou",
                                                                                                                                              "reference_number" : "aeiou",
                                                                                                                                                "status" : "aeiou"
                                                                                                                                                }
                                                                                                                                                ```

                                                                                                                                                </div>

                                                                                                                                                * * *

                                                                                                                                                <div class="method">

                                                                                                                                                <div class="method-path">

                                                                                                                                                ```
                                                                                                                                                post: /validate_otp
                                                                                                                                                ```

                                                                                                                                                </div>

                                                                                                                                                <div class="method-tags"><span class="method-tag">Customer</span></div>

                                                                                                                                                <div class="method-summary"><span class="nickname">validateOtpPost</span></div>

                                                                                                                                                <div class="method-notes">Validate One-Time Password and return new user token</div>

                                                                                                                                                ### Parameters

                                                                                                                                                <div class="field-items">

                                                                                                                                                <div class="param">secret (required)</div>

                                                                                                                                                <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                                                                                                <div class="param">token (required)</div>

                                                                                                                                                <div class="param-desc"><span class="param-type">Header Parameter</span> —</div>

                                                                                                                                                <div class="param">validateOtpRequest (optional)</div>

                                                                                                                                                <div class="param-desc"><span class="param-type">Body Parameter</span> —</div>

                                                                                                                                                </div>

                                                                                                                                                ### Return type

                                                                                                                                                <div class="return-type">[validate_otp_response](#)</div>

                                                                                                                                                ### Example data

                                                                                                                                                <div class="example-data-content-type">Content-Type: application/json</div>

                                                                                                                                                ```
                                                                                                                                                {
                                                                                                                                                  "user_id" : "aeiou",
                                                                                                                                                    "token" : "aeiou"
                                                                                                                                                    }
                                                                                                                                                    ```

                                                                                                                                                    </div>

                                                                                                                                                    * * *

                                                                                                                                                    ## Models

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Merchants_request">Merchants_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Payees_request">Payees_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Categories_request">Categories_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Transfer_request">Transfer_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">source_account_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> source account of transfer</div>

                                                                                                                                                    <div class="param">dest_account_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> destination account of transfer</div>

                                                                                                                                                    <div class="param">amount</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Float</span> amount of transfer</div>

                                                                                                                                                    <div class="param">currency_code</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> currency of amounts (USD, etc.)</div>

                                                                                                                                                    <div class="param">date</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">date</span> date of transfer</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Payment_request">Payment_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">source_account_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> source account of payment</div>

                                                                                                                                                    <div class="param">payee_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> destination payee of payment</div>

                                                                                                                                                    <div class="param">amount</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Float</span> amount of transfer</div>

                                                                                                                                                    <div class="param">currency_code</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> currency of amounts (USD, etc.)</div>

                                                                                                                                                    <div class="param">date</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">date</span> date of payment</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Accounts_request">Accounts_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">account_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Customer_request">Customer_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Validate_otp_request">Validate_otp_request</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">otp</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Validate_otp_response">Validate_otp_response</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">token</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Token_credentials">Token_credentials</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">username</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">password</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Token_response">Token_response</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">token</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Transaction_criteria">Transaction_criteria</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">account_ids</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[String]</span></div>

                                                                                                                                                    <div class="param">limit</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Integer</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Meta_field">Meta_field</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Name of data field</div>

                                                                                                                                                    <div class="param">value</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Value of data field</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Auth_info">Auth_info</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">token</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> New valid token if using SSO tokens</div>

                                                                                                                                                    <div class="param">meta</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[meta_field]</span> Optional data if needed for application</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Transfer_response">Transfer_response</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">auth_info</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">auth_info</span></div>

                                                                                                                                                    <div class="param">transfer</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">transfer</span></div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Customer">Customer</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">user_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">full_name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">first_name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">last_name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">meta</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[meta_field]</span> Optional data if needed for application</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Transfer">Transfer</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">transfer_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">reference_number</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">status</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">meta</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[meta_field]</span> Optional data if needed for application</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Payment">Payment</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">payment_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">reference_number</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">status</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span></div>

                                                                                                                                                    <div class="param">meta</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[meta_field]</span> Optional data if needed for application</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Account">Account</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">account_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> internal ID used by bank for transaction search API</div>

                                                                                                                                                    <div class="param">account_number</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> number used by kasisto - may be masked</div>

                                                                                                                                                    <div class="param">account_name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> account name or nickname</div>

                                                                                                                                                    <div class="param">account_type</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> checking,savings,loan,credit_card</div>

                                                                                                                                                    <div class="param">currency_code</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> currency of amounts (USD, etc.)</div>

                                                                                                                                                    <div class="param">available_balance</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Float</span></div>

                                                                                                                                                    <div class="param">current_balance</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Float</span></div>

                                                                                                                                                    <div class="param">available_credit</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> (for credit_card only)</div>

                                                                                                                                                    <div class="param">payment_due_date</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">date</span> (for credit_card and loan)</div>

                                                                                                                                                    <div class="param">payment_due_amount</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Float</span> (for credit_card and loan)</div>

                                                                                                                                                    <div class="param">interest_rate</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Float</span> Interest rate if applicable</div>

                                                                                                                                                    <div class="param">meta</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[meta_field]</span> Optional data if needed for application</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Transaction">Transaction</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">account_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> ID of account transaction is from</div>

                                                                                                                                                    <div class="param">transaction_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> ID of this transaction</div>

                                                                                                                                                    <div class="param">transaction_type</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Type of transaction</div>

                                                                                                                                                    <div class="param">amount</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Float</span> Amount of transaction (can be positive or negative)</div>

                                                                                                                                                    <div class="param">currency_code</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Currency type of the amount</div>

                                                                                                                                                    <div class="param">category</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Category of transaction if provided</div>

                                                                                                                                                    <div class="param">status</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Status of transaction</div>

                                                                                                                                                    <div class="param">check_number</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">Integer</span> Check number of transaction is a check</div>

                                                                                                                                                    <div class="param">transaction_date</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">date</span> Date of transaction</div>

                                                                                                                                                    <div class="param">post_date</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">date</span> Date of transaction</div>

                                                                                                                                                    <div class="param">meta</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[meta_field]</span> Optional data if needed for application</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Merchant">Merchant</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">merchant_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> ID of merchant</div>

                                                                                                                                                    <div class="param">name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Name of merchant</div>

                                                                                                                                                    <div class="param">alias</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[String]</span> Optional alternative names for this merchant</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Category">Category</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">category_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> ID of transaction category</div>

                                                                                                                                                    <div class="param">name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Name of transaction category</div>

                                                                                                                                                    <div class="param">alias</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[String]</span> Optional alternative names for this category</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <div class="model">

                                                                                                                                                    ### <a name="Payee">Payee</a>

                                                                                                                                                    <div class="field-items">

                                                                                                                                                    <div class="param">payee_id</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> ID of payee</div>

                                                                                                                                                    <div class="param">name</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">String</span> Name of payee</div>

                                                                                                                                                    <div class="param">alias</div>

                                                                                                                                                    <div class="param-desc"><span class="param-type">array[String]</span> Optional alternative names for this payee</div>

                                                                                                                                                    </div>

                                                                                                                                                    </div>

                                                                                                                                                    <style>body { font-family: Trebuchet MS, sans-serif; font-size: 15px; color: #444; margin-right: 24px; } h1 { font-size: 25px; } h2 { font-size: 20px; } h3 { font-size: 16px; font-weight: bold; } hr { height: 1px; border: 0; color: #ddd; background-color: #ddd; display: none; } .app-desc { clear: both; margin-left: 20px; } .param-name { width: 100%; } .license-info { margin-left: 20px; } .license-url { margin-left: 20px; } .model { margin: 0 0 0px 20px; } .method { margin-left: 20px; } .method-notes { margin: 10px 0 20px 0; font-size: 90%; color: #555; } pre { padding: 10px; margin-bottom: 2px; } pre.get { background-color: #0f6ab4; } pre.post { background-color: #10a54a; } pre.put { background-color: #c5862b; } pre.delete { background-color: #a41e22; } .huge { color: #fff; } pre.example { background-color: #f3f3f3; padding: 10px; border: 1px solid #ddd; } code { white-space: pre; } .nickname { font-weight: bold; } .method-path { font-size: 1.5em; background-color: #0f6ab4; } .parameter { width: 500px; } .param { width: 500px; padding: 10px 0 0 20px; font-weight: bold; } .param-desc { width: 700px; padding: 0 0 0 20px; color: #777; } .param-type { font-style: italic; } .field-label { padding: 0; margin: 0; clear: both; } .field-items { padding: 0 0 15px 0; margin-bottom: 15px; } .return-type { clear: both; padding-bottom: 10px; } .param-header { font-weight: bold; } .method-tags { text-align: right; } .method-tag { background: none repeat scroll 0% 0% #24A600; border-radius: 3px; padding: 2px 10px; margin: 2px; color: #FFF; display: inline-block; text-decoration: none; }</style>
