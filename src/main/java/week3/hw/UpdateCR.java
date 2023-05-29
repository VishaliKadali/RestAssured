package week3.hw;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UpdateCR extends BaseClass{
	
	@Test(dependsOnMethods = {"week3.hw.CreateCR.createCR"})
	public void updateCR() {
		
		response=request.body("{\r\n"
				+ "    \"short_description\": \"Using patch method for hamcrest\"\r\n"
				+ "}")
				.patch("change_request/"+sys_id);
		response.then().assertThat().statusCode(200);
	}

}
