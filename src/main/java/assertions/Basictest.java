package assertions;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basictest {

	public void basicTest() {
		RestAssured.baseURI="www.mock.com";
		RestAssured.authentication=RestAssured.basic("", "");
		/*
		 * Map<String, String> querymap=new HashMap<String,String>();
		 * querymap.put("customer","firstname,lastname");
		 */
		RequestSpecification request=RestAssured.given().contentType(ContentType.JSON).queryParam("customer","firstname,lastname").log().all();
		
		
		Response response=request.get("/policyNumber/{id}");
		
		
		response.prettyPrint();
		
	}

}
