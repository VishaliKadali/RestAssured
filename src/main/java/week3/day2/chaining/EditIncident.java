package week3.day2.chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EditIncident extends BaseClass{
	
	@Test(dependsOnMethods = {"week3.day2.chaining.CreateIncident.createIncident"})
	public void editIncident() {
		
		/*
		 * RequestSpecification request =
		 * RestAssured.given().contentType(ContentType.JSON)
		 * .body("{\"category\":\"Engineer\",\"description\":\"Learning rest api automation\"}"
		 * ); response = request.put("incident/"+sys_id);
		 */
		
		response=request.body("{\"category\":\"Engineer\",\"description\":\"Learning rest api automation\"}")
				.put("incident/"+sys_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(200);
		
	}

}
