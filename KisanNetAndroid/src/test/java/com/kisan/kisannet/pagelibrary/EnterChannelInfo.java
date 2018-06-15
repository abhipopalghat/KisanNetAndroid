package com.kisan.kisannet.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class EnterChannelInfo {
	
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(EnterChannelInfo.class);
	WaitHelper waitHelper;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By nextBtn = By.id("com.kisan.samvaad.test:id/action_next");
	public By aboutChannel = By.id("com.kisan.samvaad.test:id/editTextCommunityDesc");
	public By publicChannelRadioButton = By.id("com.kisan.samvaad.test:id/radioButtonPublic");
	public By privateChannelRadioButton = By.cssSelector("com.kisan.samvaad.test:id/radioButtonPrivate");
	
	public EnterChannelInfo(AndroidDriver<?> driver) {
		this.driver=driver;
		waitHelper = new WaitHelper(driver);
	}
	
	
	public void clickNext() {
		waitHelper.waitForElementVisible(nextBtn, 10);
		driver.findElement(nextBtn).click();
		logger.info("Clicked on Next Button");
	}
	
	public void clickBack() {
		waitHelper.waitForElementVisible(backArrow, 10);
		driver.findElement(backArrow).click();
		logger.info("Clicked on Back Button");
	}
	
	public void enterDescription() throws Exception {
		waitHelper.waitForElementClickable(driver, 10, aboutChannel);
		driver.findElement(aboutChannel).click();
		String description = TestBase.prop.getProperty("Description");
		GenericHelper.enter_Text(driver, aboutChannel, description);
		logger.info("Description Entered");
	}
	
	public void selectPublicChannel() {
		waitHelper.waitForElementVisible(publicChannelRadioButton, 10);
		driver.findElement(publicChannelRadioButton).click();
		logger.info("Selected Public Channel");
	}
	
	public void selectPrivateChannel() {
		waitHelper.waitForElementVisible(privateChannelRadioButton, 10);
		driver.findElement(privateChannelRadioButton).click();
		logger.info("Selected Private Channel");
	}
	
}
