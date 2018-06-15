package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
import com.kisan.kisannet.pagelibrary.Categories;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.CreateChannelPage;
import com.kisan.kisannet.pagelibrary.EnterChannelInfo;
import com.kisan.kisannet.pagelibrary.InviteManually;
import com.kisan.kisannet.pagelibrary.LeftDrawer;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.pagelibrary.SelectContact;
import com.kisan.kisannet.testBase.TestBase;

public class CreateChannel extends TestBase {
	
	public MyChat myChat;
	public LeftDrawer leftDrawer;
	public CreateChannelPage createChannel;
	public EnterChannelInfo channelInfo;
	public Categories categories;
	public SelectContact selectContact;
	public InviteManually inviteManually;
	public ChannelDashboard channelDashboard;

	@Test
	
	public void createPublicChannel() throws Exception {
		myChat = new MyChat(driver);
		leftDrawer = new LeftDrawer(driver);
		createChannel = new CreateChannelPage(driver);
		channelInfo = new EnterChannelInfo(driver);
		categories = new Categories(driver);
		selectContact = new SelectContact(driver);
		inviteManually = new InviteManually(driver);
		channelDashboard = new ChannelDashboard(driver);
		
		myChat.clickonLeftdrawerButton();
		leftDrawer.clickonstartYourChannel();
		createChannel.clickStartYourChannelButton();
		createChannel.enterChannelName();
		driver.navigate().back();
		createChannel.SelectBackgroundColor();
		createChannel.SetBackgroundColor();
		createChannel.ClickOkOnColorPalette();
		createChannel.clickNext();
		channelInfo.enterDescription();
		channelInfo.clickNext();
		categories.selectAnimalHusbandryCategory();
		categories.selectAgricultureCategory();
		categories.selectHorticultureCategory();
		categories.clickNext();
		//selectContact.clickEnterNumber();
		//inviteManually.enterMobileNumberManually();
		//inviteManually.clickInvite();
		//selectContact.searchContact();   // Uncomment when invite functionality is done
		//driver.navigate().back();
		//selectContact.SelectCheckBox();
		selectContact.clickDone();
		
		String createdChannel = prop.getProperty("ChannelNameToBeCreated");
		String actualChannel = channelDashboard.getChannelName();
		VerificationHelper.verifyText(createdChannel, actualChannel);
	}
	
}
