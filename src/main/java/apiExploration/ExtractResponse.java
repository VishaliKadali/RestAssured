package apiExploration;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ExtractResponse {
   @Test 
   public void extractResponseFromFile(){

    RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/incident";

    // Construct the request (params, auth etc)
    RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");

    //Map<String, String> queryMap = new HashMap<String, String>();
//Need a simple java code to create a json file in src/main/resources



   }
}
