package week3.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Logs {

	@Test
	public void logs() {

		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");

		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON).log().all();
		Response response=input.post();
		response.prettyPrint();
		response.then().log().all();
	}

}
