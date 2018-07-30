package com.kisan.kisannet.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisan.kisannet.helper.genericHelper.GenericHelper;
import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.ChannelProfile;
import com.kisan.kisannet.pagelibrary.ChannelsYouFollow;
import com.kisan.kisannet.pagelibrary.DiscoverPage;
import com.kisan.kisannet.pagelibrary.LeftDrawer;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.pagelibrary.SelfProfile;
import com.kisan.kisannet.testBase.TestBase;

public class UnfollowChannel extends TestBase{

	public MyChat myChat;
	public DiscoverPage discover;
	public ChannelProfile channelProfile;
	public ChannelChatWindow channelChatWindow;
	public ChannelDashboard channelDashboard;
	public LeftDrawer leftDrawer;
	public GenericHelper genericHelper;
	public SelfProfile selfProfile;
	public ChannelsYouFollow channelsYouFollow;
	

	
	@Test(dataProvider = "ChannelToBeUnFollowedFromDiscover")
	public void unFollowChannelFromDiscover(String channelName) throws Exception {
		myChat = new MyChat(driver);
		discover = new DiscoverPage(driver);
		channelProfile = new ChannelProfile(driver);
		
		myChat.clickonDiscoverIcon();
		discover.clickOnSearchBox();
		discover.searchChannel(channelName);
		driver.navigate().back();
		//discover.openChannelProfile();
		discover.openChannelProfileToUnfollow(channelName);
		
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnLeaveChannelOption();
		channelProfile.clickOnYesOnUnfollow();
		
		//verify that channel is unfollowed
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		boolean flag = myChat.isChannelUnfollowed();
		if(flag==true) {
			logger.info("Channel is unfollowed successfully");
			driver.navigate().back();
			driver.navigate().back();
		}
		else {
			Assert.assertTrue(false, "Channel is not unfollowed successfully");
		}
		
	}
	
	@Test(dataProvider = "ChannelToBeUnFollowedFromMyChat")
	public void unFollowChannelFromMyChat(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelProfile = new ChannelProfile(driver);
		channelDashboard = new ChannelDashboard(driver);
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		//myChat.clickOnSearchedChannel();
		myChat.openSearchedChannel(channelName);
		
		channelDashboard.clickOnChannelName();
		
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnLeaveChannelOption();
		channelProfile.clickOnYesOnUnfollow();
		
		//verify that channel is unfollowed
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		boolean flag = myChat.isChannelUnfollowed();
		if(flag==true) {
			logger.info("Channel is unfollowed successfully");
			driver.navigate().back();
			driver.navigate().back();
		}
		else {
			Assert.assertTrue(false, "Channel is not unfollowed successfully");
		}
		
	}
	
	
	@Test(dataProvider = "ChannelToBeUnFollowedFromUserProfile")
	public void unFollowChannelFromUserProfile(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelProfile = new ChannelProfile(driver);
		leftDrawer = new LeftDrawer(driver);
		genericHelper = new GenericHelper(driver);
		channelsYouFollow = new ChannelsYouFollow(driver);
		selfProfile = new SelfProfile(driver);
		
		myChat.clickonLeftdrawerButton();
		leftDrawer.clickonUserProfileImage();
		genericHelper.scrollByCount(driver, 2);
		
		boolean flag = selfProfile.isMoreThanFiveChannels();
		if(flag) {
			selfProfile.clickViewAllButton();
			channelsYouFollow.clickOnChannelName(channelName);
			channelsYouFollow.clickOnLeaveChannel();
			channelsYouFollow.clickOnYesOnUnfollow();
		}
		
		
		//verify that channel is unfollowed
		/*myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		boolean flag = myChat.isChannelUnfollowed();
		if(flag==true) {
			logger.info("Channel is unfollowed successfully");
			driver.navigate().back();
			driver.navigate().back();
		}
		else {
			Assert.assertTrue(false, "Channel is not unfollowed successfully");
		}*/
		
	}
	
	
	@DataProvider(name = "ChannelToBeUnFollowedFromMyChat")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("ChannelToBeUnFollowedFromMyChat") },
	    };
	  }
	
	@DataProvider(name = "ChannelToBeUnFollowedFromDiscover")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("ChannelToBeUnFollowedFromDiscover") },
	    };
	  }
	
	@DataProvider(name = "ChannelToBeUnFollowedFromUserProfile")
	  public Object[][] dp2() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("ChannelToBeUnFollowedFromUserProfile") },
	    };
	  }
}
