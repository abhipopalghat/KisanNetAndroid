package com.kisan.kisannet.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DiscoverPage {

	AndroidDriver<?> driver;
	WaitHelper waitHelper;
	private final Logger logger = LoggerHelper.getLogger(DiscoverPage.class);
	TestBase testBase = new TestBase();
	
	public By okGotIt = By.id("com.kisan.samvaad.test:id/buttonGotItDiscoverShowOverlay");
	public By backArrow = By.className("android.widget.ImageButton");
	public By refreshButton = By.id("com.kisan.samvaad.test:id/action_refresh");
	public By searchButton = By.id("com.kisan.samvaad.test:id/action_search");
	public By searchTextBox = By.className("android.widget.EditText");
	public By filter = By.id("com.kisan.samvaad.test:id/action_filter");
	public By channelName = By.id("com.kisan.samvaad.test:id/textViewCommunityName");
	public By followButton = By.id("com.kisan.samvaad.test:id/imageButtonJoin");
	public By followingButton = By.id("com.kisan.samvaad.test:id/imageButtonLeave");
	
	
	public DiscoverPage(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
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
	
	public void searchChannel() {
		//isFirstTimeOnDiscover();
		if(driver.findElement(searchButton)!=null) {
		driver.findElement(searchButton).click();
		String channel = TestBase.prop.getProperty("ChannelToBeFollowedFromDiscover");
		//clickOnSearchBox();
		waitHelper.waitForElementVisible(searchTextBox, 10);
		driver.findElement(searchTextBox).click();
		GenericHelper.enter_Text(driver, searchTextBox, channel);
		driver.navigate().back();
		logger.info("Searched channel");
		}
		else {
			isFirstTimeOnDiscover();
			searchChannel();
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
		for(channelIndex=0;channelIndex<=totalCount;channelIndex++) {
			if(channels.get(channelIndex).getText()==channel) {
				break;
			}
		}
		return channelIndex;
	}
	
	public void followChannel() {
		waitHelper.waitForElementVisible(followButton, 10);
		String channelToBeFollowed = testBase.prop.getProperty("ChannelToBeFollowedFromDiscover");
		int channelIndex = getSearchedChannelIndex(channelToBeFollowed);
		List<AndroidElement> followButtons = (List<AndroidElement>)driver.findElements(followButton);
		followButtons.get(channelIndex).click();
		logger.info("Clicked on follow button");
	}
	
	public void openChannelProfile() {
		waitHelper.waitForElementVisible(channelName, 15);
		String channelToBeOpened = testBase.prop.getProperty("ChannelToBeFollowedFromProfile");
		int channelIndex = getSearchedChannelIndex(channelToBeOpened);
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(channelName);
		channels.get(channelIndex).click();
		logger.info("Opened Channel");
	}
}
