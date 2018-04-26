package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class SendTextMessageToFollowers extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	
	@Test
	public void sendTextMessageTofollower() throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel();
		myChat.clickOnSearchedChannel();
		channelDashboard.clickOnNewMessageButton();
		
	}
	
	
}
