package week3.day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidentQueryParamsMultiple {

	@Test
	public void getIncidents() {
		
		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");
      
 //Create a map to add mutiple values
      Map<String,String> queryMap=new HashMap<String,String>();
      queryMap.put("sysparm_fields", "number,category,sys_id");
      queryMap.put("category","Software");
      
      RequestSpecification inputRequest = RestAssured.given().queryParams(queryMap);
      
		/*
		 * // Constructed request RequestSpecification inputParams = RestAssured.given()
		 * .queryParam("sysparm_fields", "number,category")
		 * .queryParam("category","Software");
		 */
     
  //    Step 4 - send the request(http methods)
      Response response = inputRequest.get();
      
      
//      Step 5 - Validate the response
      response.prettyPrint();
	}
}
