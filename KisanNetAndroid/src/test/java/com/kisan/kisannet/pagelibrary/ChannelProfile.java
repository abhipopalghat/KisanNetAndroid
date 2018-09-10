package com.kisan.kisannet.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;

import io.appium.java_client.android.AndroidDriver;

public class ChannelProfile {

	public AndroidDriver<?> driver;
	public WaitHelper waitHelper;
	private final Logger logger = LoggerHelper.getLogger(ChannelProfile.class);
	
	By channelProfileImage = By.id("com.kisan.samvaad.dev:id/imageViewCommunityIcon");
	By backArrow = By.xpath("//android.widget.ImageButton[@instance='0']");
	By rightDrawerMenu = By.xpath("//android.widget.ImageView[@content-desc='More options']");
	By editProfile = By.xpath("//android.widget.LinearLayout[@index='0']");
	By invite = By.xpath("//android.widget.TextView[@text='Invite']");
	By mute = By.xpath("//android.widget.TextView[@text='Mute']");
	By deleteChannel = By.xpath("//android.widget.LinearLayout[@index='3']");
	By leaveChannel = By.xpath("//android.widget.TextView[@text='Unfollow Channel']");
	By showFollowers = By.id("com.kisan.samvaad.dev:id/textViewMember");
	By chatIcon = By.id("com.kisan.samvaad.dev:id/floatingActionButton");
	By followButton = By.id("com.kisan.samvaad.dev:id/floatingActionButton");
	By yesButtonOnUnFollowChannelPopup = By.id("android:id/button1");
	By noButtonOnUnFollowChannelPopup = By.id("android:id/button2");
	
	public ChannelProfile(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickOnRightDrawer() {
		waitHelper.waitForElementVisible(rightDrawerMenu, 5);
		driver.findElement(rightDrawerMenu).click();
		logger.info("Clicked on channel right Drawer");
	}
	
	public void clickOnBackArrow() {
		waitHelper.waitForElementVisible(backArrow, 5);
		driver.findElement(backArrow).click();
		logger.info("Clicked on back button");
	}
	
	public void clickOnChannelProfileImage() {
		waitHelper.waitForElementVisible(channelProfileImage, 5);
		driver.findElement(channelProfileImage).click();
		logger.info("Clicked on channel profile image");
	}
	
	public void clickOnEditProfileOption() {
		waitHelper.waitForElementVisible(editProfile, 5);
		driver.findElement(editProfile).click();
		logger.info("Clicked on edit profile option");
	}
	
	public void clickOnInviteOption() {
		waitHelper.waitForElementVisible(invite, 5);
		driver.findElement(invite).click();
		logger.info("Clicked on invite option");
	}
	
	public void clickOnMuteOption() {
		waitHelper.waitForElementVisible(mute, 5);
		driver.findElement(mute).click();
		logger.info("Clicked on mute option");
	}
	
	public void clickOnDeleteChannelOption() {
		waitHelper.waitForElementVisible(deleteChannel, 5);
		driver.findElement(deleteChannel).click();
		logger.info("Clicked on delete channel option");
	}
	
	public void clickOnLeaveChannelOption() {
		waitHelper.waitForElementVisible(leaveChannel, 5);
		driver.findElement(leaveChannel).click();
		logger.info("Clicked on leave channel option");
	}
	
	public void clickOnShowFollowersOption() {
		waitHelper.waitForElementVisible(showFollowers, 5);
		driver.findElement(showFollowers).click();
		logger.info("Clicked on show followers button");
	}
	
	public void clickOnChatIcon() {
		waitHelper.waitForElementVisible(chatIcon, 5);
		driver.findElement(chatIcon).click();
		logger.info("Clicked on chat icon");
	}
	
	public void clickOnFollowButton() throws Exception {
		waitHelper.waitForElementVisible(followButton, 5);
		driver.findElement(followButton).click();
		logger.info("Clicked on follow icon");
		Thread.sleep(10000);
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
	
}
