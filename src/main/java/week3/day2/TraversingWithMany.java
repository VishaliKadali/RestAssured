package week3.day2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TraversingWithMany {

	
	@Test
	public void traverseCreateIncident() {

		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");

		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		Response response=request.get();
		
		List<String> sys_id=response.jsonPath().getList("result.sys_id");
		System.out.println("Count of Sys_id " +sys_id.size());
		//System.out.println(response.jsonPath().get("result[0].sys_id"));
		response.then().log().all();
	}
}
