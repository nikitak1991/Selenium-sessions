package Selenium_Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Strings;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		By likendinlocator = By.cssSelector("img[alt='LinkedIn OrangeHRM group']");
		By facebklocator = By.cssSelector("img[alt='OrangeHRM on Facebook']");
		By Tiwwterlocator = By.cssSelector("img[alt='OrangeHRM on twitter']");
		By youtubelocator = By.cssSelector("img[alt='OrangeHRM on youtube']");

		driver.findElement(likendinlocator).click();
		driver.findElement(facebklocator).click();
		driver.findElement(Tiwwterlocator).click();
		driver.findElement(youtubelocator).click();

		Set<String> set = driver.getWindowHandles();
		
		
		//Using Iterator
		Iterator<String> it = set.iterator();
		/*
		String Parentwindow =it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(Parentwindow);
		*/
		
		//using concept of converting set to list
		/*
		 List<String> windowlist = new ArrayList<String>(set);
		String Parentwindow =windowlist.get(0);
		String childwindow =windowlist.get(1);
		
		*driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(Parentwindow);
		*/
		

		//when morethan one child window
		
		String parentwindow = it.next();
		while(it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			System.out.println(driver.getTitle());
			driver.close();
		}
		
		driver.switchTo().window(parentwindow);
		System.out.println(driver.getTitle());
		
	}

}
