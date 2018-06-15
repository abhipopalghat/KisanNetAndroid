package com.kisan.kisannet.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class CreateChannelPage {

	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(CreateChannelPage.class);
	WaitHelper waitHelper;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By nextButton = By.id("com.kisan.samvaad.test:id/action_next");
	public By startYourChannelButton =  By.id("com.kisan.samvaad.test:id/textview_start_channel");
	public By imageUpload = By.id("com.kisan.samvaad.test:id/imageViewProfilePicture");
	public By channelName = By.id("com.kisan.samvaad.test:id/editTextGroupName");
	public By colorBucket = By.id("com.kisan.samvaad.test:id/buttonEditChannelBackgroundColor");
	public By colorBucketCode = By.id("com.kisan.samvaad.test:id/kisan_viewSatBri");
	public By colorBucketOkBtn = By.id("android:id/button1");
	public By colrBucketCancelBtn = By.id("android:id/button2");
	public By takeAPicture = By.id("com.kisan.samvaad.test:id/textViewOptionOne");
	public By chooseFromGallery = By.id("com.kisan.samvaad.test:id/textViewOptionTwo");
	public By cancelImage = By.xpath("//android.widget.TextView[@text='Cancel']");
	
	public CreateChannelPage(AndroidDriver<?> driver) {
		this.driver=driver;
		waitHelper = new WaitHelper(driver);
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
		waitHelper.waitForElementVisible(colorBucket, 10);
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
}
