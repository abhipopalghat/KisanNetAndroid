package com.kisan.kisannet.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
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

public class SendTextMessageToFollowers extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;
	public DiscoverPage discover;
	public ChannelProfile channelProfile;
	public LeftDrawer leftDrawer;
	public GenericHelper genericHelper;
	public SelfProfile selfProfile;
	public ChannelsYouFollow channelsYouFollow;
	
	
	/*@Test(dataProvider = "Admins channel")
	public void sendTextMessageToFollower(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		
		//navigateToAdminsChannel(driver);
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		//myChat.clickOnSearchedChannel();
		myChat.openSearchedChannel(channelName);
		//driver.navigate().back();
		channelDashboard.clickOnNewMessageButtonForAdmin();
		
		channelChatWindow.sendTextMessageToFollowers();
		channelChatWindow.clickOnsendMessageButton();
		
		navigateToAdminsChannel(driver);
		String expectedMessage = prop.getProperty("TextMessageToFollowers");
		String actualMessage = channelChatWindow.getLatestMessage();
		System.out.println(expectedMessage);
		System.out.println(actualMessage);
		VerificationHelper.verifyText(expectedMessage, actualMessage);
	}*/
	
	@Test(dataProvider = "Admins channel")
	public void sendTextMessageFromUserProfile(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelProfile = new ChannelProfile(driver);
		leftDrawer = new LeftDrawer(driver);
		genericHelper = new GenericHelper(driver);
		channelsYouFollow = new ChannelsYouFollow(driver);
		selfProfile = new SelfProfile(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		myChat.clickonLeftdrawerButton();
		leftDrawer.clickonUserProfileImage();
		genericHelper.scrollByCount(driver, 2);
		
		boolean flag = selfProfile.isMoreThanFiveChannels();
		if(flag) {
			selfProfile.clickViewAllButton();
			Thread.sleep(2000);
			channelsYouFollow.clickOnChannelName(channelName);
			channelsYouFollow.clickOnSendMessage();
			//channelDashboard.clickOnNewMessageButtonForAdmin();
			channelChatWindow.sendTextMessageToFollowers();
			channelChatWindow.clickOnsendMessageButton();
		}
		
	}
	
	@DataProvider(name = "Admins channel")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("AdminsChannel") },
	    };
	  }
}
