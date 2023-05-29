package week3.day2;

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

		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		Response response=request.post();
		
		String sys_id=response.jsonPath().get("result.sys_id");
		System.out.println("Value of sys_id is " +sys_id);
		//response.then().log().all();
	}


}
