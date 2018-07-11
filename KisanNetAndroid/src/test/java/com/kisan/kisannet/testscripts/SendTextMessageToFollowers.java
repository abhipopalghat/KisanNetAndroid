package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class SendTextMessageToFollowers extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;
	
	@Test(priority = 0)
	public void sendTextMessageToFollower() throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		
		navigateToAdminsChannel(driver);
		channelChatWindow.sendTextMessageToFollowers();
		channelChatWindow.clickOnsendMessageButton();
		
		/*navigateToAdminsChannel(driver);
		String expectedMessage = prop.getProperty("TextMessageToFollowers");
		String actualMessage = channelChatWindow.getLatestMessage();
		System.out.println(expectedMessage);
		System.out.println(actualMessage);
		VerificationHelper.verifyText(expectedMessage, actualMessage);*/
	}
	
	
}
