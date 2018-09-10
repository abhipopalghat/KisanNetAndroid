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

public class CreateChannelPage {

	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(CreateChannelPage.class);
	WaitHelper waitHelper;
	public Devices device;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By nextButton = By.id("com.kisan.samvaad.dev:id/action_next");
	public By startYourChannelButton =  By.id("com.kisan.samvaad.dev:id/textview_start_channel");
	public By imageUpload = By.id("com.kisan.samvaad.dev:id/imageViewProfilePicture");
	public By channelName = By.id("com.kisan.samvaad.dev:id/editTextGroupName");
	public By colorBucket = By.id("com.kisan.samvaad.dev:id/buttonEditChannelBackgroundColor");
	public By colorBucketCode = By.id("com.kisan.samvaad.dev:id/kisan_viewSatBri");
	public By colorBucketOkBtn = By.id("android:id/button1");
	public By colrBucketCancelBtn = By.id("android:id/button2");
	public By takeAPicture = By.id("com.kisan.samvaad.dev:id/textViewOptionOne");
	By shutter = By.xpath("//android.widget.ImageView[@content-desc='Shutter button']");
	public By yesAfterCapturingPhoto_lenovo = By.id("com.android.camera2:id/done_button");
	public By yesAfterCapturingPhoto_redmi = By.id("com.android.camera:id/v6_btn_done");
	By confirmUploadProfileImage = By.id("com.kisan.samvaad.dev:id/imageButtonCrop");
	public By chooseFromGallery = By.id("com.kisan.samvaad.dev:id/textViewOptionTwo");
	public By cancelImage = By.xpath("//android.widget.TextView[@text='Cancel']");
	
	public CreateChannelPage(AndroidDriver<?> driver) {
		this.driver=driver;
		waitHelper = new WaitHelper(driver);
		device = new Devices(driver);
	}
		
	public void clickNext() {
		waitHelper.waitForElementVisible(nextButton, 10);
		driver.findElement(nextButton).click();
		logger.info("Clicked on Next Button");
	}
	
	public void clickBack() {
		waitHelper.waitForElementVisible(backArrow, 10);
		driver.findElement(backArrow).click();
		logger.info("Clicked on Back Button");
	}
	
	public void clickStartYourChannelButton() {
		waitHelper.waitForElementVisible(startYourChannelButton, 10);
		driver.findElement(startYourChannelButton).click();
		logger.info("Clicked On Start Your Channel Button");
	}
	
	public void clickUploadImage() {
		waitHelper.waitForElementVisible(imageUpload, 10);
		driver.findElement(imageUpload).click();
		logger.info("Clicked On image upload button");
	}
	
	public void enterChannelName() throws Exception {
		waitHelper.waitForElementVisible(channelName, 5);
		driver.findElement(channelName).click();
		String channelName = TestBase.prop.getProperty("ChannelNameToBeCreated");
		GenericHelper.enter_Text(driver, this.channelName, channelName);
		logger.info("Entered Channel Name");
	}
	
	public void SelectBackgroundColor() {
		waitHelper.waitForElementVisible(colorBucket, 30);
		driver.findElement(colorBucket).click();
		logger.info("Clicked On Select Background Color Button");
	}
	
	public void SetBackgroundColor() {
		waitHelper.waitForElementVisible(colorBucketCode, 10);
		driver.findElement(colorBucketCode).click();
		logger.info("Selected Background Color");
	}
	
	public void ClickOkOnColorPalette() {
		waitHelper.waitForElementVisible(colorBucketOkBtn, 10);
		driver.findElement(colorBucketOkBtn).click();
		logger.info("Clicked On Ok Button on Color Pallete");
	}
	
	public void ClickCancelOnColorPalette() {
		waitHelper.waitForElementVisible(colrBucketCancelBtn, 10);
		driver.findElement(colrBucketCancelBtn).click();
		logger.info("Clicked On Cancel Button on Color Palette");
	}
	
	public void ClickTakeAPictureButton() {
		waitHelper.waitForElementVisible(takeAPicture, 10);
		driver.findElement(takeAPicture).click();
		logger.info("Clicked On Take a Picture Button");
	}
	
	public void ClickChooseFromGalleryButton() {
		waitHelper.waitForElementVisible(chooseFromGallery, 10);
		driver.findElement(chooseFromGallery).click();
		logger.info("Clicked On Choose From Gallery Button");
	}
	
	public void ClickCancelImageButton() {
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
}
