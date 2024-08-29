package week5.day2.mocking;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Stub {
	
	
	  @BeforeMethod public void stubIncident() { 
		  //When the post call comes, it should return the response
	  WireMock.stubFor(WireMock.post("/api/now/table/incident")
	  .willReturn(WireMock.aResponse() .withStatus(201)
	  .withHeader("content-type","application/json") .withBody("{\r\n" +
	  "    \"result\": {\r\n" +
	  "        \"short_description\": \"My first test with Rest Assured wiremock\",\r\n"
	  + "        \"category\": \"inquiry\"\r\n" + "    }\r\n" + "}"))); }
	 
	@Test
	public void createIncident() {
		//RestAssured.baseURI="https://dev231612.service-now.com/api/now/table/incident";
		RestAssured.baseURI="http://localhost/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "Us/xZ85k@IyN");
		RequestSpecification request=RestAssured.given().contentType(ContentType.JSON);
		Response response=request.post();
		response.prettyPrint();
		response.then().assertThat().statusCode(201);
		response.then().assertThat().body("result.category",Matchers.equalTo("inquiry"));
		
	}
}
