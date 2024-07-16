package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class BaseTest {
	 
	/*
	 * @Before public void startTest() { System.out.println("Start the test"); }
	 * 
	 * @After public void endTest() { System.out.println("End of the test"); }
	 */
	@Before
	public void setup() {
		RestAssured.baseURI="https://dev231612.service-now.com/api/now/table/";
		RestAssured.authentication=RestAssured.basic("admin","eJ70Jq$ERc+p");
	}
}
