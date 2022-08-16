package Selenium_Session;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElements {

	public static void main(String[] args) {
		
		BrowserUtil brws = new BrowserUtil();
		WebDriver driver =brws.launchBrowser("chrome");
		brws.getWebPage("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By inputlist = By.tagName("input");
		By linklinst = By.tagName("a");
		
		ElementUtil ele = new ElementUtil(driver);
		
		int totalinputfield =ele.getPageElementCount(inputlist);
		System.out.println("Total input field in registration page is :"+totalinputfield);
		
		List<String> textlist = ele.doGetElementsTextList(linklinst);
		System.out.println(textlist);
		
		List<String> attrlist = ele.GetAttrivuteList(inputlist, "placeholder");
		System.out.println(attrlist);
	    

}
}
