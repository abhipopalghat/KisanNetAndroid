package com.kisan.kisannet.pagelibrary;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.Devices;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class EditSelfProfilePage {
	public AndroidDriver<?> driver;
	public Logger logger = LoggerHelper.getLogger(EditSelfProfilePage.class);
	public WaitHelper waitHelper;
	public GenericHelper genericHelper;
	public Devices device;

	public By backArrow = By.className("android.widget.ImageButton");
	public By userProfileImage = By.id("com.kisan.samvaad.test:id/imageViewProfilePicture");
	public By doneButton = By.id("com.kisan.samvaad.test:id/action_done");
	public By firstName = By.id("com.kisan.samvaad.test:id/editTextFirstName");
	public By lastName = By.id("com.kisan.samvaad.test:id/editTextLastName");
	public By aboutYou = By.id("com.kisan.samvaad.test:id/editTextAboutYou");
	public By addMore = By.id("com.kisan.samvaad.test:id/textViewAddMore");
	public By takeAPicture = By.id("com.kisan.samvaad.test:id/textViewOptionOne");
	public By chooseFromGallery = By.id("com.kisan.samvaad.test:id/textViewOptionTwo");
	public By cancelImage = By.xpath("//android.widget.TextView[@text='Cancel']");
	public By shutter = By.xpath("//android.widget.ImageView[@content-desc='Shutter button']");
	public By yesAfterCapturingPhoto_lenovo = By.id("com.android.camera2:id/done_button");
	public By yesAfterCapturingPhoto_redmi = By.id("com.android.camera:id/v6_btn_done");
	public By confirmUploadProfileImage = By.id("com.kisan.samvaad.test:id/imageButtonCrop");
	
	
	public EditSelfProfilePage(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);
		device = new Devices(driver);
	}
	
	public void clickBackArrow() {
		waitHelper.waitForElementVisible(backArrow, 5);
		driver.findElement(backArrow).click();
		logger.info("Clicked back arrow");
	}
	
	public void clickDoneButton() {
		waitHelper.waitForElementVisible(doneButton, 5);
		driver.findElement(doneButton).click();
		logger.info("Clicked on done button");
	}
	
	public void clickonUserProfileImage() throws Exception {
		waitHelper.waitForElementClickable(driver, 15, userProfileImage);
		logger.info("Clicking on user profile image");
		driver.findElement(userProfileImage).click();
	}
	
	public void clearFirstNameField() throws Exception {
		Thread.sleep(5000);
		waitHelper.waitForElementVisible(firstName, 30);
		//waitHelper.waitForElementClickable(driver, 15, firstName);	
		driver.findElement(firstName).click();
		Thread.sleep(2000);
		driver.findElement(firstName).clear();
		logger.info("Cleared first name field");
	}
	
	public void enterFirstName() throws Exception {
		String fName = TestBase.prop.getProperty("EditedFirstName");
		//GenericHelper genericHelper = new GenericHelper();
		genericHelper.enter_Text(driver, firstName, fName);
		logger.info("Edited first name");
	}
	
	public void clearLastNameField() throws Exception {
		//Thread.sleep(5000);
		waitHelper.waitForElementClickable(driver, 15, lastName);
		driver.findElement(lastName).clear();
		logger.info("Cleared last name field");
	}
	
	public void enterLastName() throws Exception {
		String lName = TestBase.prop.getProperty("EditedLastName");
		//GenericHelper genericHelper = new GenericHelper();
		genericHelper.enter_Text(driver, firstName, lName);
		logger.info("Edited last name");
	}
	
	public void clearAboutYouField() throws Exception {
		waitHelper.waitForElementClickable(driver, 15, aboutYou);
		driver.findElement(aboutYou).clear();
		logger.info("Cleared about you field");
	}
	
	public void enterAboutYou() throws Exception {
		String aboutYouDescription = TestBase.prop.getProperty("AboutYou");
		//GenericHelper genericHelper = new GenericHelper();
		genericHelper.enter_Text(driver, aboutYou, aboutYouDescription);
		logger.info("Edited last name");
	}
	
	public void clickAddMore() {
		waitHelper.waitForElementVisible(addMore, 5);
		driver.findElement(addMore).click();
		logger.info("Clicked on add more button");
	}
	
	public void clickTakeAPictureButton() throws Exception {
		waitHelper.waitForElementVisible(takeAPicture, 10);
		driver.findElement(takeAPicture).click();
		logger.info("Clicked On Take a Picture Button");
		//Thread.sleep(5);
	}
	
	public void clickChooseFromGalleryButton() {
		waitHelper.waitForElementVisible(chooseFromGallery, 10);
		driver.findElement(chooseFromGallery).click();
		logger.info("Clicked On Choose From Gallery Button");
	}
	
	public void clickCancelImageButton() {
		waitHelper.waitForElementVisible(cancelImage, 10);
		driver.findElement(cancelImage).click();
		logger.info("Clicked On Cancel Button on Choose Channel Image Popup");
	}
	
	public void clickShutterButton() throws Exception {
		org.openqa.selenium.Capabilities cap = driver.getCapabilities();
		Map<String, ?> capabilities =  (Map<String, ?>)cap.getCapability("desired");
		String deviceName = (String) capabilities.get("deviceName");
		System.out.println(deviceName);
		device.clickOnShutterButton(deviceName);
		/*waitHelper.waitForElementVisible(shutter, 15);
		driver.findElement(shutter).click();
		logger.info("Captured profile photo");*/
	}
	
	public void clickOnYesButtonAfterCapturingMedia() {
		org.openqa.selenium.Capabilities cap = driver.getCapabilities();
		Map<String, ?> capabilities =  (Map<String, ?>)cap.getCapability("desired");
		String deviceName = (String) capabilities.get("deviceName");
		System.out.println(deviceName);
		device.clickOnYesButton(deviceName);
		/*if(deviceName.equalsIgnoreCase("Redmi")){
			waitHelper.waitForElementVisible(yesAfterCapturingPhoto_redmi, 40);
			driver.findElement(yesAfterCapturingPhoto_redmi).click();
			logger.info("Clicked on yes tickmark after capturing photo");
		}
		else if(deviceName.equalsIgnoreCase("pixelV1")){		
		waitHelper.waitForElementVisible(yesAfterCapturingPhoto_lenovo, 40);
		driver.findElement(yesAfterCapturingPhoto_lenovo).click();
		logger.info("Clicked on yes tickmark after capturing photo");
		}*/
	}
	
	public void clickOnconfirmUploadProfileImage() {
		waitHelper.waitForElementVisible(confirmUploadProfileImage, 40);
		driver.findElement(confirmUploadProfileImage).click();
		waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
		logger.info("Set profile image");
	}
}
