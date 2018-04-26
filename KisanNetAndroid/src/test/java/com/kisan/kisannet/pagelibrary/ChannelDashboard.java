package com.kisan.kisannet.pagelibrary;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;

import io.appium.java_client.android.AndroidDriver;

public class ChannelDashboard {

	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(MyChat.class);
	WaitHelper waitHelper;
	
	public By channelName = By.xpath("//android.widget.TextView[@index='1']");
	public By leftDrawerButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Open\"]");
	public By notificationIcon = By.id("com.kisan.samvaad.test:id/action_notifications");
	public By newMessageButton = By.id("com.kisan.samvaad.test:id/floatingActionButtonGoToChat");
	
	public ChannelDashboard(AndroidDriver<?> driver) {
		this .driver = driver;
		waitHelper = new WaitHelper(driver);		
	}
	
	public String getChannelName() {
		waitHelper.waitForElementVisible(channelName, 5);
		return driver.findElement(channelName).getText();
	}
	
	public void clickonLeftdrawerButton() throws Exception {
		waitHelper.waitForElementVisible(leftDrawerButton, 5);
		driver.findElement(leftDrawerButton).click();
		logger.info("Clicked on left drawer button from channel dashboard");
		waitHelper.setImplicitWait(5, TimeUnit.SECONDS);
	} 
	
	public void clickOnNotificationIcon() {
		waitHelper.waitForElementClickable(driver, 5, notificationIcon);
		driver.findElement(notificationIcon).click();
		logger.info("Notification icon clickedo on channel dashboard");
	}
	
	public void clickOnNewMessageButton() {
		waitHelper.waitForElementClickable(driver, 5, newMessageButton);
		driver.findElement(newMessageButton).click();
		logger.info("Clicked on new message button from channel dashboard");
	}
	
	
}
