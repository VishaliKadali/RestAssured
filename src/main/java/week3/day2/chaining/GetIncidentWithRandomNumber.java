package week3.day2.chaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetIncidentWithRandomNumber extends BaseClass {
	
	@Test
	public void getIncidentWithRandomNumber() {
		
		response=request.get("incident");
	
					response.then().assertThat()
						.statusCode(200);
		
	}	

}
