package apiExploration;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnHead {
	
	@Test
	public void getIncident() {
		
		
		//Step2 - Endpoint + Resource
		
		RestAssured.baseURI="https://dev231612.service-now.com/api/now/table";
		
		//Add the auth
		RestAssured.authentication=RestAssured.basic("admin", "eJ70Jq$ERc+p");
		
		//Construt the request
		RequestSpecification request=RestAssured.given().contentType(ContentType.JSON).log().all();
		
		// Send the HEAD request
        Response headResponse = request.head("/incident");
        System.out.println("HEAD Response Headers:" +headResponse.getStatusCode());
        headResponse.getHeaders().forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));
        
		//Send the reuqest
//		Response response=request.get("/incident");
		
		//headResponse.prettyPrint(); // This won't print anything since HEAD responses have no body
//		 // Print limited part of the response body for readability
//        String responseBody = response.getBody().asString();
//        int maxOutputLength = 1000; // Limit output length for readability
//        if (responseBody.length() > maxOutputLength) {
//            System.out.println("GET Response Body (truncated): " + responseBody.substring(0, maxOutputLength) + "...");
//        } else {
//            System.out.println("GET Response Body: " + responseBody);
//        }
		
	}

}
