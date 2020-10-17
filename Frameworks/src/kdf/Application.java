package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilis.GenericMethods;

public class Application {

	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("C:\\Users\\Malini\\Desktop\\Selenium\\TestData\\Testdata_sample.xlsx", "Sheet2");
		Methods mtd = new Methods();
		for (int i=1;i<data.length;i++) {
			switch (data [i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maxBrowserWindow();
				break;
			case "impwait":
				mtd.implicitwait();
				break;
			case "navigateToApplication":
				mtd.navigateToApplicationURL(data[i][6]);
				break;
			case "enterUserID":
				mtd.enterUserId(data [i][5], data[i][6]);
				break;
			case "enterPassword":
				mtd.enterpassword(data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				mtd.clickbutton(data[i][4], data[i][5]);
				break;
			case "verifyErrorMsg":
				String actualMsg = mtd.verifyerrormsg(data[i][4], data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApp":
				mtd.closeBrowser();
				break;

			}


		}

	}
}
