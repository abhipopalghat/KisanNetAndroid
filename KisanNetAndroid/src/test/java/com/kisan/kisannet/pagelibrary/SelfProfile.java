package com.kisan.kisannet.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SelfProfile {
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(SelfProfile.class);
	WaitHelper waitHelper;
	GenericHelper genericHelper;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By userImage = By.id("com.kisan.samvaad.dev:id/imageViewUserImage");
	public By editProfileButton = By.id("com.kisan.samvaad.dev:id/floatingActionButtonEditUserProfile");
	public By viewAllButton = By.id("com.kisan.samvaad.dev:id/textViewShowAllChannels");
	public By channelList = By.xpath("//android.widget.TextView[@resource-id='com.kisan.samvaad.dev:id/textViewCommunityName']");
	
	public SelfProfile(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);
	}
	
	public void clickBackArrow() {
		waitHelper.waitForElementVisible(backArrow, 5);
		driver.findElement(backArrow).click();
		logger.info("Clicked back arrow");
	}
	
	public void clickUserImage() {
		waitHelper.waitForElementVisible(userImage, 5);
		driver.findElement(userImage).click();
		logger.info("Clicked on user image");
	}
	
	public void clickEditProfileButton() {
		waitHelper.waitForElementVisible(editProfileButton, 5);
		driver.findElement(editProfileButton).click();
		logger.info("Clicked on edit profile button");
	}
	
	public void clickViewAllButton() {
		waitHelper.waitForElementVisible(viewAllButton, 5);
		driver.findElement(viewAllButton).click();
		logger.info("Clicked on view all button");
	}
	
	public boolean isMoreThanFiveChannels() {
		boolean flag = genericHelper.isDisplayed(driver.findElement(viewAllButton));
		return flag;
	}
	
	public boolean isChannelPresentOnSelfProfile(String channelName) {
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(channelList);
		boolean flag = false;
		int totalChannels = channels.size();
		for(int i = 0; i<totalChannels; i++) {
			if(channels.get(i).getText().equalsIgnoreCase(channelName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public void clickOnChannel(String channelName) {
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(channelList);
		int totalChannels = channels.size();
		for(int i = 0; i<totalChannels; i++) {
			if(channels.get(i).getText().equalsIgnoreCase(channelName)) {
				channels.get(i).click();
				break;
			}
		}
	}
}
