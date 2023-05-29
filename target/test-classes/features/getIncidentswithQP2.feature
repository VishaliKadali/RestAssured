Feature: ServiceNow Incident Management

Scenario: Get all the incidents with Query Parameter

Given set the endpoint
And add the auth
And add the queryParams
|sysparm_fields|sys_id,category|
|category|software|
When send the request with QP
Then validate the response

