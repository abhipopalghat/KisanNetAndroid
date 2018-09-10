package com.kisan.kisannet.pagelibrary;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.kisan.kisannet.helper.Javascript.JavaScriptHelper;
import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DiscoverPage {

	AndroidDriver<?> driver;
	WaitHelper waitHelper;
	private final Logger logger = LoggerHelper.getLogger(DiscoverPage.class);
	JavaScriptHelper javaScriptHelper;
	
	//TestBase test = new TestBase();
	//String channel = test.prop.getProperty("FollowersChannel");
	public By okGotIt = By.id("com.kisan.samvaad.dev:id/buttonGotItDiscoverShowOverlay");
	public By backArrow = By.className("android.widget.ImageButton");
	public By refreshButton = By.id("com.kisan.samvaad.dev:id/action_refresh");
	public By searchButton = By.id("com.kisan.samvaad.dev:id/action_search");
	//public By searchTextBox = By.className("android.widget.EditText");
	public By searchTextBox = By.xpath("//android.widget.TextView[@text='Discover']");
	public By filter = By.id("com.kisan.samvaad.dev:id/action_filter");
	public By channelName = By.id("com.kisan.samvaad.dev:id/textViewCommunityName");
	//public By tempChannelName = By.xpath("//android.widget.TextView[starts-with(@text,"+channel+")]");
	public By followButton = By.id("com.kisan.samvaad.dev:id/imageButtonJoin");
	public By followingButton = By.id("com.kisan.samvaad.dev:id/imageButtonLeave");
	
	
	public DiscoverPage(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		javaScriptHelper = new JavaScriptHelper(driver);
	}
	
	public void isFirstTimeOnDiscover() {
		/*if(driver.findElement(okGotIt)==null) {
			clickonOkGotIt();	
		}*/
		try {
			clickonOkGotIt();
		}
		catch (Exception e) {
			logger.info("Element Not Found");
		}
	}
	
	public void clickonOkGotIt() {
		waitHelper.waitForElementClickable(driver, 10, okGotIt);
		driver.findElement(okGotIt).click();
		logger.info("Clicked on Got It Button");
	}
	
	public void clickBack() {
		waitHelper.waitForElementVisible(backArrow, 10);
		driver.findElement(backArrow).click();
		logger.info("Clicked on Back Button");
	}
	
	public void clickOnRefreshButton() {
		waitHelper.waitForElementVisible(refreshButton, 10);
		driver.findElement(refreshButton).click();
		logger.info("Clicked on Refresh Button");
	}
	
	public void clickOnSearchBox() {
		waitHelper.waitForElementVisible(searchTextBox, 10);
		driver.findElement(searchTextBox).click();
		logger.info("Clicked on Search Box");
	}
	
	public void searchChannel(String channelName) throws Exception {
		if(driver.findElement(searchButton)!=null) {		//Checks if user lands directly on discover page
		driver.findElement(searchButton).click();
		driver.findElement(searchTextBox).click();
		driver.findElement(searchTextBox).sendKeys(channelName);
		logger.info("Searched channel");
		}
		else {
			isFirstTimeOnDiscover();						//Checks if user lands on Got it screen overlay
			searchChannel(channelName);
		}
	}
	
	
	public void clickOnFilterButton() {
		waitHelper.waitForElementVisible(filter, 10);
		driver.findElement(filter).click();
		logger.info("Clicked on filter");
	}
	
	public int getSearchedChannelIndex(String channel) {
		waitHelper.waitForElementVisible(channelName, 15);
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(channelName);
		int totalCount = channels.size();
		int channelIndex = 0;
		for(channelIndex=0;channelIndex<totalCount;channelIndex++) {
			if(channels.get(channelIndex).getText().equalsIgnoreCase(channel)) 
				break;		
		}
		return channelIndex;
	}
	
	public void followChannel() throws Exception {
		waitHelper.waitForElementVisible(followButton, 10);
		String channelToBeFollowed = TestBase.prop.getProperty("ChannelToBeFollowedFromDiscover");
		int channelIndex = getSearchedChannelIndex(channelToBeFollowed);
		List<AndroidElement> followButtons = (List<AndroidElement>)driver.findElements(followButton);
		followButtons.get(channelIndex).click();
		Thread.sleep(3000);
		logger.info("Clicked on follow button");
	}
	
	public AndroidElement getChannelToBeFollowed() {
		waitHelper.waitForElementVisible(followButton, 10);
		String channelToBeFollowed = TestBase.prop.getProperty("ChannelToBeFollowedFromDiscover");
		int channelIndex = getSearchedChannelIndex(channelToBeFollowed);
		List<AndroidElement> followButtons = (List<AndroidElement>)driver.findElements(followButton);
		AndroidElement followButton = followButtons.get(channelIndex);
		return followButton;
	}
	
	public void openChannelProfile() {
		waitHelper.waitForElementVisible(channelName, 15);
		String channelToBeOpened = TestBase.prop.getProperty("ChannelToBeFollowedFromProfile");// wrong parameter
		int channelIndex = getSearchedChannelIndex(channelToBeOpened);
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(channelName);
		System.out.println(channels.size());
		channels.get(channelIndex).click();
		logger.info("Opened Channel");
	}
	
	public void openChannelProfileToUnfollow(String channelName) {
		waitHelper.waitForElementVisible(this.channelName, 15);
		int channelIndex = getSearchedChannelIndex(channelName);
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(this.channelName);
		System.out.println(channels.size());
		channels.get(channelIndex).click();
		logger.info("Opened Channel");
	}
	
	public void moveToChannel() throws Exception {
		TestBase test = new TestBase();
		String channel = test.prop.getProperty("ChannelToBeFollowedFromDiscover");
		By tempChannelName = By.xpath("//android.widget.TextView[starts-with(@text,'Undecennial')]");
		
		Dimension size = driver.manage().window().getSize();
		    int startX = size.width / 2;
		    int startY = (int) (size.height * .8);
		    int endY = (int) (size.height * .2);
		    Thread.sleep(5000);	    
		        while(!isChannelFound()) {
		        	new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startX, endY)).release().perform();
		        	Thread.sleep(1000);
		        }
		       AndroidElement ele = (AndroidElement) driver.findElement(tempChannelName);
		        new TouchActions(driver).singleTap(ele);
		        Thread.sleep(5000);
	}

	public boolean isChannelFound() {
		boolean present;
		TestBase test = new TestBase();
		String channel = test.prop.getProperty("ChannelToBeFollowedFromDiscover");
		By tempChannelName = By.xpath("//android.widget.TextView[starts-with(@text,'"+channel+"')]");
		
			try {
				driver.findElement(tempChannelName).isDisplayed();
				present =true;
			} catch (Exception e) {
				present = false;
			}
		return present;
	}
	
}
