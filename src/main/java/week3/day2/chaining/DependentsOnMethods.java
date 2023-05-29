package week3.day2.chaining;

import org.testng.annotations.Test;

public class DependentsOnMethods extends BaseClass {
	
	@Test(dependsOnMethods = {"week3.day2.chaining.CreateIncident.createIncident"})
	public void deleteIncident() {
		
		response=request.delete("incident/"+sys_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(204);
	}


}
