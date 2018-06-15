package com.kisan.kisannet.testscripts;

import org.testng.annotations.BeforeMethod;
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
	
	@Test
	public void inviteByContactName() throws Exception {
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchAdminsChannel();
		myChat.clickOnSearchedChannel();
		channelDashboard.clickOnChannelName();
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnInviteOption();
		invitePeople.enterContactName();
		driver.navigate().back();
		invitePeople.selectSearchedContactToInviteChannel();
		invitePeople.clickOnDoneButton();
	}
	
	@Test
	public void inviteManually() throws Exception {
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchAdminsChannel();
		myChat.clickOnSearchedChannel();
		channelDashboard.clickOnChannelName();
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnInviteOption();
		invitePeople.clickOnEnterNumberField();
		inviteManually.enterMobileNumberManually();
		inviteManually.clickInvite();
	}
}
