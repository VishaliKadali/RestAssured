package week5.day2.mocking;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockUsingTemplate {
	
	@Test
	private void incidentCreation() {
		RestAssured.baseURI="http://localhost:8080/testleaf/training/course";
		
		Response response= RestAssured.given()
							.contentType(ContentType.JSON)
							.queryParam("course_name", "Selenium")
							.queryParam("Mode_Of_Learning", "Online")
							.get();
		response.prettyPrint();
		response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}

}
