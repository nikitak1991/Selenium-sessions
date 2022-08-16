package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Selenium_Session.ElementUtil;

public class RegistrationPage extends BaseTest{
	
	ElementUtil eleutil = new ElementUtil(driver);
	
	@Test
	public void doRegistration(String firstname, String lastname, String emailid, String phoneno, String password) {
		
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By pass = By.id("input-password");
		By checkbox =By.xpath("//div[text()='I have read and agree to the ']//input[@type='checkbox']");
		
		eleutil.doSendKeys(fname, firstname);
		eleutil.doSendKeys(lname, lastname);
		eleutil.doSendKeys(email, emailid);
		eleutil.doSendKeys(phone, phoneno);
		eleutil.doSendKeys(pass, password);
		eleutil.doClick(checkbox);
		
	
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
