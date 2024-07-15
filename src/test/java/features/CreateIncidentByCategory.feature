Feature: ServiceNow Incident Management

Scenario Outline: Create Incident using post method

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "sys_id, category"
When post the request with category as "<category>"
Then validate the response as 201

Examples:
|category|
#1st row twice
|software|
|software|
#2nd row
|inquiry|

