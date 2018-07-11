package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelProfile;
import com.kisan.kisannet.pagelibrary.DiscoverPage;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class UnfollowChannel extends TestBase{

	public MyChat myChat;
	public DiscoverPage discover;
	public ChannelProfile channelProfile;
	public ChannelChatWindow channelChatWindow;
	
	
	@Test(dataProvider = "ChannelToBeUnFollowed")
	public void unFollowChannel(String channelName) throws Exception {
		myChat = new MyChat(driver);
		discover = new DiscoverPage(driver);
		channelProfile = new ChannelProfile(driver);
		
		myChat.clickonDiscoverIcon();
		discover.clickOnSearchBox();
		discover.searchChannel(channelName);
		driver.navigate().back();
		discover.openChannelProfile();
		
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnLeaveChannelOption();
		
	}
}
