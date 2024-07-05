package week3.day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentwithBodyasFilewithCategory {

	@Test
	public void createIncidentwithBodyAsFile() {
		
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");
      
      File file= new File("./src/test/resources/data1.json");
      
      
      //Method overloading body parameter uses/accepts file as parameter and also string
      RequestSpecification inputRequest = RestAssured.given()
    		  								.contentType(ContentType.JSON)
    		  								.body(file);
      
//      Step 4 - send the request(http methods)
      Response response = inputRequest.post();
      
//      Step 5 - Validate the response
      response.prettyPrint();
	}
}
