package com.kisan.kisannet.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
import com.kisan.kisannet.pagelibrary.ChannelChatWindow;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class SendLocationToFollowers extends TestBase{

	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelChatWindow channelChatWindow;
	
	@Test()
	public void sendLocationToFollower() throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelChatWindow = new ChannelChatWindow(driver);
		WebElement sentLocation;
		
		navigateToAdminsChannel(driver);
		
		channelChatWindow.clickOnAttachmentPin();
		channelChatWindow.clickOnLocationOption();
		alertHelper.AcceptPermissions();
		channelChatWindow.clickOnCurrentLocation();
		channelChatWindow.clickOnSendLocation();
		
		/*navigateToAdminsChannel(driver);
		sentLocation = channelChatWindow.isLocationSent();
		VerificationHelper.verifyElementPresent(sentLocation);*/
	}
}
