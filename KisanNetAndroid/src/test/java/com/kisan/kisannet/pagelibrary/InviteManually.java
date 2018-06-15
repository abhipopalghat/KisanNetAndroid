package com.kisan.kisannet.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class InviteManually {
	
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(InviteManually.class);
	WaitHelper waitHelper;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By inviteButton = By.id("com.kisan.samvaad.test:id/action_invite");
	public By enterNumberBox = By.id("com.kisan.samvaad.test:id/editTextEnterNo");
	

	public InviteManually(AndroidDriver<?> driver) {
		this.driver=driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickInvite() {
		waitHelper.waitForElementVisible(inviteButton, 10);
		driver.findElement(inviteButton).click();
		logger.info("Clicked on Invite Button");
	}
	
	public void clickBack() {
		waitHelper.waitForElementVisible(backArrow, 10);
		driver.findElement(backArrow).click();
		logger.info("Clicked on Back Button");
	}
	
	public void enterMobileNumberManually() throws Exception {
		waitHelper.waitForElementVisible(enterNumberBox, 10);
		driver.findElement(enterNumberBox).click();
		String manualContact = TestBase.prop.getProperty("InviteManually");
		GenericHelper.enter_Text(driver, enterNumberBox, manualContact);
		logger.info("Entered Mobile Number Manually");
	}
	
}
