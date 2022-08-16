package Selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

	public static void main(String[] args) {
		/**
		 * this is creating object of browser utility class and launching browser and
		 * page
		 */
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("Chrome");
		br.getWebPage("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println("Title of page is :" + br.getTitle());

		By fstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By pass = By.id("input-password");
		By cnfmpass = By.id("input-confirm");

		/**
		 * this is creating object of element utility class giving webelement to perform
		 * desire actions
		 */
		ElementUtil ele = new ElementUtil(driver);
		ele.doSendKeys(fstname, "nikita");
		ele.doSendKeys(lastname, "kapoor");
		ele.doSendKeys(email, "niktest@gmail.com");
		ele.doSendKeys(phone, "987654321");
		ele.doSendKeys(pass, "nik@123");
		ele.doSendKeys(cnfmpass, "nik@123");

		br.close();

	}

}
