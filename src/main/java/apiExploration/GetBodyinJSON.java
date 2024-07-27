package apiExploration;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class GetBodyinJSON {
	
	
	@Test
	public void getBodyasJSON() {
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

		// Construct the request (params, auth etc)
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

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
		
		String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

       
     // Convert the response body to a JSON object
//        JsonPath jsonPath = response.jsonPath();
//        JSONObject jsonResponse = new JSONObject(jsonPath.getMap("$"));
//        System.out.println("JSON Response: " + jsonResponse.toString(4)); // Pretty print JSON
	}

}
