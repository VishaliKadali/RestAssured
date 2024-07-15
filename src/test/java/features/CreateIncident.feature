Feature: ServiceNow Incident Management

Scenario: Create Incident

Given set the endpoint
And add the auth
When send the postrequest
Then validate the response as 200


