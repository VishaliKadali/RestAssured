Feature: ServiceNow Incident Management

Scenario Outline: Create Incident with Short-description and category

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "sys_id, number, category, short_description"
When post the request with short description as "<short_desc>" and category as "<category>"
Then validate the response for "<value>" and "<short_desc>" and "<category>"


Examples:
|value|short_desc|category|
#First request
|1|This is First Request|software|
#Second request
|2|This is Second Request|hardware|
#Third request
|3|This is Third Request|inquiry|
|3|This is Third Request|inquiry|