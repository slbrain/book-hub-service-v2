package bookshub.demo;

import org.testng.annotations.Test;

import bookshub.demo.dto.BookDto;
import io.restassured.RestAssured;

public class TestPost {
	
	
	@Test
	public void test01() {

		BookDto bk = new BookDto(5,"test");
		
		RestAssured.given()
						.contentType("application/json")
						.body(bk)
					.when()
						.post("http://localhost:8091/api/v1/books")
					.then()
						.statusCode(200);
			
				
		
		
	}

}
