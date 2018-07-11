package com.kisan.kisannet.pagelibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.google.common.base.Utf8;
import com.kisan.kisannet.helper.Alert.AlertHelper;
import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LeftDrawer {
	
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(LeftDrawer.class);
	WaitHelper waitHelper;
	AlertHelper alertHelper;
	
	public  By userProfileImage = By.id("com.kisan.samvaad.test:id/circleView");
	public  By myChats = By.xpath("//android.support.v7.widget.LinearLayoutCompat[@index='1']");
	public  By startYourChannel= By.xpath("//android.support.v7.widget.LinearLayoutCompat[@index='2']");
	public  By language = By.xpath("//android.support.v7.widget.LinearLayoutCompat[@index='4']");
	public  By share = By.xpath("//android.support.v7.widget.LinearLayoutCompat[@index='5']");
	public  By support = By.xpath("//android.support.v7.widget.LinearLayoutCompat[@index='6']");
	public  By logout = By.xpath("//android.support.v7.widget.LinearLayoutCompat[@index='7']");
	public  By logoutYesButton = By.id("android:id/button2");
	public  By logoutNoButton = By.id("android:id/button2");
	public  By opacity = By.xpath(""); 
	public  By appLanguage = By.xpath("//android.widget.CheckedTextView[@resource-id='com.kisan.samvaad.test:id/design_menu_item_text']");
	public  By userName = By.id("com.kisan.samvaad.test:id/textViewName");
	
	
	public LeftDrawer(AndroidDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		alertHelper = new AlertHelper(driver);
	}
	
	public void clickonUserProfileImage() throws Exception {
		waitHelper.waitForElementClickable(driver, 15, userProfileImage);
		logger.info("Clicking on user profile image");
		driver.findElement(userProfileImage).click();
	}
	
	public void clickonMyChats() {
		waitHelper.waitForElementClickable(driver, 15, myChats);
		logger.info("Clicking on MyChats");
		driver.findElement(myChats).click();
	}
	
	public void clickonstartYourChannel() {
		waitHelper.waitForElementClickable(driver, 10, startYourChannel);
		List<MobileElement> startYourChannel1= (List<MobileElement>) driver.findElements((By) startYourChannel);
		logger.info("Clicking on Start Your Channel");
		startYourChannel1.get(1).click();
	} 

	public void clickonLanguage() throws Exception {
		System.out.println(driver.getPageSource());
		waitHelper.waitForElementClickable(driver, 15, language);
		logger.info("Clicking on Language");
		driver.findElement(language).click();
		waitHelper.setImplicitWait(5, TimeUnit.SECONDS);
	} 
	
	public void clickonShare() {
		waitHelper.waitForElementClickable(driver, 15, share);
		logger.info("Clicking on Share");
		driver.findElement(share).click();
	} 

	public void clickonSupport() {
		waitHelper.waitForElementClickable(driver, 15, support);
		logger.info("Clicking on Support");
		driver.findElement(support).click();
	} 
	
	public void clickonLogout() {
		waitHelper.waitForElementClickable(driver, 15, logout);
		logger.info("Clicking on Logout");
		driver.findElement(logout).click();
	} 
	
	public void clickonLogoutYesButton() {
		waitHelper.waitForElementClickable(driver, 15, logoutYesButton);
		logger.info("Clicking Yes on Logout popup");
		driver.findElement(logoutYesButton).click();
	} 
	
	public void clickonLogoutNoButton() {
		waitHelper.waitForElementClickable(driver, 15, logoutNoButton);
		logger.info("Clicking No on Logout popup");
		driver.findElement(logoutNoButton).click();
	} 
	
	public boolean verifyAppLanguge(String expectedLanguage) throws Exception {
		waitHelper.setImplicitWait(5, TimeUnit.SECONDS);
		boolean flag = false;
		MyChat myChat = new MyChat(driver);
		myChat.clickonLeftdrawerButton();
	    String myChatText = driver.findElement(appLanguage).getText();
	    switch(expectedLanguage) {
	    case "Marathi":
	    	 if(myChatText.equals("माझे संवाद")) {
	 	    	flag=true;
	 	    }
	    	break;
	    case "Hindi":
	    	if(myChatText.equals("बातचीत")) {
	 	    	flag=true;
	 	    }
	    	break;
	    case "English":
	    	if(myChatText.equals("My Chats")) {
	 	    	flag=true;	
	 	    }
	    	break;
	    }
	    return flag;
	
	}
	
	public String getUserName() {
		waitHelper.waitForElementVisible(userName, 5);
		String userFullName = driver.findElement(userName).getText();
		return userFullName;		
	}
	
	public boolean compareEditedUserName() {
		String userFullName = getUserName();
		String fName = TestBase.prop.getProperty("EditedFirstName");
		String lName = TestBase.prop.getProperty("EditedLastName");
		String completeEditedName = fName+" "+lName;
		System.out.println(completeEditedName);
		if(userFullName.equals(completeEditedName)) {
			return true;
		}
		else {
			return false;
		}
	}
}
