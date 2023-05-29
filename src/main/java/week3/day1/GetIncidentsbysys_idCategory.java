package week3.day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidentsbysys_idCategory {

	@Test
	public void getIncidents() {
		
		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");
      
      Map<String,String> queryMap=new HashMap<String,String>();
      queryMap.put("sysparm_fields", "sys_id,category");
      queryMap.put("category","Software");
      
      RequestSpecification inputParams = RestAssured.given()
    		  						.queryParams(queryMap);
      
//      Step 4 - send the request(http methods)
      Response response = inputParams.get();
      
//      Step 5 - Validate the response
      response.prettyPrint();
	}
}
