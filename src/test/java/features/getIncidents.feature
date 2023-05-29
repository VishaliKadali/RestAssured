Feature: Incident Management

Scenario: Get Incident by sys_id
Given set the endpoint
And add the auth
And construct the request
When send the request
Then validate the response as 200


