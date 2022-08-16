package Selenium_Session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver_basics {
	
	
	

	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver", "/users/../dowloads/chromedriver");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		String title = driver.getTitle();
		//System.out.println(title);
		
		if(title.contains("Register Account")) {
			System.out.println("Correct Title of page is :" +title);
		}else {
			System.out.println("Fail");
		}
		driver.quit();

	}

}
