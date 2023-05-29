Feature: ServiceNow ChangeRequest Management

Background: 
Given set the endpoint
And add the auth
And construct the request


Scenario: Create changeRequest
Given send the post request for crTable
Then validate the response as 201

Scenario: Get changeRequest 
Given send the get request for crTable
Then validate the response as 200

Scenario: Get all changeRequests
And add the queryParams
|sysparm_fields|sys_id,category|
|category|software|
Given send the get request for all CR
Then validate the response for random_sys_id and response as 200


Scenario: Update changeRequest
Given send the put for crTable
Then validate the response for put 

@E2ETest
Scenario: Delete changeRequest
Given send the delete for crTable
Then validate the response for delete