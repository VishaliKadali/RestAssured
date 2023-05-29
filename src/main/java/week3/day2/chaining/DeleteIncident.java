package week3.day2.chaining;

import org.apache.http.StatusLine;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass {

	@Test(dependsOnMethods= {"week3.day2.chaining.CreateIncident.createIncident"})
	public void deleteIncident() {
		response = request.delete("incident/"+sys_id);
		response.then().assertThat()
				.statusCode(204)
				.statusLine("HTTP/1.1 204 No Content");
	}

}
