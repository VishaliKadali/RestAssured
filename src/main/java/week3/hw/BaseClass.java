package week3.hw;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	static RequestSpecification request=null;
	static String sys_id=null;
	static Response response=null;
	
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI="https://dev231612.service-now.com/api/now/table/";
		RestAssured.authentication=RestAssured.basic("admin","eJ70Jq$ERc+p");
		request=RestAssured.given().contentType(ContentType.JSON).log().all();
		//RestAssured.given().contentType(ContentType.JSON);
		//request=RestAssured.given().contentType(ContentType.JSON).log().all();

	}
	
	@AfterMethod
	public void tearDown() {
		response.then().log().all();
	}
}
