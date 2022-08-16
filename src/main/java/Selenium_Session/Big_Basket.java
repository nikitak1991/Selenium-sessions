package Selenium_Session;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Big_Basket {

	static WebDriver driver;
	// static Actions act;

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil browser = new BrowserUtil();
		driver = browser.launchBrowser("chrome");
		browser.getWebPage("https://www.bigbasket.com/");

		ElementUtil eleutil = new ElementUtil(driver);

		By shopbycategory = By.xpath("//a[@class='dropdown-toggle meganav-shop']");
		By firstlist = By
				.xpath("(//ul[@class='nav nav-tabs nav-stacked col-md-3 bdr-viewall' and @id='navBarMegaNav']/li)");
		By secondlist = By
				.xpath("(//div[@class=\"col-md-3 pad-rt-0 desgn-fix\"])[2]/ul[@class='nav nav-pills nav-stacked']//li");
		By thirdList = By.xpath(
				"(//div[@class=\"col-md-4 col-sm-6 col-xs-12 pad-0 change-wid\"])[2]//ul[@class='list-unstyled']/li");

		useActionClass(eleutil.getElement(shopbycategory));
		Thread.sleep(2000);
		List<WebElement> firstlistelement = driver.findElements(firstlist);

		for (WebElement e : firstlistelement) {
			useActionClass(e);
			System.out.println("-----------" + e.getText() + "---------");
			Thread.sleep(1000);

			useActionClass(driver.findElement(secondlist));
			Thread.sleep(2000);
			List<WebElement> secondlistElements = driver.findElements(secondlist);
			for (WebElement e1 : secondlistElements) {
				useActionClass(e1);
				System.out.println("--Sub list of :" + e1.getText() + "--");
				Thread.sleep(1000);

				useActionClass(driver.findElement(thirdList));
				Thread.sleep(1000);
				List<WebElement> thirdlistElements = driver.findElements(thirdList);
				for (WebElement e2 : thirdlistElements) {
					useActionClass(e2);
					System.out.println("*" + e2.getText());

				}

			}
		}

	}

	public static void useActionClass(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

}
