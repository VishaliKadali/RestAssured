package week3.day2;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TraversingWithSingle {
	
	@Test
	public void traverseCreateIncident() {

		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");
		Map<String, String> queryMap=new HashMap<String,String>();
		queryMap.put("sysparm_fields", "Category, sys_id, number");
		RequestSpecification request = RestAssured.given().queryParams(queryMap).contentType(ContentType.JSON);
		Response response=request.post();
		
		String sys_id=response.jsonPath().get("result.sys_id");
		System.out.println("Value of sys_id is " +sys_id);
		String number=response.jsonPath().getString("result.number");
		System.out.println("Incident Number is " +number);
		response.prettyPrint();
		response.then().assertThat().body("result.number",Matchers.containsString("INC"));
		response.then().log().all();
	}


}
