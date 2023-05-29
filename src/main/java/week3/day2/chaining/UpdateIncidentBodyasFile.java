package week3.day2.chaining;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncidentBodyasFile extends BaseClass {

	@Test(dependsOnMethods = { "week3.day2.chaining.CreateIncident.createIncident" })
	public void updateIncidentWithBodyAsFile() {

		File file = new File("./src/test/resources/body.json");
		response = request.body(file).put("incident/" + sys_id);
		// response.jsonPath().get("result.number");
		String IncidentNumber = response.jsonPath().get("result.number");
		String shortDescription = response.jsonPath().get("result.short_description");
		response.then().assertThat().body("result.number", Matchers.containsString(IncidentNumber))
				.body("result.short_description", Matchers.containsString(shortDescription))
				.statusLine("HTTP/1.1 200 OK");
	}

}
