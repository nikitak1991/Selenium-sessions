package Selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_Concept {

	public static void main(String[] args) {
		
		
		BrowserUtil brwsutil = new BrowserUtil();
		WebDriver driver= brwsutil.launchBrowser("chrome");
		 brwsutil.getWebPage("https://www.amazon.com/");
		 
		 ElementUtil ele = new ElementUtil(driver);
		 By locator = By.xpath("((//div[@class='navFooterVerticalRow navAccessibility']/div//ul)[3]/li)[1]");
		String text = ele.doGetElementText(locator);
		 System.out.println(text);
		 
		/*WebElement text= driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[1]"));
		System.out.println(text.getText());*/
		//*[@id="navFooter"]/div[1]/div/div[1]/ul/li[1]
	}

}
