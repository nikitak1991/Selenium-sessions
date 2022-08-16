package Selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class CRMPRO {

	public static void main(String[] args) throws InterruptedException {

		// browser util
		BrowserUtil browser = new BrowserUtil();
		WebDriver driver = browser.launchBrowser("chrome");
		browser.getWebPage("https://classic.crmpro.com/index.html");

		// Element util
		ElementUtil eleutil = new ElementUtil(driver);

		By useranme = By.xpath("//input[@type='text']");
		By password = By.xpath("//input[@type='password']");
		By submit = By.xpath("//input[@type='submit']");

		eleutil.doSendKeys(useranme, "nikitak91");
		eleutil.doSendKeys(password, "password@123");
		eleutil.doClick(submit);

		Thread.sleep(2000);

		By frame1 = By.xpath("//frame[@name='mainpanel']");
		By contact = By.xpath("//div//li/a[@title='Contacts']");
		

		// Switching to frame
		driver.switchTo().frame(eleutil.getElement(frame1));

		// creating action class
		Actions act = new Actions(driver);
		act.moveToElement(eleutil.getElement(contact)).perform();
		eleutil.doClickwithString("xpath", "//div[@id='navmenu']//li/a[@title='New Contact']");

		// fill form
		By savebutton = By.xpath("//form[@id='contactForm']//tr/td//input[@value='Save']");
		By image = By.cssSelector("form#contactForm tr td #image_file");
		By title =By.xpath("//select[@name='title']");
		
		
		Select select = new Select(eleutil.getElement(title));
		select.selectByVisibleText("Mr.");

		eleutil.doSendKeyswithString("css","input#first_name", "Mayank5");
		eleutil.doSendKeyswithString("css","input#phone", "9876543212");
		eleutil.doSendKeyswithString("css","input#surname", "kapoor");
		eleutil.doSendKeyswithString("css","input#email", "mayank2@gmail.com");
		eleutil.doSendKeys(image,"C:\\Users\\Nikita Kapoor\\Desktop\\A-Z-Phonics-Poster-1-1-scaled.jpg");
		
		eleutil.doClick(savebutton);
		eleutil.doClick(contact);

		// Web Table
		By tablecheckbox = By.xpath("//a[@_name='Myra1 kapoor']/parent::td/preceding-sibling::td");
		//eleutil.doClick(tablecheckbox); // using xpath sibling concept

		// Using Relative locator concept
		By baseelelocator = By.xpath("//a[@_name='Myra1 kapoor']/..");
		eleutil.relativeLocatorClick("td", baseelelocator, "left");
		
	}

	

	
	

}
