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

public class SendTextMessageToAdmin extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;
	public GenericHelper genericHelper;
	public DiscoverPage discover;
	public ChannelProfile channelProfile;
	public LeftDrawer leftDrawer;
	public SelfProfile selfProfile;
	public ChannelsYouFollow channelsYouFollow;
	
	@Test(dataProvider = "Followers channel")
	public void SendTextMessageToAdmin(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
				
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		myChat.openSearchedChannel(channelName);
		driver.navigate().back();
		channelDashboard.clickOnNewMessageButtonForFollower();
		
		channelChatWindow.sendTextMessageToAdmin();
		channelChatWindow.clickOnsendMessageButton();	
		

	/*	navigateToFollowersChannel(driver);
		String expectedMessage = prop.getProperty("TextMessageToAdmin");
		String actualMessage = channelChatWindow.getLatestMessage();
		VerificationHelper.verifyText(expectedMessage, actualMessage);*/
	}
	
	@Test(dataProvider = "Followers channel")
	public void sendTextMessageFromUserProfile(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelProfile = new ChannelProfile(driver);
		leftDrawer = new LeftDrawer(driver);
		genericHelper = new GenericHelper(driver);
		channelsYouFollow = new ChannelsYouFollow(driver);
		selfProfile = new SelfProfile(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		channelDashboard = new ChannelDashboard(driver);
		
		myChat.clickonLeftdrawerButton();
		leftDrawer.clickonUserProfileImage();
		genericHelper.scrollByCount(driver, 2);
		
		boolean flag = selfProfile.isMoreThanFiveChannels();
		if(flag) {
			selfProfile.clickViewAllButton();
			Thread.sleep(2000);
			channelsYouFollow.clickOnChannelName(channelName);
			channelsYouFollow.clickOnSendMessage();
			
			channelDashboard.clickOnNewMessageButtonForFollower();
			channelChatWindow.sendTextMessageToAdmin();
			channelChatWindow.clickOnsendMessageButton();	
			
		}
	}
	
	@DataProvider(name = "Followers channel")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("FollowersChannel") },
	    };
	  }
	
}
