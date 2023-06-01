package week5.day2.schemaValidations;

import java.io.File;

import org.testng.annotations.Test;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SchemaValidations {
	@Test
	public void createIncident() {
		RestAssured.baseURI="https://dev104781.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "Us/xZ85k@IyN");
		File file=new File("./src/test/resources/schema.json");
		RequestSpecification request=RestAssured.given().contentType(ContentType.JSON).log().all();
		Response response=request.post();
		//response.prettyPrint();
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
	}
}
