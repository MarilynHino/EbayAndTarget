package ebay.com;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iphone {

	public static void ebayPurchase() throws IOException {

		// System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver ebayDriver = new ChromeDriver();

		// For maximizing the browser
		ebayDriver.manage().window().maximize();
		ebayDriver.get("https://ebay.com");
		ebayDriver.findElement(By.id("gh-ac")).sendKeys("iphone");
		ebayDriver.findElement(By.xpath("//*[@id='gh-btn']")).click();

		// count of products in page 1
		java.util.List<WebElement> productList = ebayDriver.findElements(By.cssSelector("li.s-item"));

		// Creating a new file or copying to existing file
		File file = new File("C:\\Users\\benha\\eclipse-workspace\\Selenium-Ebay\\ebay.txt");
		PrintStream stream = new PrintStream(file);

		for (int i = 1; i < productList.size(); i++) {
			WebElement productTitle = ebayDriver
					.findElement(By.xpath("//*[@id='srp-river-results']/ul/li[" + i + "]/div/div[2]/a/h3"));
			WebElement productPrice = ebayDriver.findElement(
					By.xpath("//*[@id='srp-river-results']/ul/li[" + i + "]/div/div[2]//span[@class='s-item__price']"));

			System.setOut(stream);
			System.out.println(
					i + ".Product title: " + productTitle.getText() + "Product Price: \n" + productPrice.getText());
		}

		// close the browser
		ebayDriver.close();
	}

}
