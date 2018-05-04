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

public class ChannelChatWindow {

	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(MyChat.class);
	WaitHelper waitHelper;
	
	public By backArrow = By.xpath("//android.widget.ImageButton[@index='0']");
	public By channelName = By.id("com.kisan.samvaad.test:id/textViewCommunityName");
	public By attachmentPin = By.id("com.kisan.samvaad.test:id/action_attach");
	public By rightDrawer = By.xpath("//android.widget.TextView[@index='1']");
	public By channelProfile= By.xpath("//android.widget.LinearLayout[@index='0']");
	public By Search = By.xpath("//android.widget.LinearLayout[@index='1']");
	public By invite = By.xpath("//android.widget.LinearLayout[@index='2']");
	public By mute = By.xpath("//android.widget.LinearLayout[@index='3']");
	public By camera = By.xpath("//android.widget.LinearLayout[@index='0']");
	public By image = By.xpath("//android.widget.LinearLayout[@index='1']");
	public By video = By.xpath("//android.widget.LinearLayout[@index='2']");
	public By audio = By.xpath("//android.widget.LinearLayout[@index='3']");
	public By location = By.xpath("//android.widget.LinearLayout[@index='4']");
	public By listOfMessages = By.id("com.kisan.samvaad.test:id/listViewMessages");
	public By typeAMessage = By.id("com.kisan.samvaad.test:id/chatmessages_editTextMessageText");
	public By sendMessage = By.id("com.kisan.samvaad.test:id/chatmessages_imageButtonSendMessage");
	public By sendImage = By.id("com.kisan.samvaad.test:id/imageButtonSend");
	public By allMessages = By.id("com.kisan.samvaad.test:id/textViewMessage");
	public By takeAPicture = By.id("com.kisan.samvaad.test:id/textViewOptionOne");
	public By recordAVideo = By.id("com.kisan.samvaad.test:id/textViewOptionTwo");
	public By shutterButton = By.id("com.android.camera2:id/shutter_button");
	public By yesAfterCapturingPhoto = By.id("com.android.camera2:id/done_button");
	public By writeACaption = By.id("com.kisan.samvaad.test:id/editTextMessageTextWithImage");
	public By allCaptions = By.id("com.kisan.samvaad.test:id/textViewMessage");
	
	public ChannelChatWindow(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		
	}
	
	public void sendTextMessageToFollowers() {
		waitHelper.waitForElementVisible(typeAMessage, 5);
		driver.findElement(typeAMessage).click();
		String message = TestBase.prop.getProperty("TextMessageToFollowers");
		GenericHelper.enter_Text(driver, typeAMessage, message);
		logger.info("Typed a message");
	}
	
	public void clickOnsendMessageButton() {
		waitHelper.waitForElementVisible(sendMessage, 10);
		driver.findElement(sendMessage).click();
		logger.info("Clicked On send message button in admins chat window");
	}
	
	public void sendTextMessageToAdmin() {
		waitHelper.waitForElementVisible(typeAMessage, 5);
		driver.findElement(typeAMessage).click();
		String message = TestBase.prop.getProperty("TextMessageToAdmin");
		GenericHelper.enter_Text(driver, typeAMessage, message);
		logger.info("Typed a message");
	}
	
	public String getLatestMessage() {
		List<AndroidElement> messages = (List<AndroidElement>) driver.findElements(allMessages);
		int totalMesasgeCount = messages.size();
		AndroidElement element = messages.get(totalMesasgeCount-1);
		String latestMessage = element.getText();
		return latestMessage;
	}
	
	public void clickOnAttachmentPin() {
		waitHelper.waitForElementVisible(attachmentPin, 20);
		driver.findElement(attachmentPin).click();
		logger.info("Clicked On attachment pin in admins chat window");
	}
	
	public void clickOnCameraOption() {
		waitHelper.waitForElementVisible(camera, 10);
		driver.findElement(camera).click();
		logger.info("Clicked On camera option in admins chat window");
	}
	
	public void clickOnTakeAPicture() {
		waitHelper.waitForElementVisible(takeAPicture, 10);
		driver.findElement(takeAPicture).click();
		logger.info("Clicked On Take a Picture option");
	}
	
	public void clickOnRecordAVideo() {
		waitHelper.waitForElementVisible(recordAVideo, 10);
		driver.findElement(recordAVideo).click();
		logger.info("Clicked On Record a Video option");
	}
	
	public void clickOnShutterButton() {
		waitHelper.waitForElementVisible(shutterButton, 10);
		driver.findElement(shutterButton).click();
		logger.info("Clicked on capture photo");
	}
	
	public void clickOnYesButtonAfterCapturingPhoto() {
		waitHelper.waitForElementVisible(yesAfterCapturingPhoto, 40);
		driver.findElement(yesAfterCapturingPhoto).click();
		logger.info("Clicked on yes tickmark after capturing photo");
	}
	
	public void writeACaptionToCapturedImage() {
		waitHelper.waitForElementVisible(writeACaption, 10);
		driver.findElement(writeACaption).click();
		String message = TestBase.prop.getProperty("WriteACaption");
		GenericHelper.enter_Text(driver, writeACaption, message);
		logger.info("Caption added");
	}
	
	public void clickOnsendImageButton() {
		waitHelper.waitForElementVisible(sendImage, 10);
		driver.findElement(sendImage).click();
		logger.info("Clicked On send image button in admins chat window");
	}
	
	public String getLatestCaption() {
		List<AndroidElement> captions = (List<AndroidElement>) driver.findElements(allCaptions);
		int totalMesasgeCount = captions.size();
		AndroidElement element = captions.get(totalMesasgeCount-1);
		String latestCaption = element.getText();
		return latestCaption;
	}
}
