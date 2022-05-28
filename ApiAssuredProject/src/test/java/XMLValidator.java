import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLValidator {

	@Test
	public void jsonSchema() throws IOException {
		
		File file = new File("./SOAP/soap.xml");
		FileInputStream fileInput = new FileInputStream(file);
		String requestBody = org.apache.commons.io.IOUtils.toString(fileInput,"UTF-8");
		
		if(file.exists())
			System.out.println(">> File exists ");
		
		baseURI = "http://dneonline.com";
		
		RestAssured data = new RestAssured();
		
		given().
			contentType(ContentType.XML).
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/calculator.asmx").
		then().
			log().all();
		
	}
}
