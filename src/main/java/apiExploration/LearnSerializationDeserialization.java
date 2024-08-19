package apiExploration;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnSerializationDeserialization {

	 @Test
	    public void postIncident() {

	        // Set the base URI
	        RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

	        // Add the authentication
	        RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

	        // Create an Incident object (serialization)
	        Incident incident = new Incident("This is created by RestAssured", "681ccaf9c0a8016400b98a06818d57c7");

	        // Construct the request and serialize the Incident object to JSON
	        RequestSpecification request = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(incident)  // Serialize the Incident object to JSON
	                .log().all();

	        // Send the POST request and capture the response
	        Response response = request.post();

	        // Print the response body
	        response.prettyPrint();

	        // Deserialize the response JSON back into an Incident object
	        Incident responseIncident = response.as(Incident.class);

	        // Print the deserialized object's details
	        System.out.println("Deserialized Incident:");
	        System.out.println("Short Description: " + responseIncident.getShort_description());
	        System.out.println("Caller ID: " + responseIncident.getCaller_id());
	    }

}
