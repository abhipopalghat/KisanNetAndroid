package com.kisan.kisannet.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.ChannelProfile;
import com.kisan.kisannet.pagelibrary.FollowerList;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class BlockFollower extends TestBase{
	
	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelProfile channelProfile;
	public FollowerList followerList;
	
	@Test(dataProvider = "DataToBlockFollower")
	public void blockFollower(String channelName, String followerName) throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelProfile = new ChannelProfile(driver);
		followerList = new FollowerList(driver);
		
		System.out.println(channelName);
		System.out.println(followerName);
		
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		myChat.openSearchedChannel(channelName);
		
		channelDashboard.clickOnChannelName();
		
		channelProfile.clickOnShowFollowersOption();
		
		followerList.longTapOnFollowerName(followerName);
		followerList.clickOnBlockFollowerOption();
		followerList.clickYesOnConfirmationPopup();
		
	}
	
	@DataProvider(name = "DataToBlockFollower")
	public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("AdminsChannel"), TestBase.prop.getProperty("FollowerNameToBeBlocked")},
	
	    };
	  }	
	
	
	

}
