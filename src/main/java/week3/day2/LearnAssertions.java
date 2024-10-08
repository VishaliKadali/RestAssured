package week3.day2;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnAssertions {

	@Test
	public void simpleAssert() {
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
		Response response=input.post();
		response.then().assertThat().statusCode(201);
		
	}
	
	@Test
	public void AssertEquals() {
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
		Response response=input.get();
		response.then().assertThat().body("result[0].number", Matchers.equalTo("INC0000060"));
		
	}
	
	@Test
	public void AssertContains() {
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
		Response response=input.get();
		response.then().assertThat().body("result[0].number", Matchers.containsString("INC"));
		
	}
	
	@Test
	public void AssertHasItem() {
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

//      Step 3- construct the request (params, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON).log().all();
		Response response=input.get();
		response.then().assertThat().body("result.number", Matchers.hasItem("INC0000051"));
		
	}
	
	
}
