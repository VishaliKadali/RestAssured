Feature: ServiceNow Incident Management

Scenario: Get all the incidents with multi query params

Given add the queryParams as "sysparm_fields" and "sys_id, number, category"
When send the request
Then validate the response as 200

Scenario: Get all the incidents

Given add the queryParams
|sysparm_fields|sys_id, number, category |
|category|software|
When send the request
Then validate the response as 200