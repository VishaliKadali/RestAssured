package week3.day2.chaining;

import org.testng.annotations.Test;

public class DeleteIncidentVerifyRecord extends BaseClass {
	
	@Test(dependsOnMethods = {"week3.day2.chaining.CreateIncident.createIncident"})
	public void deleteIncident() {
			response=request.delete("incident/"+sys_id);
			response.then().assertThat()
			.statusCode(204);
		
		
	}
	@Test(dependsOnMethods = {"week3.day2.chaining.DeleteIncidentDependentOnGet.deleteIncident"})
	public void verifyDeleteIncident() {
		response=request.get("incident/"+sys_id);
				response.then().assertThat()
				.statusCode(404);	
	}
}
