package com.kisan.kisannet.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ChannelsYouFollow {

	public AndroidDriver<?> driver;
	protected Logger logger = LoggerHelper.getLogger(ChannelsYouFollow.class);
	public WaitHelper waitHelper;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By channelList = By.xpath("//android.widget.TextView[@resource-id='com.kisan.samvaad.test:id/textViewCommunityName']");
	public By channelProfile = By.id("com.kisan.samvaad.test:id/textViewViewProfile");
	public By sendMessage= By.xpath("//android.widget.TextView[@text='Send a Message']");
	public By unfollowChannel = By.id("com.kisan.samvaad.test:id/textViewLeave");
	public By yesButtonOnUnFollowChannelPopup = By.id("android:id/button1");
	public By noButtonOnUnFollowChannelPopup = By.id("android:id/button2");
	
	
	public ChannelsYouFollow(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickBackArrow() {
		waitHelper.waitForElementVisible(backArrow, 5);
		driver.findElement(backArrow).click();
		logger.info("Clicked back arrow");
	}
	
	public void clickOnChannelProfile() {
		waitHelper.waitForElementVisible(channelProfile, 5);
		driver.findElement(channelProfile).click();
		logger.info("Clicked on channel profile option");
	}
	
	public void clickOnSendMessage() {
		waitHelper.waitForElementVisible(sendMessage, 5);
		driver.findElement(sendMessage).click();
		logger.info("Clicked on send message option");
	}
	
	public void clickOnLeaveChannel() {
		waitHelper.waitForElementVisible(unfollowChannel, 5);
		driver.findElement(unfollowChannel).click();
		logger.info("Clicked on leave channel option");
	}
	
	public void clickOnYesOnUnfollow() {
		waitHelper.waitForElementVisible(yesButtonOnUnFollowChannelPopup, 5);
		driver.findElement(yesButtonOnUnFollowChannelPopup).click();
		logger.info("Clicked on Yes button");
	}
	
	public void clickOnNoOnUnfollow() {
		waitHelper.waitForElementVisible(noButtonOnUnFollowChannelPopup, 5);
		driver.findElement(noButtonOnUnFollowChannelPopup).click();
		logger.info("Clicked on No button");
	}
	
	public void clickOnChannelName(String channelToBeUnfollow) {
		List<AndroidElement> channels = (List<AndroidElement>)driver.findElements(channelList);
		int totalChannels = channels.size();
		System.out.println(channels.get(0).getText());
		System.out.println(channels.get(0).getText().length());
		for(int i = 0; i<totalChannels; i++) {
			if(channels.get(i).getText().equalsIgnoreCase(channelToBeUnfollow)) {
				channels.get(i).click();
				break;
			}
		}
	}
}
