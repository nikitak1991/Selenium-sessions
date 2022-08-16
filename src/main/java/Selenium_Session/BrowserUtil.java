package Selenium_Session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * this method is launching browser
	 * 
	 * @param brname
	 * @return
	 */
	public WebDriver launchBrowser(String brname) {

		if (brname.equalsIgnoreCase("chrome")) {
			System.out.println(brname + "is launching");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (brname.equalsIgnoreCase("firefox")) {
			System.out.println("Browser is launching");
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();

		} else if (brname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();

		} else {
			System.out.println("Please pass right browser ...");
		}
		return driver;
	}

	/**
	 * this method is launching web page
	 * 
	 * @param url
	 */
	public void getWebPage(String url) {
		if (url == null) {
			System.out.println("Please pass correct url,url is null");
			return;
		}
		if (url.length() == 0) {
			System.out.println("Please pass correct url,url is blank");
			return;
		}

		if (url.indexOf("https") == -1) {
			System.out.println("Please pass correct url");
			return;
		}
		if (url.indexOf("http") == -1) {
			System.out.println("Please pass correct url");
			return;
		}

		System.out.println("Page is launching");
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void titleCheck(String str) {
		String title = driver.getTitle();
		// System.out.println("Title is :"+title);
		if (title.contains(str)) {
			System.out.println("Title is correct");
		} else
			System.out.println("Title is not correct");
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void pageSourceCheck(String str) {
		// String title = getTitle();
		if (getPageSource().contains(str)) {
			System.out.println("Page source is correct");
		} else
			System.out.println("Page source is not correct");
	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}
}
