package week5.day2.staticImports;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StaticImports {
	
	@Test
	public void createIncident() {
		RestAssured.baseURI="https://dev231612.service-now.com/api/now/table";
		RestAssured.authentication=RestAssured.basic("admin","eJ70Jq$ERc+p");
		RequestSpecification request=RestAssured.given().contentType(ContentType.JSON);
		Response response=request.post();
		response.prettyPrint();
	}
	
	@Test
	public void createIncidentWithStaticImports() {
		baseURI="https://dev231612.service-now.com/api/now/table";
		authentication=RestAssured.basic("admin","eJ70Jq$ERc+p");
		RequestSpecification request=RestAssured.given().contentType(ContentType.JSON);
		Response response=request.post();
		response.prettyPrint();
	}

}
