package Selenium_Session;

public class AmazonTest {
  
	 
	 
	public static void main(String[] args) {
		 BrowserUtil brwsutil = new BrowserUtil();
		 brwsutil.launchBrowser("chrome");
		 brwsutil.getWebPage("www.amazon.com");
		 brwsutil.titleCheck("Amazon");
		 brwsutil.quit();
		 

	}

}
