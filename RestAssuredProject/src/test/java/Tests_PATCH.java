

	
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
	

	public class Tests_PATCH {

		@Test
		public void test_1_patch() {


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
			     patch("https://reqres.in/api/users/2").
			then().
			     statusCode(200).
			 log().all();
		}
	

}



