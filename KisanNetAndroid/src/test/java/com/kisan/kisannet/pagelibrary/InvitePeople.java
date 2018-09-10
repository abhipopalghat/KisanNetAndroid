package com.kisan.kisannet.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.kisan.kisannet.helper.Alert.AlertHelper;
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
	public AlertHelper alertHelper;
	private final Logger logger = LoggerHelper.getLogger(InvitePeople.class);
	
	By backArrow = By.xpath("//android.widget.ImageButton[@instance='0']");
	By inviteButton = By.id("com.kisan.samvaad.dev:id/action_invite");
	By searchContact = By.id("com.kisan.samvaad.dev:id/searchTextView");
	By enterNumber = By.id("com.kisan.samvaad.dev:id/linear_layout_enternumber");
	By contactListToInviteToApp = By.className("android.widget.CheckBox");
	By doneButton = By.id("com.kisan.samvaad.dev:id/action_done");
	By contactListToInviteToChannel = By.id("com.kisan.samvaad.dev:id/recyclerViewContactList");
	By getContacts = By.id("com.kisan.samvaad.dev:id/textViewGetContacts");
	
	public InvitePeople(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);
		alertHelper = new AlertHelper(driver);
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
		boolean flag = isContactPermissionGiven();
		if(flag) {
			driver.findElement(getContacts).click();
			alertHelper.AcceptPermissions();
			//Thread.sleep(3000);
			waitHelper.waitForElementVisible(searchContact, 30);
			driver.findElement(searchContact).click();
			String contactName = TestBase.prop.getProperty("InviteContact");
			genericHelper.enter_Text(driver, searchContact, contactName );
			logger.info("Entered contact to search");
		}
		else {
		waitHelper.waitForElementVisible(searchContact, 5);
		driver.findElement(searchContact).click();
		String contactName = TestBase.prop.getProperty("InviteContact");
		genericHelper.enter_Text(driver, searchContact, contactName );
		logger.info("Entered contact to search");
		}
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
	
	public void clickOnGetContacts() {
		waitHelper.waitForElementVisible(getContacts, 5);
		driver.findElement(getContacts).click();
		logger.info("Clicked on Get Contacts button");
	}
	
	
	public boolean isContactPermissionGiven() {
		try {
			driver.findElement(getContacts);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
}
