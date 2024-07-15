package steps;

import java.util.Map;

import java.util.Map.Entry;
import java.util.Random;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSteps {

	RequestSpecification request = null;
	Response response = null;
	public static String sys_id = null;
	public static String randomDesc = null;

	@Given("set the endpoint")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev231612.service-now.com/api/now/table/";

	}

	@And("add the auth")
	public void addAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "eJ70Jq$ERc+p");
	}

	@And("construct the request")
	public void constructRequest() {
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
	}

	@When("send the request")
	public void sendRequest() {

		response = request.get("incident/" + sys_id);

	}

	@Then("validate the response")
	public void validateTheResponse() {
		response.then().assertThat().statusCode(200).log().all();
	}

	@And("add the queryParams as {string} and {string}")
	public void setQueryParams(String key, String value) {
		request = RestAssured.given().log().all().queryParam(key, value).contentType(ContentType.JSON);
	}

	/*
	 * @And("add the queryParams as {string} and {string}") public void
	 * add_the_query_params_as_and(String s1, String s2) { request =
	 * RestAssured.given().contentType(ContentType.JSON).queryParam(s1,s2).log().all
	 * (); }
	 */

	@When("send the request with QP")
	public void sendRequestwithQP() {
		response = request.get("incident");
	}

	@And("add the queryParams")
	public void addQueryParams(DataTable dt) {
		/*
		 * Map<String,String> new_map=new HashedMap<String, String>();
		 * new_map.put("sysparm_fields", "sys_id,category");
		 * new_map.put("category","software");
		 */

		Map<String, String> map_values = dt.asMap();
		request = RestAssured.given().contentType(ContentType.JSON).queryParams(map_values).log().all();
	}

	@When("post the request as {string} and category as {string}")
	public void addBodyInPost(String short_desc, String category) {
		response = RestAssured.given().body("{\r\n" + "    \"short_description\": \"" + short_desc + "\",\r\n"
				+ "    \"category\": \"" + category + "\"\r\n" + "}").post("incident");
	}

	@When("post the request with short description as {string} and category as {string}")
	public void postRequest(String short_desc, String category) {
		response = RestAssured.given().contentType("application/json").accept("application/json")
				.body("{\r\n" + "    \"short_description\": \"" + short_desc + "\",\r\n" + "    \"Category\": \""
						+ category + "\"\r\n" + "}")
				.log().all().post("incident");

	}

	@When("post the request with category as {string}")
	public void postRequest(String category) {
		response = RestAssured.given().contentType("application/json").accept("applciation/json")
				.body("{\r\n" + "    \"category\": \"" + category + "\"\r\n" + "}").log().all().post("incident");

	}

	@When("send the postrequest")
	public void postRequest() {
		response = RestAssured.given().contentType("application/json").accept("application/json")
				.body("{\r\n" + "    \"short_description\": \"This is created by Rest Assured\",\r\n"
						+ "    \"category\": \"software\"\r\n" + "}")
				.log().all().post("incident");
	}

	@When("validate the response for task_effective_number")
	public void validateResponseWithTaskEffectiveNumber() {
		response.then().assertThat().body("result.task_effective_number", Matchers.equalTo("result.number"));
	}

	@Then("validate the response as {int}")
	public void validateResponse(int statusCode) {
		int statuscode = response.getStatusCode();
		String statusline = response.statusLine();
		response.then().assertThat().statusLine(statusline);
		response.then().assertThat().statusCode(statuscode);
	}

	@Then("validate the response for {string} and {string} and {string}")
	public void validate_the_response_for_and_and(String value, String short_desc, String category) {
		response.then().assertThat().statusCode(201);
		if (value.equals("1")) {
			response.then().assertThat().body("result.category", Matchers.equalTo("inquiry"));
		} else if (value.equals("2")) {
			response.then().assertThat().body("result.category", Matchers.not(Matchers.equalTo("software")));
		} else if (value.equals("3")) {
			response.then().assertThat().body("result.category", Matchers.equalTo("inquiry"));
		} else {
			response.then().assertThat().body("result.short_description", Matchers.notNullValue());
		}

	}

	// validating response using data table

	@Then("validate the response for below")
	public void validate_the_response_for_below(DataTable dTable) {
		// converting dataTable as a Map entry for <K,V> pair
		Map<String, String> mapValues = dTable.asMap();
		// Entry is a collection view of Map. Converting entire Map above to each
		// entrySet
		for (Entry<String, String> eachEntry : mapValues.entrySet()) {
			response.then().body(eachEntry.getKey(), Matchers.containsString(eachEntry.getValue()));
		}
		response.then().assertThat().statusCode(201).and().body("result.task_effective_number", Matchers.hasLength(10));
	}

	public void validateResponseStringForMulti(DataTable dt) {
		Map<String, String> asMap = dt.asMap();
		for (Entry<String, String> eachEntry : asMap.entrySet()) {
			response.then().body(eachEntry.getKey(), equalTo(eachEntry.getValue()));
		}
	}

	@Given("send the post request")
	public void send_the_post_request() {
		request.given().body("{\r\n" + "    \"short_description\": \"Cucumber Tags Request incident creation\",\r\n"
				+ "    \"description\": \"Tags incident creation for cucumber assignment 2.\"\r\n" + "}");
		response = request.post("incident");
	}

