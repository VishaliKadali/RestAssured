package week3.day1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentBasedOnFiles {
	
	@Test
	public void createIncidentBasedonFile() {
		// TODO Auto-generated method stub4
		String filePath;
		RestAssured.baseURI="https://dev231612.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "eJ70Jq$ERc+p");
		try {
		String path="./src/test/resources";
		
		for(int i=1;i<=2;i++) {
			filePath=path+"/file"+i+".json";
			
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			writer.write("{\r\n"
					+ "    \"description\": \"My first test with Rest Assured\",\r\n"
					+ "    \"short_description\": \"Success\"\r\n"
					+ "}");
			
			writer.flush(); // Flush the writer to ensure content is written to the file
			RequestSpecification inputRequest=RestAssured.given().contentType(ContentType.JSON).body(new File(filePath));
			Response response=inputRequest.post();
			response.prettyPrint();
			response.then().assertThat().statusCode(201);
		}
			
		}
		
		catch(Exception e ) {
			
			e.printStackTrace();
		}
		
		
	}

}
