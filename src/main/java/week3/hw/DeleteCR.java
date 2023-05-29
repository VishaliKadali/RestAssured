package week3.hw;

import org.testng.annotations.Test;

public class DeleteCR extends week3.hw.BaseClass {

	@Test(dependsOnMethods={"week3.hw.CreateCR.updateCR"})
	public void deleteCR() {
		response = request.delete("change_request/"+sys_id);
		response.then().assertThat()
				.statusCode(204)
				.statusLine("HTTP/1.1 204 No Content");
		
	}
}
