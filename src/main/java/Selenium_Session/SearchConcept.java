package Selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchConcept {

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brws = new BrowserUtil();
		WebDriver driver = brws.launchBrowser("chrome");
		/*
		 * brws.getWebPage("https://www.google.com/");
		 * 
		 * ElementUtil ele = new ElementUtil(driver);
		 * 
		 * By searchkeylocator = By.name("q"); By suggestionlistlocator =
		 * By.xpath("//div[@class='wM6W7d']");
		 * 
		 * ele.seacrchList(searchkeylocator, "Navven automation lab",
		 * suggestionlistlocator);
		 * 
		 * By footerlocator = By.xpath("//div[@class='KxwPGc SSwjIe']/div");
		 * ele.doGetElementsTextList(footerlocator);
		 */

		brws.getWebPage("https://www.amazon.com/");

		ElementUtil ele = new ElementUtil(driver);

		By searchkeylocator = By.id("twotabsearchtextbox");
		By suggestionlistlocator = By
				.xpath("//div[@class='autocomplete-results-container']//div[@class='s-suggestion-container']");

		ele.seacrchList(searchkeylocator, "Iphone", suggestionlistlocator);

		By list = By.xpath("//div[@id='nav-xshop']/a");

		ele.doGetElementsTextList(list);

	}

}