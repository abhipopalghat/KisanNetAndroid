package com.kisan.kisannet.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SelectContact {
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(SelectContact.class);
	WaitHelper waitHelper;
	
	public By backArrow = By.xpath("//android.widget.ImageButton[@inded='0']");
	public By doneButton = By.id("com.kisan.samvaad.test:id/action_done");
	public By searchBox = By.id("com.kisan.samvaad.test:id/searchTextView");
	public By enterNumber = By.id("com.kisan.samvaad.test:id/textViewEnterNo");
	public By checkBox = By.className("android.widget.CheckBox");
	
	public SelectContact(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickDone() {
		waitHelper.waitForElementVisible(doneButton, 10);
		driver.findElement(doneButton).click();
		logger.info("Clicked on Done Button");
	}
	
	public void clickBack() {
		waitHelper.waitForElementVisible(backArrow, 10);
		driver.findElement(backArrow).click();
		logger.info("Clicked on Back Button");
	}
	
	public void searchContact() throws Exception {
		waitHelper.waitForElementVisible(searchBox, 10);
		driver.findElement(searchBox).click();
		String contact = TestBase.prop.getProperty("ContactToInvite");
		GenericHelper.enter_Text(driver, searchBox, contact);
		logger.info("Entered Contact Name In Search Box");
	}
	
	public void clickEnterNumber() {
		waitHelper.waitForElementVisible(enterNumber, 10);
		driver.findElement(enterNumber).click();
		logger.info("Clicked In Enter Number Box");
	}
	
	public void selectCheckBox() {
		waitHelper.waitForElementVisible(checkBox, 10);
		List<AndroidElement> allCheckBoxes = (List<AndroidElement>) driver.findElements(checkBox);
		allCheckBoxes.get(0).click();
		logger.info("Checked CheckBox Of Searched Contact");
	}

}
