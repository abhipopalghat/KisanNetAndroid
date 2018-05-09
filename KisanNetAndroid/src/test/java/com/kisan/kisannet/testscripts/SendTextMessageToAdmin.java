package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class SendTextMessageToAdmin extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;
	public GenericHelper genericHelper;
	
	
	@Test
	public void SendTextMessageToAdmin() throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
				
		navigateToFollowersChannel(driver);
		channelChatWindow.sendTextMessageToAdmin();
		channelChatWindow.clickOnsendMessageButton();	
		
		
		navigateToFollowersChannel(driver);
		String expectedMessage = prop.getProperty("TextMessageToAdmin");
		String actualMessage = channelChatWindow.getLatestMessage();
		VerificationHelper.verifyText(expectedMessage, actualMessage);
	}
	
}
