package Test.API;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test1_CRUD {

	@Test
	public void test01_post() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Popo Darmawan");
		request.put("email", "PopoGaming@axiata12.com");
		request.put("gender", "male");
		request.put("status", "inactive");
		
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
		.auth()
		.preemptive()
		.oauth2("0a12d8b1a8b7c585f0a4a668efa0bb7ca6b0297a0d1ed291e41a933d3dc2bfe8")
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	public void test02_update() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Popo Darmawan");
		request.put("email", "PopoGaming@axiata12.com");
		request.put("gender", "male");
		request.put("status", "inactive");
		
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
		.auth()
		.preemptive()
		.oauth2("0a12d8b1a8b7c585f0a4a668efa0bb7ca6b0297a0d1ed291e41a933d3dc2bfe8")
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("https://gorest.co.in/public/v2/users/4801")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test03_update() {
		
		JSONObject request = new JSONObject();
		
		request.put("gender", "female");
		request.put("status", "active");
		
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
		.auth()
		.preemptive()
		.oauth2("0a12d8b1a8b7c585f0a4a668efa0bb7ca6b0297a0d1ed291e41a933d3dc2bfe8")
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("https://gorest.co.in/public/v2/users/4801")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test04_delete() {
		
		given()
		.auth()
		.preemptive()
		.oauth2("0a12d8b1a8b7c585f0a4a668efa0bb7ca6b0297a0d1ed291e41a933d3dc2bfe8")
		.when()
		.delete("https://gorest.co.in/public/v2/users/4801")
		.then()
		.statusCode(204)
		.log().all();
	}
}