//	@Then("validate the response for below")
//	public void validateResposeStringForMulti(DataTable dt) {
//		Map<String, String> asMap = dt.asMap();
//		for (Entry<String, String> eachEntry : asMap.entrySet()) {
//
//			response.then().body(eachEntry.getKey(), Matchers.equalTo(eachEntry.getValue()));
//
//		}
//
//	}

	// Code for Change request table
	@When("send the post request for crTable")
	public void send_the_request_for_crTable() {
		request.given().body("{\r\n" + "    \"short_description\": \"This short descp for chg req table\",\r\n"
				+ "    \"description\": \"Description given for chg req table.\"\r\n" + "}");
		response = request.post("change_request");
	}

	@Given("send the get request for all CR")
	public void send_the_get_request_for_all_change_Requests() {
		response = request.get("change_request");
	}

	// code for change req table
	@Then("validate the response for crTable")
	public void validate_the_response_for_crTable() {
		response.then().assertThat().statusCode(201).log().all();
	}

	// send get request
	@Given("send the get request")
	public void send_the_get_request() {
		response = request.get("incident/" + sys_id);

	}

	@Given("send the get request for crTable")
	public void send_get_request_CR() {
		response = request.get("change_request");
	}

	@Given("send the get request for all crTable")
	public void send_get_request_allCR() {
		response = request.get("change_request");
	}

	// validate get request
	@Then("validate the response for get")
	public void validate_the_response_for_get() {
		response.then().assertThat().statusCode(200).log().all();
	}

	@Then("validate the response for post")
	public void validate_the_response_for_post() {
		sys_id = response.jsonPath().get("result.sys_id");
		response.then().assertThat().statusCode(201).log().all();
	}

	@Given("send the get request for all incidents")
	public void send_the_get_request_for_all_incidents() {
		response = request.get("incident");
	}

	@Then("validate the response for getAll")
	public void validate_the_response_for_get_all() {
		response.then().assertThat().statusCode(200).log().all();
	}

	@Then("validate the response for random_sys_id and response as {int}")
	public void validate_the_response_for_random_sys_id(int code) {

		int count = response.jsonPath().get("result.size()");
		System.out.println("Count of the CR " + count);
		// Generating random number

		// Create a new instance of the Random class
		Random random = new Random();

		// Generate a random number between 0 and count-1
		int randomNumber = random.nextInt(count);
		sys_id = response.jsonPath().get("result[" + randomNumber + "].sys_id");

		System.out.println(" sys_id is " + sys_id);
		int statuscode = response.getStatusCode();
		response.then().assertThat().statusCode(statuscode).log().all();

	}

	@Given("send the put request")
	public void send_the_put_request() {
		request.given().body("{\r\n" + "    \"short_description\": \"Put update on Cucumber tags request.\"\r\n" + "}");
		response = request.put("incident/" + sys_id);
	}

	@Given("send the put for crTable")
	public void send_the_put_request_CR() {
		request.given().body("{\r\n" + "    \"short_description\": \"Put update on Cucumber tags request.\"\r\n" + "}");
		response = request.put("change_request/" + sys_id);
	}

	@Then("validate the response for put")
	public void validate_the_response_for_put() {
		response.then().assertThat().statusCode(200).log().all();
	}

	@Given("send the delete request")
	public void send_the_delete_request() {
		response = request.delete("incident/" + sys_id);
	}

	@Given("send the delete for crTable")
	public void send_delete_request_CR() {
		response = request.delete("change_request/" + sys_id);
	}

	@Then("validate the response for delete")
	public void validate_the_response_for_delete() {
		response.then().assertThat().statusCode(204).log().all();
	}

}
