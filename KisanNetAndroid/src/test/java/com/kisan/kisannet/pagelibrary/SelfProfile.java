package com.kisan.kisannet.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;

import io.appium.java_client.android.AndroidDriver;

public class SelfProfile {
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(SelfProfile.class);
	WaitHelper waitHelper;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By userImage = By.id("com.kisan.samvaad.test:id/imageViewUserImage");
	public By editProfileButton = By.id("com.kisan.samvaad.test:id/floatingActionButtonEditUserProfile");
	public By viewAllButton = By.id("com.kisan.samvaad.test:id/textViewShowAllChannels");
	
	public SelfProfile(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
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
}
