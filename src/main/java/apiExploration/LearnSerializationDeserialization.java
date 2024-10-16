package apiExploration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LearnSerializationDeserialization {

	@Test
	public void postIncident() {
	    RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";
	    RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

	    // Set the default parser
	    RestAssured.defaultParser = Parser.JSON;

	    // Make the POST request
	    Response response = RestAssured.given()
	        .contentType(ContentType.JSON)
	        .body("{\n" +
	              "    \"short_description\": \"This is created by RestAssured\",\n" +
	              "    \"caller_id\": \"681ccaf9c0a8016400b98a06818d57c7\"\n" +
	              "}") // Removed sys_id and number
	        .post();

	    // Log the response
	    response.prettyPrint();

	    // Validate the response
	    response.then().assertThat().statusCode(201); // or the expected status code

    }
}
