package apiExploration;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnOptions {
	
	@Test
	public void getRequest() {	
		//Set the endpoint
		RestAssured.baseURI="https://dev231612.service-now.com/api/now/table";
		
		//Add the auth
		RestAssured.authentication=RestAssured.basic("admin", "eJ70Jq$ERc+p");
		
		//Construct the request
		Response response=RestAssured.given().when().options("/incident");
		
		//Print the response
		//response.asString();
		response.prettyPrint();
		
		//Assert the status code
		response.then().assertThat().statusCode(200);
		
		//Assert specific headers if needed
		// Assert specific headers if needed
        response.then().assertThat().header("Allow", Matchers.allOf(
            Matchers.containsString("GET"),
            Matchers.containsString("POST"),
            Matchers.containsString("OPTIONS")
        ));
	}
	//Options will return the methods allowed for particular request
}
