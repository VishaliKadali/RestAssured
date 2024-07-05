package week3.hw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class CreateCR extends week3.hw.BaseClass{

	@Test
	public void getCR() {
		Map<String, String> queryMap = new HashMap<String,String>();
		  queryMap.put("sysparm_fields", "number,category");
		  queryMap.put("category","Software");
			request.queryParams(queryMap);
			response=request.get("change_request");
			//sys_id=response.jsonPath().get("result[0].sys_id");
			List<Object> IncidentNumbers = response.jsonPath().getList("response.number");
			System.out.println(IncidentNumbers);
			System.out.println("sys_id is "+sys_id);
			response.then().assertThat().statusCode(200);
		
		
	}
	
	@Test
	public void createCR() {
		response=request.body("{\r\n"
				+ "    \"short_description\": \"Good Start\",\r\n"
				+ "    \"description\": \"Vishali\",\r\n"
				+ "    \"category\": \"Software\"\r\n"
				+ "}")
				.post("change_request");
		sys_id=response.jsonPath().get("result.sys_id");
		System.out.println("sys_id is "+sys_id);
		response.then().assertThat().statusCode(201);
	}
	
	@Test(dependsOnMethods={"week3.hw.CreateCR.createCR"})
	public void editCR() {
		
		/*
		 * RequestSpecification request =
		 * RestAssured.given().contentType(ContentType.JSON)
		 * .body("{\"category\":\"Engineer\",\"description\":\"Learning rest api automation\"}"
		 * );
		 */
		response=request.body("{\r\n"
				+ "    \"category\": \"Hardware\",\r\n"
				+ "    \"short_description\": \"I am working on service now put request\"\r\n"
				+ "}")
				.put("change_request/"+sys_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
	
	}
	
	@Test(dependsOnMethods = {"week3.hw.CreateCR.createCR"})
	public void updateCR() {
		
		response=request.body("{\r\n"
				+ "    \"short_description\": \"Using patch method for hamcrest\"\r\n"
				+ "}")
				.patch("change_request/"+sys_id);
		response.then().assertThat().statusCode(200);
	}

	@Test(dependsOnMethods={"week3.hw.CreateCR.updateCR"})
	public void deleteCR() {
		response = request.delete("change_request/"+sys_id);
		response.then().assertThat()
				.statusCode(204)
				.statusLine("HTTP/1.1 204 No Content");
		
	}

}
