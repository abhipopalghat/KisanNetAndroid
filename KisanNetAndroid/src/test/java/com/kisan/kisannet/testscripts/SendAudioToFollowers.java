package com.kisan.kisannet.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.MobileElement;

public class SendAudioToFollowers extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;


	@Test
	public void sendImageToFollower() throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		WebElement audioIcon; 
		
		navigateToAdminsChannel(driver);
		
		channelChatWindow.clickOnAttachmentPin();
		channelChatWindow.clickOnAudioOption();
		channelChatWindow.clickOnRecordAudio();
		channelChatWindow.clickOnStartRecording();
		Thread.sleep(7);
		channelChatWindow.clickOnStopRecording();
		channelChatWindow.clickOnSendAudio();	
		
		navigateToAdminsChannel(driver);
		audioIcon=channelChatWindow.isAudioDelivered();
		VerificationHelper.verifyElementPresent(audioIcon);
	}
}
