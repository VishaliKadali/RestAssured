package apiExploration;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LearnSerializationDeserialization {

	@Test
	public void postIncident() {

		// Step2 - Endpoint + Resource

		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table";

		// Add the auth
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

		// Construt the request
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).log().all();

	}

}
