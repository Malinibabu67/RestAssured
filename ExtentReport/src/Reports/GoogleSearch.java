package Reports;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("India");

		Thread.sleep(10000);

		/*List<WebElement> lists = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));

		System.out.println("the total number of variables :: " + lists.size());

		for (int i=0; i< lists.size(); i++) {
			String listitems = lists.get(i).getText();
			System.out.println(listitems);
			if (listitems.contains("testing synonym")) {
				lists.get(i).click();
				break;
			}

		}*/

		List<WebElement> suggestion = driver.findElements(By.className("sbtc"));
		for (WebElement suggest : suggestion) {
			System.out.println(suggest.getText());
			if (suggest.getText().equalsIgnoreCase("india news")) {
				suggest.click();
				break;
						
			}
			
		}
		System.out.println("Test Completed Successfully ");
	}


}



