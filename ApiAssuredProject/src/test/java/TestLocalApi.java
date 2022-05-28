import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class TestLocalApi {

	@Test
	public void get_test() {
		baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void post_test() {
		JSONObject data = new JSONObject();
		data.put("id", 9);
		data.put("first_name", "abdallah");
		data.put("last_name", "azzami");
		data.put("subjectId", "2");
		
		baseURI = "http://localhost:3000";
				
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(data.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
	
	@Test
	public void put_test() {
		JSONObject data = new JSONObject();
		data.put("first_name", "mike");
		data.put("last_name", "max");
		data.put("subjectId", "2");
		
		baseURI = "http://localhost:3000";
				
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(data.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void patch_test() {
		JSONObject data = new JSONObject();
		data.put("subjectId", "1");
		
		baseURI = "http://localhost:3000";
				
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(data.toJSONString()).
		when().
			patch("/users/8").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void delete_test() {
		baseURI = "http://localhost:3000";
				
		
		given().
			delete("/users/9").
		then().
			statusCode(200).
			log().all();
		
	}
}
