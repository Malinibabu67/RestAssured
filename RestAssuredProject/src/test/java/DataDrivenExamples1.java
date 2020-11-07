import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples1 {
	
	@DataProvider(name = "Test for post")
	 public Object[][] dataForPost() {
//		Object[][] data = new Object[2][3]; //how many rows and columns
//		data [0][1] = "malini";
//		data [0][2] = "Babu";
//		data [0][3] = 4;
//		return data;
		
		return new Object[][] {
			{"Garha","tets",1},
			{"TEST1","TEST2",1}
		};
	}
	
	@Test(dataProvider= "Test for post")
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
   @DataProvider(name = "DeleteData")
	public Object[] dataForDelete() {
		
		return new Object[] {
				4,5,6,7
		};
	}
	@Test(dataProvider = "DeleteData")
	public void test_delete(int userid) {
		
		when().
		    delete("/users/" + userid)
		.then()
		    .statusCode(200);
	}
		    
}
