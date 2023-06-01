package week5.day2.mocking;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Recorder {
	@Test
	public void createIncident() {
		//RestAssured.baseURI="https://dev104781.service-now.com/api/now/table/incident";
		//Give this in the target url of the wiremock https://dev104781.service-now.com
		//Once you start recording from wiremock comment RestAssured.baseURI="https://dev104781.service-now.com/api/now/table/incident"; 
		//run with local host
		RestAssured.baseURI="http://localhost/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "Us/xZ85k@IyN");
		RequestSpecification request=RestAssured.given().contentType(ContentType.JSON);
		Response response=request.post();
		response.prettyPrint();
		response.then().assertThat().statusCode(201);
		response.then().assertThat().body("result.category", Matchers.equalTo("inquiry"));
		
	}
	

}
