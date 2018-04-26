package com.kisan.kisannet.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.pagelibrary.LeftDrawer;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.pagelibrary.SelectLanguage;
import com.kisan.kisannet.testBase.TestBase;

public class ChangeLanguage extends TestBase {
	
	public MyChat myChat;
	public LeftDrawer leftDrawer;
	public SelectLanguage selectLanguage;

		
	@Test 
	public void changeLanguage() throws Exception {
		myChat = new MyChat(driver);
		leftDrawer = new LeftDrawer(driver);
		selectLanguage = new SelectLanguage(driver);
		
		myChat.clickonLeftdrawerButton();
		leftDrawer.clickonLanguage();
		String language = selectLanguage.clickMarathi();
		logger.info("Clicked on "+language+"Language");
		boolean status = leftDrawer.verifyAppLanguge(prop.getProperty("ChangeLanguage"));
		driver.navigate().back();
		if(status) {
			logger.info("Language changed succesfully");
		}
		else {
			Assert.assertEquals(false, "Language is not changed succesfully");
		}
				
	}
	
}
