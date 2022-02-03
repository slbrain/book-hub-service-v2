package bookshub.demo;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGet {
	
	
	@Test
	public void test01() {
		RestAssured
				.given()
					.param("bookname", "Amazing Spider Man")
					.get("http://localhost:8091/api/v1/books")
				.then()
					.statusCode(200)
					.body("isbn", equalTo(2));
					
		
		
	}

}
