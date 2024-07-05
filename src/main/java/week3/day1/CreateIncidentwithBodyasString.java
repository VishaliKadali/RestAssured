package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentwithBodyasString {

	@Test
	public void getIncidents() {
		
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");
      
      RequestSpecification inputRequest = RestAssured.given()
    		  								.contentType(ContentType.JSON)
    		  								.body("{\r\n"
    		  										+ "    \"short_description\" : \"This is created by postman\",\r\n"
    		  										+ "    \"caller_id\": \"681ccaf9c0a8016400b98a06818d57c7\"\r\n"
    		  										+ "}");
      
//      Step 4 - send the request(http methods)
      Response response = inputRequest.post();
      
//      Step 5 - Validate the response
      response.prettyPrint();
	}
}
