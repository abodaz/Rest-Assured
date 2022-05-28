import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class Test01_Get {
	
	@Test
	void test_01() {
		Response response = get("https://gorest.co.in/public/v2/users");
		
		System.out.println(response.asString());
		System.out.println(response.getTime());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody());
	}
	
	@Test
	void test_02() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[0].id",equalTo(7)).
		log().all();
		
	}
}
