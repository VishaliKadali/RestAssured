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

		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).log().all();
		Response response=request.get();
		
		List<String> sys_id=response.jsonPath().getList("result.sys_id");
		System.out.println("Count of Sys_id " +sys_id.size());
		//System.out.println(" ***********This is just to check how the result is being displayed******** "+response.jsonPath().get("result.sys_id[2]"));
		response.then().log().all();
	}
}
