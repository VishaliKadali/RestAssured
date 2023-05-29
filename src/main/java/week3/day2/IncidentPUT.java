package week3.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentPUT {

	
	@Test
	public void putincident() {
		
RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");
      
      RequestSpecification putRequest = RestAssured.given()
    		  								.contentType(ContentType.JSON)
    		  								.body("{\r\n"
    		  										+ "    \"category\": \"Hardware\",\r\n"
    		  										+ "    \"short_description\": \"I am working on service now put request\"\r\n"
    		  										+ "}");
      
//      Step 4 - send the request(http methods)
      Response response = putRequest.put();
      
//      Step 5 - Validate the response
      response.prettyPrint();
	}
}
