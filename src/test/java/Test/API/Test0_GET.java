package Test.API;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test0_GET {

String endpoint = "https://gorest.co.in/public/v1/users";
	
	@Test
	public void test_01() {
		
		Response response = RestAssured.get(endpoint);
//		System.out.println(response.asString());
		response.getBody().asString();
		response.getStatusCode();
		response.getStatusLine();
		response.getHeader("content-type");
		response.getTime();
		
		int statusCode = response.getStatusCode();
		
		assertEquals(statusCode, 200);
	}
	
//	@Test
//	public void test_02() {
//		
//		given()
//		.get(endpoint)
//		.then()
//		.statusCode(200)
//		.body("data.id[0]", equalTo(1));
//	}
}
