import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Tests_POST {
	@Test
	public void test_1_post() {
		// option 1 with map

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "Raghav");
		//map.put("\"name\"","Raghav");
		map.put("job", "Teacher");
		System.out.println(map);	

		//Add simple json libraries from maven and pass map to JSONObject
		JSONObject request = new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());
		given().body(request.toJSONString()).
		when().post("https://reqres.in/api/users").
		then().statusCode(200);

	}

	@Test
	public void test_2_post() {


		//Add simple json libraries from maven and put values directly in JSONobject.

		JSONObject request1 = new JSONObject();
		request1.put("name", "Raghav");
		request1.put("job", "Teacher");
		System.out.println(request1);
		System.out.println(request1.toJSONString());
		
		given().
		    header("content-Type", "application/JSON").
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).
		    body(request1.toJSONString()).
		when().
		     post("https://reqres.in/api/users").
		then().
		     statusCode(201);
	}
}
