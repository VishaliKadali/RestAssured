package week5.day2.mocking;



import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import io.cucumber.java.Before;

public class StartWiremockServer {

	
	private WireMockServer wireMockServer;
	
	@Before
	public void setUp() {
		//wireMockServer=new WireMockServer(wireMockConfig().port(8080)); // or .dynamicPort() for a random port
		wireMockServer=new WireMockServer(WireMockConfiguration.DEFAULT_PORT);
		wireMockServer.start();
	}
	
	public void tearDown() {
		wireMockServer.stop();
	}
}
