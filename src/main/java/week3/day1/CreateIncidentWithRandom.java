package week3.day1;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentWithRandom {
	
	@Test
	public void createIncidentWithRandom() {
		
		/*
		 * Using the Random class, we generate a random index within the range of the characters string length.
		 * We retrieve the character at the random index from the characters string. 
		 * We append the random character to the StringBuilder.
		 * Repeat steps 3-5 until the desired length of the random data is achieved.
		 * Finally, we convert the StringBuilder to a string and print the generated
		 * random data.
		 */
		String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
		StringBuilder sb=new StringBuilder();//create a StringBuilder to build the random data character by character.
		Random random=new Random();
		int length=10;
		for(int i=0;i<length;i++) {
			int index=random.nextInt(characters.length());
			char randomchar=characters.charAt(index);
			sb.append(randomchar);
		}
		//convert the StringBuilder to a string and print the generated random data.
		String randomData = sb.toString();
        System.out.println("Random Data: " + randomData);
        
        RestAssured.baseURI="https://dev231612.service-now.com/api/now/table/incident";
        RestAssured.authentication=RestAssured.basic("admin", "eJ70Jq$ERc+p");
        
        RequestSpecification inputRequest=RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
        		+ "    \"description\": \"My first test with Rest Assured "+randomData+"\",\r\n"
        		+ "    \"short_description\": \"Success\"\r\n"
        		+ "}");
        Response response=inputRequest.post();
        response.prettyPrint();
        response.then().assertThat().body("result.number", Matchers.containsString("INC"));
	}


}
