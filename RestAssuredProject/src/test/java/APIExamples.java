import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class APIExamples {

	// @Test
	public void test1_get() {

		baseURI= "http://localhost:3000/";

		//		given().
		//		    get("/users").then().statusCode(200)
		//		    .log().all();
		//		
		//to get subject with automation give the key and value
		given().param("Subjects", "Automation").
		get("/Subjects").then().statusCode(200)
		.log().all();
	}

	//@Test
	public void test_Post() {
		JSONObject request = new JSONObject();

		request.put("firstName", "Tom");
		request.put("LastName", "Cooper");
		request.put("SubjectId", 1);

		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when().
		post("/users")
		.then()
		.statusCode(201)
		.log().all();


	}

	//@Test
	public void test_Patch() {
		JSONObject request = new JSONObject();


		request.put("LastName", "sheppard");

		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when().
		post("/users/4")
		.then()
		.statusCode(201)
		.log().all();
	}

	//@Test
	public void test_Put() {
		JSONObject request = new JSONObject();


		request.put("LastName", "test");

		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when().
		put("/users/4")
		.then()
		.statusCode(201)
		.log().all();
	}
 
	//@Test
		public void test_delete() {
			when().delete("/users/4")
			.then().statusCode(200)
			.log().all();
		}
	

}
