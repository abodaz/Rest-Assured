import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Put_Patch_Delete_tests {

	@Test
	public void put() {
		
		JSONObject data = new JSONObject();
		data.put("name", "morpheus");
		data.put("job", "zion resident");
		
		baseURI = "https://reqres.in";
		
		given().
			body(data.toJSONString()).
			contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
			put("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void patch() {
		
		JSONObject data = new JSONObject();
		data.put("name", "morpheus");
		data.put("job", "zion resident");
		
		baseURI = "https://reqres.in";
		
		given().
			body(data.toJSONString()).
			contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void delete() {
		
		baseURI = "https://reqres.in";
		
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
