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

public class InvitePeople {
	
	public AndroidDriver<?> driver;
	public WaitHelper waitHelper;
	public GenericHelper genericHelper;
	private final Logger logger = LoggerHelper.getLogger(InvitePeople.class);
	
	By backArrow = By.xpath("//android.widget.ImageButton[@instance='0']");
	By inviteButton = By.id("com.kisan.samvaad.test:id/action_invite");
	By searchContact = By.id("com.kisan.samvaad.test:id/searchTextView");
	By enterNumber = By.id("com.kisan.samvaad.test:id/linear_layout_enternumber");
	By contactListToInviteToApp = By.id("com.kisan.samvaad.test:id/listViewContacts");
	By doneButton = By.id("com.kisan.samvaad.test:id/action_done");
	By contactListToInviteToChannel = By.id("com.kisan.samvaad.test:id/recyclerViewContactList");
	
	public InvitePeople(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper();
	}
	
	public void clickBackArrow() {
		waitHelper.waitForElementVisible(backArrow, 5);
		driver.findElement(backArrow).click();
		logger.info("Clicked back arrow");
	}
	
	public void clickOnInviteButton() {
		waitHelper.waitForElementVisible(inviteButton, 5);
		driver.findElement(inviteButton).click();
		logger.info("Clicked on invite button");
	}
	
	public void clickOnDoneButton() {
		waitHelper.waitForElementVisible(doneButton, 5);
		driver.findElement(doneButton).click();
		logger.info("Clicked on done button");
	}
	
	public void enterContactName() throws Exception {
		waitHelper.waitForElementVisible(searchContact, 5);
		driver.findElement(searchContact).click();
		String contactName = TestBase.prop.getProperty("InviteContact");
		genericHelper.enter_Text(driver, searchContact, contactName );
		logger.info("Entered contact to search");
	}
	
	public void selectSearchedContactToDownloadApp() {
		waitHelper.waitForElementVisible(contactListToInviteToApp, 5);
		List<AndroidElement> contactList = (List<AndroidElement>) driver.findElements(contactListToInviteToApp);
		contactList.get(0).click();
		logger.info("Selected contact");
	}
	
	public void selectSearchedContactToInviteChannel() {
		waitHelper.waitForElementVisible(contactListToInviteToChannel, 5);
		List<AndroidElement> contactList = (List<AndroidElement>) driver.findElements(contactListToInviteToChannel);
		contactList.get(0).click();
		logger.info("Selected contact");
	}
	
	public void clickOnEnterNumberField() {
		waitHelper.waitForElementVisible(enterNumber, 5);
		driver.findElement(enterNumber).click();
		logger.info("Clicked in enter a number manually field");
	}
	
	
}
