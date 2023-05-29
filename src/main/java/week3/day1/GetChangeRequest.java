package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetChangeRequest {

	@Test
	public void getAllChangeRequests() {
		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/change_request";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");

//      Step 4 - send the request(http methods)
		Response response = RestAssured.get();

//      Step 5 - Validate the response
		response.prettyPrint();

	}
}
