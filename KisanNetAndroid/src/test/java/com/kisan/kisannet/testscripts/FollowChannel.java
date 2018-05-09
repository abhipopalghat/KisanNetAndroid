package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.DiscoverPage;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class FollowChannel extends TestBase{

	public MyChat myChat;
	public DiscoverPage discover;
	
	@Test
	public void followChannelFormDiscover() throws Exception {
		myChat = new MyChat(driver);
		discover = new DiscoverPage(driver);
		
		myChat.clickonDiscoverIcon();
		discover.searchChannel();
		discover.followChannel();
	}
	
}
