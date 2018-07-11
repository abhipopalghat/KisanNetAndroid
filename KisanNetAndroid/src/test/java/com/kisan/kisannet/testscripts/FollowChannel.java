package com.kisan.kisannet.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelProfile;
import com.kisan.kisannet.pagelibrary.DiscoverPage;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class FollowChannel extends TestBase{

	public MyChat myChat;
	public DiscoverPage discover;
	public ChannelProfile channelProfile;
	public ChannelChatWindow channelChatWindow;
	
	@Test(dataProvider = "ChannelToBeFollowedFromDiscover")
	public void followChannelFormDiscover(String channelName) throws Exception {
		myChat = new MyChat(driver);
		discover = new DiscoverPage(driver);
		
		myChat.clickonDiscoverIcon();
		discover.clickOnSearchBox();
		discover.searchChannel(channelName);
		driver.navigate().back();
		discover.followChannel();
		navigateToMyChat();
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		
	}
	
	@Test(dataProvider= "ChannelToBeFollowedFromProfile")
	public void followChannelFormChannelProfile(String channelName) throws Exception {
		myChat = new MyChat(driver);
		discover = new DiscoverPage(driver);
		channelProfile = new ChannelProfile(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		
		myChat.clickonDiscoverIcon();
		discover.clickOnSearchBox();
		discover.searchChannel(channelName);
		driver.navigate().back();
		discover.openChannelProfile();
		channelProfile.clickOnFollowButton();
		String channelFollowed = channelChatWindow.getChannelName();
		if(channelFollowed.equalsIgnoreCase(channelName)) {
			System.out.println("Channel followed successfully");
		}
		else {
			System.out.println("Channel not followed");
		}
	}
	
	
	
	@DataProvider(name = "ChannelToBeFollowedFromProfile")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("ChannelToBeFollowedFromProfile") },
	    };
	  }
	
	@DataProvider(name = "ChannelToBeFollowedFromDiscover")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("ChannelToBeFollowedFromDiscover") },
	    };
	  }
}
