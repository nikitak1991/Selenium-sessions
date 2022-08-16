package Selenium_Session;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public WebElement getElementWithString(String locator, String locatorstring) {
		switch(locator.toLowerCase().trim()){
		case "xpath":
			return driver.findElement(By.xpath(locatorstring));
		case "css":
			return driver.findElement(By.cssSelector(locatorstring));
		case "id":
			return driver.findElement(By.id(locatorstring));
		case "tagname":
			return driver.findElement(By.tagName(locatorstring));
		case "linktext":
			return driver.findElement(By.linkText(locatorstring));
		}
		return null;
		
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doSendKeyswithString(String locator, String locatorstring ,String value) {
		getElementWithString(locator,locatorstring).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doClickwithString(String locator, String locatorstring ) {
		getElementWithString(locator,locatorstring).click();;
	}

	public String doGetElementText(By locator) {
		String eletext = getElement(locator).getText();
		System.out.println("Element text is : " + eletext);
		return eletext;
	}

	/**
	 * this method will return count of total links
	 */
	public int getPageElementCount(By locator) {
		int totalcount = getElements(locator).size();
		System.out.println("Elemnt total count is :" + totalcount);
		return totalcount;
	}

	/**
	 * this method will return list of NOn blank text
	 */
	public List<String> doGetElementsTextList(By locator) {
		List<WebElement> completelist = getElements(locator);
		List<String> textlist = new ArrayList<String>();
		for (WebElement e : completelist) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(text);
				textlist.add(text);
			}
		}
		return textlist;
	}

	/**
	 * this method will return count of NOn blank text list
	 * 
	 * @return
	 */
	public int getElementsTextCount(By locator) {
		return doGetElementsTextList(locator).size();
	}

	/**
	 * this method will return count of blank text list
	 */
	public int getBlankLIstCount(By locator) {
		int count = getPageElementCount(locator) - getElementsTextCount(locator);
		return count;
	}

	public List<String> GetAttrivuteList(By locator, String attr) {
		List<WebElement> elelist = getElements(locator);
		List<String> attrvallist = new ArrayList<String>();
		for (WebElement e : elelist) {
			String attval = e.getAttribute(attr);
			attrvallist.add(attval);
		}
		return attrvallist;
	}

	public String doGetAttributeValue(By locator, String attrivaue) {
		String attrvalue = getElement(locator).getAttribute(attrivaue);
		// System.out.println("Attribute value of elementt is : "+attrvalue);
		return attrvalue;
	}

	public void seacrchList(By locator, String searchkey, By suggtnlist) throws InterruptedException {
		doSendKeys(locator, searchkey);
		Thread.sleep(3000);
		List<WebElement> suggestionlist = getElements(suggtnlist);

		for (WebElement e : suggestionlist) {
			String text = e.getText();
			System.out.println(text);
		}

	}
	

	public void relativeLocatorClick(String tagname,By baseelelocator, String direction) {
		WebElement baseele = getElement(baseelelocator);
		switch (direction.toLowerCase().trim()) {
		case "left":
			driver.findElement(with(By.tagName(tagname)).toLeftOf(baseele)).click();
			break;
		case "right":
			driver.findElement(with(By.tagName(tagname)).toRightOf(baseele)).click();
			break;
		case "above":
			driver.findElement(with(By.tagName(tagname)).above(baseele)).click();
			break;
		case "below":
			driver.findElement(with(By.tagName(tagname)).below(baseele)).click();
			break;
		case"near":
			driver.findElement(with(By.tagName(tagname)).near(baseele)).click();
			break;
		default:
			break;
		}
		
		}
	


}
