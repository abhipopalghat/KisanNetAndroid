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

public class SendImageToAdmin extends TestBase {

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;
	public DiscoverPage discover;
	public ChannelProfile channelProfile;
	public LeftDrawer leftDrawer;
	public GenericHelper genericHelper;
	public SelfProfile selfProfile;
	public ChannelsYouFollow channelsYouFollow;
	
	@Test(dataProvider = "Followers channel")
	public void sendImageToAdmin(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		//myChat.clickOnSearchedChannel();
		myChat.openSearchedChannel(channelName);
		driver.navigate().back();
		channelDashboard.clickOnNewMessageButtonForFollower();
		
		channelChatWindow.clickOnAttachmentPin();
		channelChatWindow.clickOnCameraOption();
		channelChatWindow.clickOnTakeAPicture();
		alertHelper.AcceptPermissions();
		channelChatWindow.clickOnShutterButton();
		channelChatWindow.clickOnYesButtonAfterCapturingMedia();
		channelChatWindow.writeACaption();
		channelChatWindow.clickOnSendMediaButton();
		
		/*navigateToFollowersChannel(driver);
		String expectedCaption = prop.getProperty("WriteACaption");
		String actualCaption = channelChatWindow.getLatestCaption();
		VerificationHelper.verifyText(expectedCaption, actualCaption);*/
	}
	
	@Test(dataProvider = "Followers channel")
	public void sendImageFromUserProfile(String channelName) throws Exception {
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
			
			channelChatWindow.clickOnAttachmentPin();
			channelChatWindow.clickOnCameraOption();
			channelChatWindow.clickOnTakeAPicture();
			alertHelper.AcceptPermissions();
			channelChatWindow.clickOnShutterButton();
			channelChatWindow.clickOnYesButtonAfterCapturingMedia();
			channelChatWindow.writeACaption();
			channelChatWindow.clickOnSendMediaButton();
		}
	}
	
	@DataProvider(name = "Followers channel")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("FollowersChannel") },
	    };
	  }
}
