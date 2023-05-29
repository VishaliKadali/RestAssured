package week3.hw;

import java.util.List;

import org.testng.annotations.Test;

public class GetCR extends week3.hw.BaseClass{
	
	@Test
	public void getCR() {
		
			response=request.get("change_request");
			//sys_id=response.jsonPath().get("result[0].sys_id");
			List<Object> IncidentNumbers = response.jsonPath().getList("response.number");
			System.out.println(IncidentNumbers);
			System.out.println("sys_id is "+sys_id);
			response.then().assertThat().statusCode(200);
		
		
	}

}
