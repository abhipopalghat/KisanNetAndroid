package com.kisan.kisannet.helper.genericHelper;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Reporter;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class GenericHelper{
	
	private AndroidDriver driver;
	//private Logger Log = LoggerHelper.getLogger(WaitHelper.class);
	private static final Logger log = LoggerHelper.getLogger(GenericHelper.class);
	WaitHelper waitHelper;
	
	public GenericHelper(AndroidDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		log.debug("WaitHelper : " + this.driver.hashCode());
		
	}

	
	public String readValueFromElement(WebElement element) {

		if (null == element){
			log.info("weblement is null");
			return null;
		}

		boolean displayed = false;
		try {
			displayed = isDisplayed(element);
		} catch (Exception e) {
			log.error(e);
			Reporter.log(e.fillInStackTrace().toString());
			return null;
		}

		if (!displayed){
			return null;
		}
		String text = element.getText();
		log.info("weblement valus is.."+text);
		return text;
	}
	

	public String readValueFromInput(WebElement element) {
		if (null == element){
			return null;
		}
		if (!isDisplayed(element)){
			return null;
		}
		String value = element.getAttribute("value");
		log.info("weblement valus is.."+value);
		return value;
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return true;
		} catch (Exception e) {
			log.info(e);
			Reporter.log(e.fillInStackTrace().toString());
			return false;
		}
	}
	
	protected boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed.."+element);
			return false;
		} catch (Exception e) {
			log.error(e);
			Reporter.log(e.fillInStackTrace().toString());
			return true;
		}
	}
	
	protected String getDisplayText(WebElement element) {
		if (null == element){
			return null;
		}
		if (!isDisplayed(element)){
			return null;
		}
		return element.getText();
	}
	

	public static synchronized String getElementText( WebElement element) {
		if (null == element) {
			log.info("weblement is null");
			return null;
		}
		String elementText = null;
		try {
			elementText = element.getText();
		} catch (Exception ex) {
			log.info("Element not found " + ex);
			Reporter.log(ex.fillInStackTrace().toString());
		}
		return elementText;
	}
	
	public static void enter_Text(AndroidDriver<?> driver, By locator, String text) throws Exception{
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElementClickable(driver, 10, locator);
		Actions action = new Actions(driver);
		Thread.sleep(5);
		action.sendKeys(text).perform();
		//action.sendKeys(driver.findElement(locator), text);
		
	}
	
	public void scrollByCount(AndroidDriver<?> driver,int count) throws Exception {
			Dimension size = driver.manage().window().getSize();
		    int startX = size.width / 2;
		    int startY = (int) (size.height * .8);
		    int endY = (int) (size.height * .2);
		    int counter = 0;
		    Thread.sleep(5000);	    
		        while(counter<count) {
		        	new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startX, endY)).release().perform();
		        	Thread.sleep(1000);
		        	counter++;
		        }
		}
	
	public int getSearchedChannelIndex(By channelName, String channel) {
		waitHelper.waitForElementVisible(channelName, 15);
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(channelName);
		int totalCount = channels.size();
		int channelIndex = 0;
		System.out.println(channel.length());
		System.out.println(channels.get(channelIndex).getText().length());
		for(channelIndex=0;channelIndex<totalCount;channelIndex++) {
			if(channels.get(channelIndex).getText().equalsIgnoreCase(channel)) 
				break;		
		}
		return channelIndex;
	}

}
