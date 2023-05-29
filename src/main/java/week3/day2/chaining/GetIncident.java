package week3.day2.chaining;

import java.util.List;

import org.testng.annotations.Test;

public class GetIncident extends BaseClass{
	
	@Test
	public void getIncident() {
		
			response=request.get("incident");
			sys_id = response.jsonPath().get("result[0].sys_id");
			System.out.println("Sys id is " +sys_id);
			response.then().assertThat().statusCode(200).log().all();
	
	}

}
