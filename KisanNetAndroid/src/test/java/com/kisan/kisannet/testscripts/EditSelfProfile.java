package com.kisan.kisannet.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.pagelibrary.EditSelfProfilePage;
import com.kisan.kisannet.pagelibrary.LeftDrawer;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.pagelibrary.MyInterests;
import com.kisan.kisannet.pagelibrary.SelfProfile;
import com.kisan.kisannet.testBase.TestBase;

public class EditSelfProfile extends TestBase{

	public MyChat myChat;
	public LeftDrawer leftDrawer;
	public SelfProfile selfProfile;
	public EditSelfProfilePage editProfilePage;
	public MyInterests myInterests;
	
	@Test()
	public void editSelfProfile() throws Exception {
		myChat = new MyChat(driver);
		leftDrawer = new LeftDrawer(driver);
		selfProfile= new SelfProfile(driver); 
		editProfilePage = new EditSelfProfilePage(driver);
		myInterests = new MyInterests(driver);
		
		myChat.clickonLeftdrawerButton();
		
		//Capture profile picture
		leftDrawer.clickonUserProfileImage();
		selfProfile.clickEditProfileButton();
		editProfilePage.clickonUserProfileImage();
		editProfilePage.clickTakeAPictureButton();
		alertHelper.AcceptPermissions();
		//Thread.sleep(2000);
		editProfilePage.clickShutterButton();
		editProfilePage.clickOnYesButtonAfterCapturingMedia();
		editProfilePage.clickOnconfirmUploadProfileImage();
		
		// Enter first name and last name
		editProfilePage.clearFirstNameField();
		editProfilePage.enterFirstName();
		editProfilePage.clearLastNameField();
		editProfilePage.enterLastName();
		driver.navigate().back();
		
		//Enter about you
		editProfilePage.clearAboutYouField();
		editProfilePage.enterAboutYou();
		driver.navigate().back();
		
		//Change interests
		editProfilePage.clickAddMore();
		myInterests.selectCategories();
		myInterests.clickNextButton();
		
		//Complete the updating profile
		editProfilePage.clickDoneButton();
		
		//Verify the changes
		navigateToMyChat();
		myChat.clickonLeftdrawerButton();
		Boolean flag = leftDrawer.compareEditedUserName();
		if(flag==true) {
			logger.info("Edit profile successfull");
		}
		else {
			Assert.assertTrue(false, "Edit profile is not sucessful");
		}
	}
	
	
}
