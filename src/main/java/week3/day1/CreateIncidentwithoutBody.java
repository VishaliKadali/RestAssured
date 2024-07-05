package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentwithoutBody {

	@Test
	public void createIncident() {
		
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");
      
      RequestSpecification inputRequest = RestAssured
    		  								.given()
    		  								.contentType(ContentType.JSON);
      
//      Step 4 - send the request(http methods)
      Response response = inputRequest.post();
      
//      Step 5 - Validate the response
      response.prettyPrint();
	}
}
