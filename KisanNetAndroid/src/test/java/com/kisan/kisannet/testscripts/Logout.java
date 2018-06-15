package com.kisan.kisannet.testscripts;

import org.testng.annotations.Test;

import com.kisan.kisannet.pagelibrary.LeftDrawer;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.testBase.TestBase;

public class Logout extends TestBase {

	MyChat myChat;
	LeftDrawer leftDrawer;
	
	@Test
	public void logout() throws Exception{
		myChat = new MyChat(driver);
		leftDrawer = new LeftDrawer(driver);
		
		myChat.clickonLeftdrawerButton();
		leftDrawer.clickonLogout();
		leftDrawer.clickonLogoutNoButton();
		//leftDrawer.clickonLogoutYesButton();
	}
}
