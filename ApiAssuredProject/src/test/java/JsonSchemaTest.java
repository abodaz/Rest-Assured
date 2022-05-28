import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaTest {

	@Test
	public void jsonSchema() {
		
		baseURI = "https://reqres.in/";
		
		RestAssured data = new RestAssured();
		
		given().
			get("api/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).
			log().all();
		
	}
}
