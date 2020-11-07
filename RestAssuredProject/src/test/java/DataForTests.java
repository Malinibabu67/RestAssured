import org.testng.annotations.DataProvider;

public class DataForTests {


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
	@DataProvider(name = "DeleteData")
	public Object[] dataForDelete() {

		return new Object[] {
				4,5,6,7
		};
	}
}
