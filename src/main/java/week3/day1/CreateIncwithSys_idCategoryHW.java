package week3.day1;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncwithSys_idCategoryHW {

	@Test
	public void createIncidentwithSys_idCategory() {

		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/incident";

		// Construct the request (params, auth etc)
		RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");

		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("sysparm_fields", "number,category,sys_id");
		queryMap.put("category", "Hardware");
		RequestSpecification inputParams = RestAssured.given().contentType(ContentType.JSON).queryParams(queryMap).log()
				.all();
		RequestSpecification inputRequest = inputParams.given().contentType(ContentType.JSON)
				.body("{\r\n" + "    \"short_description\" : \"This is created by RestAssured\",\r\n"
						+ "   \"caller_id\": \"681ccaf9c0a8016400b98a06818d57c7\"\r\n" + "}")
				.log().all();

		Response response = inputRequest.post();

		response.prettyPrint();

		String incidentNumber = response.jsonPath().getString("result.number");
		String sys_id = response.jsonPath().get("result.sys_id");
		String category = response.jsonPath().getString("result.category");

		response.then().assertThat().body("result.number", Matchers.containsStringIgnoringCase(incidentNumber));
		response.then().assertThat().body("result.sys_id", Matchers.containsStringIgnoringCase(sys_id));
		response.then().assertThat().body("result.category", Matchers.containsStringIgnoringCase(category));
	}

}
