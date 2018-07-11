package com.kisan.kisannet.pagelibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.kisan.kisannet.helper.Javascript.JavaScriptHelper;
import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyChat {

	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(MyChat.class);
	WaitHelper waitHelper;
	JavaScriptHelper javaScriptHelper;
	
	By leftDrawerButton = By.className("android.widget.ImageButton");
	By discoverIcon = By.id("com.kisan.samvaad.test:id/action_discover");
	By notificationIcon = By.xpath("//*[@id='action_notifications']");
	By rightDrawerMenu = By.xpath("//android.widget.ImageView[@content-desc='More options']");
	By channelList = By.xpath("//*[@id='listViewRecommendations']");
	By inviteToKisan = By.xpath("//android.widget.LinearLayout[@index='0']");
	By changeLanguage = By.xpath("//android.widget.LinearLayout[@index='1']");
	By searchChannel = By.xpath("//android.widget.LinearLayout[@index='2']");	
	By searchBox = By.id("com.kisan.samvaad.test:id/searchTextView");
	By searchedChannelList = By.xpath("//android.widget.TextView[@resource-id='com.kisan.samvaad.test:id/textViewCommunityName']");
	
	public MyChat(AndroidDriver<?> driver) {
		
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		javaScriptHelper = new JavaScriptHelper(driver);
	}
	
	public void clickonLeftdrawerButton() throws Exception {
		waitHelper.waitForElementVisible(leftDrawerButton, 5);
		driver.findElement(leftDrawerButton).click();
		logger.info("Clicked on left drawer button from MyChat");
		waitHelper.setImplicitWait(3, TimeUnit.SECONDS);
	} 
	
	public void clickonDiscoverIcon() throws Exception {
		waitHelper.waitForElementVisible(discoverIcon, 5);
		logger.info("Clicking on discover icon");
		driver.findElement(discoverIcon).click();
	    waitHelper.setImplicitWait(50, TimeUnit.SECONDS);    //Wait for discover page to load
	} 
	
	public boolean isUserOnMyChat() {
		boolean present;
		
			try {
				driver.findElement(discoverIcon).isDisplayed();
				present =true;
			} catch (Exception e) {
				present = false;
			}
		return present;
	}
	
	public void clickOnRightDrawerMenu() throws Exception {
		waitHelper.waitForElementVisible(rightDrawerMenu, 5);
		logger.info("Clicking on right drawer option menu");
		driver.findElement(rightDrawerMenu).click();
	} 
	
	public void clickOnInviteToKisanOption() throws Exception {
		waitHelper.waitForElementVisible(inviteToKisan, 5);
		logger.info("Clicking on invite to kisan option from right drawer");
		driver.findElement(inviteToKisan).click();
	} 
	
	public void clickOnChangeLanguageOption() throws Exception {
		waitHelper.waitForElementVisible(changeLanguage, 5);
		logger.info("Clicking on change language option from right drawer");
		driver.findElement(changeLanguage).click();
	} 
	
	public void clickOnSearchChannelOption() throws Exception {
		waitHelper.waitForElementVisible(searchChannel, 5);	
		driver.findElement(searchChannel).click();
		logger.info("Clicked on search a channel option from right drawer");
	} 

	public void searchAdminsChannel() throws Exception {
		waitHelper.waitForElementVisible(searchBox, 10);
		driver.findElement(searchBox).click();
		String channel = TestBase.prop.getProperty("AdminsChannel");
		GenericHelper.enter_Text(driver, searchBox, channel);
		//javaScriptHelper.executeScriptCopy("arguments[0].value= 'Automation Channel';", driver.findElement(searchBox));
		logger.info("Entered Channel Name In Search Box");
	}
	
	public void searchChannelToEdit() throws Exception {
		waitHelper.waitForElementVisible(searchBox, 10);
		driver.findElement(searchBox).click();
		String channel = TestBase.prop.getProperty("ChannelToBeEdited");
		GenericHelper.enter_Text(driver, searchBox, channel);
		//javaScriptHelper.executeScriptCopy("arguments[0].value= 'Automation Channel';", driver.findElement(searchBox));
		logger.info("Entered Channel Name In Search Box");
	}
	
	public Boolean searchEditedChannel() throws Exception {
		waitHelper.waitForElementVisible(searchBox, 10);
		driver.findElement(searchBox).click();
		String channel = TestBase.prop.getProperty("EditedChannelName");
		GenericHelper.enter_Text(driver, searchBox, channel);
		waitHelper.waitForElementVisible(searchedChannelList, 10);
		List<AndroidElement> searchedChannels = (List<AndroidElement>) driver.findElements(searchedChannelList);
		Boolean flag = false;
		System.out.println(searchedChannels.get(0).getText());
		for(int i=0; i<searchedChannels.size(); i++) {
			if(searchedChannels.get(i).getText().equals(channel)) {
				flag = true;
				break;
			}
		}
		driver.navigate().back();
		driver.navigate().back();
		return flag;
		
	}
	
	public void clickOnSearchedChannel() {
		waitHelper.waitForElementVisible(searchedChannelList, 10);
		List<AndroidElement> searchedChannels = (List<AndroidElement>) driver.findElements(searchedChannelList);
		searchedChannels.get(0).click();
		logger.info("Clicked On Searched Channel");		
	}
	
	public void searchFollowersChannel() throws Exception {
		waitHelper.waitForElementVisible(searchBox, 10);
		driver.findElement(searchBox).click();
		String channel = TestBase.prop.getProperty("FollowersChannel");
		GenericHelper.enter_Text(driver, searchBox, channel);
		logger.info("Entered Channel Name In Search Box");
	}
	
	public void searchChannel(String channelName) throws Exception {
		waitHelper.waitForElementVisible(searchBox, 10);
		driver.findElement(searchBox).click();
		GenericHelper.enter_Text(driver, searchBox, channelName);
		logger.info("Entered Channel Name In Search Box");
	}

		
}
