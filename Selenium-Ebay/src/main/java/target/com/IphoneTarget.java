package target.com;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneTarget {

	public static void targetPurchase() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver targetDriver = new ChromeDriver();

		// For maximizing the browser
		targetDriver.manage().window().maximize();
		targetDriver.get("https://Target.com");
		targetDriver.findElement(By.id("search")).sendKeys("iphone");
		targetDriver.findElement(By.cssSelector("button.SearchInputButton-sc-1opoijs-0.eOzuAz")).click();

		// count of products in page 1
		java.util.List<WebElement> no_of_items = targetDriver
				.findElements(By.cssSelector("//div[@data-test='product-list-container']//li"));

		// Creating a new file or copying to existing file
		File file = new File("C:\\Users\\benha\\eclipse-workspace\\Selenium-Ebay\\target.txt");
		PrintStream stream = new PrintStream(file);

		for (int i = 1; i < no_of_items.size(); i++) {
			WebElement productTitle = targetDriver.findElement(By
					.xpath("//div[@data-test='product-list-container']//li[" + i + "]//a[@data-test='product-title']"));
			WebElement productPrice = targetDriver.findElement(By.xpath(
					"//div[@data-test='product-list-container']//li[" + i + "]//div[@data-test='current-price']"));

			System.setOut(stream);
			System.out.println(
					i + ".Product title: " + productTitle.getText() + "Product Price: \n" + productPrice.getText());
		}

		// close the browser
		targetDriver.close();
	}

}
