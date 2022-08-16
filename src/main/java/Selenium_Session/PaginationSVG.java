package Selenium_Session;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginationSVG {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// browser util
		BrowserUtil browser = new BrowserUtil();
		driver = browser.launchBrowser("chrome");
		browser.getWebPage("https://selectorshub.com/xpath-practice-page/");

		By countryname = By.xpath("//td[text()='Canada'  or text() ='India']");
		//By checkbox = By.xpath("//td[text()='Russia']/preceding-sibling::td/input[@type=\"checkbox\"]");
		By next = By.linkText("Next");

		Thread.sleep(2000);
		while (true) {
			if (driver.findElements(countryname).size() > 0) {

				selectMultipleCheckbox("Canada","India");
				//break;
			}  if (driver.findElement(next).getAttribute("class").contains("disabled")) {

				System.out.println("Pagination is over..country is not available");
				break;
			}

			driver.findElement(next).click();
		}

	}

	// one selection
	public static void selectCity(String cityname) {
		WebElement checkbox = driver.findElement(
				By.xpath("//td[text()='" + cityname + "']/preceding-sibling::td/input[@type=\"checkbox\"]"));
		checkbox.click();
	}

	public static void selectMultipleCheckbox(String cityname1, String cityname2) {
		List<WebElement> checkbox = driver.findElements(
				By.xpath("//td[text()='"+cityname1+"'  or text() ='"+cityname2+"']/preceding-sibling::td/input[@type=\"checkbox\"]"));
		
		for(WebElement e: checkbox) {
			e.click();
			
		}
		
	}
}
