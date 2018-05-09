package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class SendImageToFollowers extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;
	
	@Test
	public void sendImageToFollower() throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		
		navigateToAdminsChannel(driver);
		
		channelChatWindow.clickOnAttachmentPin();
		channelChatWindow.clickOnCameraOption();
		channelChatWindow.clickOnTakeAPicture();
		channelChatWindow.clickOnShutterButton();
		channelChatWindow.clickOnYesButtonAfterCapturingMedia();
		channelChatWindow.writeACaption();
		channelChatWindow.clickOnSendMediaButton();
	
		navigateToAdminsChannel(driver);
		String expectedCaption = prop.getProperty("WriteACaption");
		String actualCaption = channelChatWindow.getLatestCaption();
		VerificationHelper.verifyText(expectedCaption, actualCaption);
		
	}
}
