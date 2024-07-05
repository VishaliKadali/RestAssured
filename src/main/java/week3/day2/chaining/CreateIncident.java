package week3.day2.chaining;

import org.testng.annotations.Test;


public class CreateIncident extends BaseClass{

	@Test
	public void createIncident() {
		
		response=request.body("{\r\n"
				+ "    \"short_description\": \"Good Start\",\r\n"
				+ "    \"description\": \"Vishali\",\r\n"
				+ "    \"category\": \"Software\"\r\n"
				+ "}").post("incident");
		sys_id=response.jsonPath().get("result.sys_id");
		System.out.println("Sys_id is "+sys_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(201);
	}
	
}
