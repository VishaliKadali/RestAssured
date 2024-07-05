package week3.day1;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentWithRandomData {
	@Test
	public void createIncidentWithRandomData() {
		
		Random random=new Random();
		int randomInt=random.nextInt();
		System.out.println("Random Integers" +randomInt);
		
		double randomDoubles=random.nextDouble();
		System.out.println(randomDoubles);
		
		float randomfloat=random.nextFloat();
		System.out.println(randomfloat);
		
		long randomlong=random.nextLong();
		System.out.println(randomlong);
		
		RestAssured.baseURI="https://dev231612.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "eJ70Jq$ERc+p");
		
		RequestSpecification inputRequest = RestAssured.given()
					.contentType(ContentType.JSON)
					.body("{\r\n"
							+ "    \"description\" : \"My first test with Rest Assured" + randomInt + "\",\r\n"
							+ "    \"short_description\" : \"Success\"\r\n"
							+ "   \r\n"
							+ "}");
		Response response=inputRequest.post();
		response.prettyPrint();
		response.then().assertThat().statusCode(201);
		
	}
}
