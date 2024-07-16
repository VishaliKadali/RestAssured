Feature: ServiceNow Incident Management

Scenario: Get all the incidents with multiquery params 

Given set the endpoint
When add the auth
And add the queryParams as "sysparm_fields" and "sys_id, number, category"
When send the request
Then validate the response

Scenario: Get all incidents 

Given set the endpoint
When add the auth
And add the queryParams
|sysparm_fields| sys_id, number, category, short_description, description|
|category|software|
When post the request
Then validate the response as below
|result.approval|not requested|
|result.knowledge|false|
|result.urgency|3|

