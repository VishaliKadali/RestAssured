package week3.day2.chaining;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncidentVerifyText extends BaseClass {

	@Test(dependsOnMethods = { "week3.day2.chaining.CreateIncident.createIncident" })
	public void updateIncVerifyText() {

		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n" + "    \"short_description\" : \"Using patch method for hamcrest\"\r\n" + "}");
		response = request.patch("incident/" + sys_id);
		String IncidentNumber = response.jsonPath().get("result.number");
		response.then().assertThat().body("result.number", Matchers.containsString(IncidentNumber));
		response.then().assertThat().body("result.short_description", Matchers.containsString("hamcrest"));

	}
}
