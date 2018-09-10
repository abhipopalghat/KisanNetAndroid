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

public class EditChannelProfilePage {

	public AndroidDriver<?> driver;
	public WaitHelper waitHelper;
	public GenericHelper genericHelper;
	private final Logger logger = LoggerHelper.getLogger(ChannelProfile.class);
	public Devices device;
	
	By channelName = By.id("com.kisan.samvaad.dev:id/editTextCommunityName");
	By channelProfileImage = By.id("com.kisan.samvaad.dev:id/imageViewProfilePicture");
	By aboutThisChannel = By.id("com.kisan.samvaad.dev:id/editTextCommunityDesc");
	By addMore = By.id("com.kisan.samvaad.dev:id/textViewAddMore");
	By takeAPicture = By.id("com.kisan.samvaad.dev:id/textViewOptionOne");
	By chooseFromGallery = By.id("com.kisan.samvaad.dev:id/textViewOptionTwo");
	By cancelImage = By.xpath("//android.widget.TextView[@text='Cancel']");
	By shutter = By.xpath("//android.widget.ImageView[@content-desc='Shutter button']");
	public By yesAfterCapturingPhoto_lenovo = By.id("com.android.camera2:id/done_button");
	public By yesAfterCapturingPhoto_redmi = By.id("com.android.camera:id/v6_btn_done");
	By confirmUploadProfileImage = By.id("com.kisan.samvaad.dev:id/imageButtonCrop");
	By doneButton = By.id("com.kisan.samvaad.dev:id/action_done");
	By backArrow = By.xpath("//android.widget.ImageButton[@instance='0']");
	
	public EditChannelProfilePage(AndroidDriver<?> driver) {
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
	
	public void clearChannelNameField() throws Exception {
		waitHelper.waitForElementVisible(channelName, 30);
		waitHelper.waitForElementClickable(driver, 15, channelName);	
		driver.findElement(channelName).click();
		Thread.sleep(2000);
		driver.findElement(channelName).clear();
		logger.info("Cleared channel name field");
	}
	
	public void enterChannelName() throws Exception {
		String fName = TestBase.prop.getProperty("EditedChannelName");
		//GenericHelper genericHelper = new GenericHelper();
		genericHelper.enter_Text(driver, channelName, fName);
		logger.info("Edited channel name");
	}
	
	public void clickonChannelProfileImage() throws Exception {
		waitHelper.waitForElementClickable(driver, 15, channelProfileImage);
		logger.info("Clicking on user profile image");
		driver.findElement(channelProfileImage).click();
	}
	
	public void clickTakeAPictureButton() throws Exception {
		Thread.sleep(3000);
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
		
		/*Thread.sleep(2000);
		waitHelper.waitForElementVisible(shutter, 15);
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
	
	public void clearChannelDescriptionField() throws Exception {
		//Thread.sleep(5000);
		waitHelper.waitForElementClickable(driver, 15, aboutThisChannel);	
		driver.findElement(aboutThisChannel).click();
		Thread.sleep(2000);
		driver.findElement(aboutThisChannel).clear();
		logger.info("Cleared channel description");
	}
	
	public void enterChannelDescription() throws Exception {
		String aboutYouDescription = TestBase.prop.getProperty("EditedChannelDescription");
		//GenericHelper genericHelper = new GenericHelper();
		genericHelper.enter_Text(driver, aboutThisChannel, aboutYouDescription);
		logger.info("Edited channel description");
	}
	
	public void clickAddMore() {
		waitHelper.waitForElementVisible(addMore, 5);
		driver.findElement(addMore).click();
		logger.info("Clicked on add more button");
	}
}
