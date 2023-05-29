package week3.hw;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EditCR extends week3.hw.BaseClass{
	
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
}
