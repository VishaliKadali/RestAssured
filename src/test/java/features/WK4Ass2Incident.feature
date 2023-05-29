Feature: ServiceNow Incident Management includes get, create, delete, update


Scenario: Get all incidents with QueryParams
Given set the endpoint
And add the auth
And construct the request
And add the queryParams
|sysparm_fields|sys_id,category|
|category|software|
When send the request
Then validate the response as 200

Scenario Outline: Create Incidents
Given set the endpoint
And add the auth
And construct the request
And add the queryParams as "sysparm_fields" and "sys_id, number, category"
When post the request with short description as "<short_desc>" and category as "<category>"
Then validate the response

Examples:
 |short_desc|category|
 # 1st data row
 |Create Incident with body as string 1|software|
 # 2nd data row
 |Create Incident with body as string 2|hardware|

Scenario Outline: Create Incident
Given set the endpoint
And add the auth
And construct the request
When post the request as "<short_desc>" and category as "<category>"
Then validate the response for task_effective_number

Examples:
|short_desc|category|
 # 1st data row
|Create Incident with body as string 1|software|
 # 2nd data row
|Create Incident with body as string 2|hardware|

