package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
	 
	@Before
	public void startTest() {
		System.out.println("Start the test");
	}
	
	@After
	public void endTest() {
		System.out.println("End of the test");
	}
}
