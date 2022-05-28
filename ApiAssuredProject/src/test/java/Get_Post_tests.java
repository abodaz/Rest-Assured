import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Get_Post_tests {

	
	@Test
	public void post_test() {
		baseURI = "https://reqres.in/api";

		// create JSON object and add name and job to it
		JSONObject data = new JSONObject();
		data.put("name", "morpheus");
		data.put("job", "leader");

		// post a new user with name and job
		given().
			body(data.toJSONString()).
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		

		
	}
	
	@Test
	public void get_test() {
		
		baseURI = "https://reqres.in/api";
		
		// get users and check first name
		given().
			get("/users").
		then().
			statusCode(200).
			body("data[5].first_name", equalTo("Tracey")). 
			body("data.first_name", hasItems("Tracey","Eve")).
			log().all();
	}

}
