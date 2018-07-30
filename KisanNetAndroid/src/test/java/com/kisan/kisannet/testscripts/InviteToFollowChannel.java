package com.kisan.kisannet.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.ChannelProfile;
import com.kisan.kisannet.pagelibrary.InviteManually;
import com.kisan.kisannet.pagelibrary.InvitePeople;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class InviteToFollowChannel extends TestBase {

	MyChat myChat;
	ChannelDashboard channelDashboard;
	ChannelProfile channelProfile;
	InvitePeople invitePeople;
	InviteManually inviteManually;

	@BeforeMethod
	public void initializePages() {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelProfile = new ChannelProfile(driver);
		invitePeople = new InvitePeople(driver);
		inviteManually = new InviteManually(driver);
	}
	
	@Test(dataProvider = "Contact Invite")
	public void inviteToFollowChannelByContactName(String channelName) throws Exception {
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		myChat.openSearchedChannel(channelName);
		
		channelDashboard.clickOnChannelName();
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnInviteOption();
		alertHelper.AcceptPermissions();
		invitePeople.enterContactName();
		driver.navigate().back();
		invitePeople.selectSearchedContactToInviteChannel();
		invitePeople.clickOnDoneButton();
	}
	
	@Test(dataProvider = "Manual Invite")
	public void inviteToFollowChannelManually(String channelName) throws Exception {
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		myChat.openSearchedChannel(channelName);
		
		channelDashboard.clickOnChannelName();
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnInviteOption();
		invitePeople.clickOnEnterNumberField();
		inviteManually.enterMobileNumberManually();
		inviteManually.clickInvite();
	}
	
	@DataProvider(name = "Manual Invite")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("AdminsChannel") },
	    };
	  }
	
	@DataProvider(name = "Contact Invite")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("AdminsChannel") },
	    };
	  }
}
