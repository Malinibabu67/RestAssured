	
		import static io.restassured.RestAssured.*;
		import org.json.simple.JSONObject;
		import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

		public class DataDrivenParameter { 
			
			@Parameters({"firstname","lastname","id"})
			@Test
			public void test_Post(String firstname, String lastName, int id) {
				JSONObject request = new JSONObject();

				request.put("firstName", firstname);
				request.put("LastName", lastName );
				request.put("SubjectId", id);

				given()
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString())
				.when().
				post("/users")
				.then()
				.statusCode(201)
				.log().all();
			}
		 @Parameters({"userid"})
			@Test
			public void test_delete(int userid) {
				
				when().
				    delete("/users/" + userid)
				.then()
				    .statusCode(200);
			}
				    
		}
