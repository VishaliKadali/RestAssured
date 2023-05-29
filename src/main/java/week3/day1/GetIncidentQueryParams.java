package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidentQueryParams {

	@Test
	public void getIncidents() {
		
		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");
      
//      Constructed request
      RequestSpecification inputParams = RestAssured.given().queryParam("sysparm_fields", "number");
     
  //    Step 4 - send the request(http methods)
      Response response = inputParams.get();
//      Step 5 - Validate the response
      response.prettyPrint();
	}
}
