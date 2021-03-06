package com.kisan.kisannet.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.ChannelProfile;
import com.kisan.kisannet.pagelibrary.CreateChannelPage;
import com.kisan.kisannet.pagelibrary.EditChannelProfilePage;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.pagelibrary.MyInterests;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class EditChannelProfile extends TestBase {
	
	public MyChat myChat;
	public ChannelDashboard channelDashboard;
	public ChannelProfile channelProfile;
	public EditChannelProfilePage editChannelProfilePage;
	public MyInterests myInterests;
	public CreateChannelPage createChannelPage;
	
	@Test(dataProvider = "ChannelToBeEdited")
	public void editChannelProfile(String channelName) throws Exception {
		myChat = new MyChat(driver);
		channelDashboard = new ChannelDashboard(driver);
		channelProfile = new ChannelProfile(driver);
		editChannelProfilePage = new EditChannelProfilePage(driver);
		myInterests = new MyInterests(driver);
		createChannelPage = new CreateChannelPage(driver);
		
		//Navigate to admins channel
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		myChat.searchChannel(channelName);
		//myChat.searchChannelToEdit();
		//myChat.clickOnSearchedChannel();
		myChat.openSearchedChannel(channelName);
		
		channelDashboard.clickOnChannelName();
		channelProfile.clickOnRightDrawer();
		channelProfile.clickOnEditProfileOption();
		
		driver.navigate().back();
		//edit channel image
		editChannelProfilePage.clickonChannelProfileImage();
		editChannelProfilePage.clickTakeAPictureButton();
		alertHelper.AcceptPermissions();
		Thread.sleep(2000);
		editChannelProfilePage.clickShutterButton();
		editChannelProfilePage.clickOnYesButtonAfterCapturingMedia();
		editChannelProfilePage.clickOnconfirmUploadProfileImage();
		
		//Edit channel name
		editChannelProfilePage.clearChannelNameField();
		editChannelProfilePage.enterChannelName();	
		
		//edit channel description
		driver.navigate().back();
		editChannelProfilePage.clearChannelDescriptionField();
		editChannelProfilePage.enterChannelDescription();
		
		driver.navigate().back();
		Thread.sleep(2000);
		//edit channel categories
		editChannelProfilePage.clickAddMore();
		myInterests.selectCategories();
		myInterests.clickDoneButton();
		
		//edit channel color
		createChannelPage.SelectBackgroundColor();
		createChannelPage.SetBackgroundColor();
		createChannelPage.ClickOkOnColorPalette();
		
		editChannelProfilePage.clickDoneButton();
		
		//verifying changes
		myChat.clickOnRightDrawerMenu();
		myChat.clickOnSearchChannelOption();
		Boolean flag = myChat.searchEditedChannel();
		if(flag==true) {
			logger.info("Edit profile successfull");
		}
		else {
			Assert.assertTrue(false, "Edit profile is not sucessful");
		}
	}
	
	@DataProvider(name = "ChannelToBeEdited")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { TestBase.prop.getProperty("ChannelToBeEdited") },
	    };
	  }
}
