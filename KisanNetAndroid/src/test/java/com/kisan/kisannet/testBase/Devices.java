package com.kisan.kisannet.testBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.pagelibrary.ChannelChatWindow;

import io.appium.java_client.android.AndroidDriver;

public class Devices {
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(ChannelChatWindow.class);
	WaitHelper waitHelper;
	
	public By shutterButton_redmi = By.xpath("//android.widget.ImageView[@content-desc='Shutter button']");
	public By shutterButton_lenovo = By.xpath("//android.widget.ImageView[@content-desc='Shutter']");
	public By shutterButton_yureka = By.xpath("//android.widget.ImageView[@content-desc='Shutter']");
	
	public By yesAfterCapturingPhoto_redmi = By.id("com.android.camera:id/v6_btn_done");
	public By yesAfterCapturingPhoto_lenovo = By.id("com.android.camera2:id/done_button");
	public By yesAfterCapturingPhoto_yureka = By.id("org.codeaurora.snapcam:id/btn_done");
			
	public Devices(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickOnYesButton(String deviceName) {
		switch(deviceName) {
		case "Redmi":
			waitHelper.waitForElementVisible(yesAfterCapturingPhoto_redmi, 40);
			driver.findElement(yesAfterCapturingPhoto_redmi).click();
			logger.info("Clicked on yes tickmark after capturing photo");
			break;
			
		case "PixelV1":
			waitHelper.waitForElementVisible(yesAfterCapturingPhoto_lenovo, 40);
			driver.findElement(yesAfterCapturingPhoto_lenovo).click();
			logger.info("Clicked on yes tickmark after capturing photo");
			break;
			
		case "YU4711":
			waitHelper.waitForElementVisible(yesAfterCapturingPhoto_yureka, 40);
			driver.findElement(yesAfterCapturingPhoto_yureka).click();
			logger.info("Clicked on yes tickmark after capturing photo");
			break;
		}
	}
	
	public void clickOnShutterButton(String deviceName) {
		switch(deviceName) {
		case "Redmi":
			waitHelper.waitForElementVisible(shutterButton_redmi, 40);
			driver.findElement(shutterButton_redmi).click();
			logger.info("Clicked on yes tickmark after capturing photo");
			break;
			
		case "PixelV1":
			waitHelper.waitForElementVisible(shutterButton_lenovo, 40);
			driver.findElement(shutterButton_lenovo).click();
			logger.info("Clicked on yes tickmark after capturing photo");
			break;
			
		case "YU4711":
			waitHelper.waitForElementVisible(shutterButton_yureka, 40);
			driver.findElement(shutterButton_yureka).click();
			logger.info("Clicked on yes tickmark after capturing photo");
			break;
		}
	}
	
	

}
