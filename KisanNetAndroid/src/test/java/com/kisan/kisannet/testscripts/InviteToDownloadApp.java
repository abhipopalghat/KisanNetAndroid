package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.InviteManually;
import com.kisan.kisannet.pagelibrary.InvitePeople;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class InviteToDownloadApp extends TestBase {

	MyChat myChat;
	InvitePeople invitePeople;
	InviteManually inviteManually;
	
	@Test()
	public void inviteToDownloadAppByContactName() throws Exception {
		myChat = new MyChat(driver);
		invitePeople = new InvitePeople(driver);
		inviteManually = new InviteManually(driver);
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnInviteToKisanOption();
		//alertHelper.AcceptPermissions();
		
		invitePeople.enterContactName();
		driver.navigate().back();
		invitePeople.selectSearchedContactToDownloadApp();
		invitePeople.clickOnInviteButton();
	}
	
	@Test()
	public void inviteToDownloadAppManually() throws Exception{
		myChat = new MyChat(driver);
		invitePeople = new InvitePeople(driver);
		inviteManually = new InviteManually(driver);
		
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnInviteToKisanOption();
		invitePeople.clickOnEnterNumberField();
		inviteManually.enterMobileNumberManually();
		inviteManually.clickInvite();
	}
}
