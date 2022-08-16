package Selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Get_text_attribute {

	public static void main(String[] args) {
		
	BrowserUtil brws = new BrowserUtil();
	WebDriver driver =brws.launchBrowser("chrome");
	brws.getWebPage("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	
	ElementUtil ele = new ElementUtil(driver);
	
	//First Name
	By fstname = By.xpath("//*[@id=\"account\"]/div[2]/label");
	By fstinput = By.id("input-firstname");
		
	String eletext = ele.doGetElementText(fstname);
	if(eletext.equalsIgnoreCase("First Name")) {
		System.out.println("Pass : first name label is correct");
	}else {
			System.out.println("label is not correct");
		}
	
	 String placevalue = ele.doGetAttributeValue(fstinput,"placeholder");
	  if(placevalue.equalsIgnoreCase("First NAME")) {
		  System.out.println("First name Place holder is correct :" +placevalue);
	  }else {
		  System.out.println("Place holder is incorrect");
	  }
	
	  //Last name
	 By lnamelabel = By.xpath("//*[@id=\"account\"]/div[3]/label");
	 By lastnamebox = By.id("input-lastname"); //*[@id="account"]/div[3]
	 
	 
	 String lnametext = ele.doGetElementText(lnamelabel);
		if(lnametext.equalsIgnoreCase("Last name")) {
			System.out.println(" last name label is correct :" +lnametext);
		}else {
				System.out.println("label is not correct");
		}
		
		 String lnameplaceholder = ele.doGetAttributeValue(lastnamebox,"placeholder");
		  if(placevalue.equalsIgnoreCase("First NAME")) {
			  System.out.println("Place holder is correct :" +lnameplaceholder);
		  }else {
			  System.out.println("Place holder is incorrect");
		  }
		  
		  ele.doSendKeys(lastnamebox, "kapoor");
	
		  
		  //login link
		 By loginlink = By.linkText("Login"); 
		 ele.doClick(loginlink);
		// ele.doGetElementText(loginlink);
		  System.out.println( ele.doGetElementText(loginlink));
		  System.out.println(ele.doGetAttributeValue(loginlink, "href"));
	}
}

