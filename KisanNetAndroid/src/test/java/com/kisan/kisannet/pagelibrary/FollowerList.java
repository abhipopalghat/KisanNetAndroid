package com.kisan.kisannet.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.helper.genericHelper.GenericHelper;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FollowerList {

	public AndroidDriver<?> driver;
	public GenericHelper genericHelper;
	public WaitHelper waitHelper;
	protected Logger logger = LoggerHelper.getLogger(FollowerList.class);
	
	By backArrow = By.className("android.widget.ImageButton");
	By followerNames = By.xpath("//android.widget.TextView[@resource-id='com.kisan.samvaad.dev:id/textViewMemberFirstName']");
	By viewProfile = By.xpath("//android.widget.TextView[@index= 0]");
	By removeFollower = By.xpath("//android.widget.TextView[@index= 1]");
	By blockFollower = By.xpath("//android.widget.TextView[@index= 2]");
	By yesButtonOnConfirmation = By.id("android:id/button2");
	By noButtonOnConfirmation = By.id("android:id/button2");
	
	public FollowerList(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper(driver);
	}
	
	public void clickOnBackArrow() {
		waitHelper.waitForElementVisible(backArrow, 5);
		driver.findElement(backArrow).click();
		logger.info("Clicked on back button");
	}
	
	public void longTapOnFollowerName(String followerToClick) throws Exception {
		waitHelper.waitForElementVisible(followerNames, 5);
		List<AndroidElement> followers= (List<AndroidElement>)driver.findElements(followerNames);
		TouchActions action = new TouchActions(driver);
		for(int i=0;i<followers.size();i++) {
			System.out.println(followers.get(i).getText());
			System.out.println(followerToClick);
			if(followers.get(i).getText().equals(followerToClick)) {
				AndroidElement followerName = followers.get(i);
				action.longPress(followerName).build().perform();
				Thread.sleep(2000);
				action.release();
				break;
			}
		}
	}
	
	public void clickOnRemoveFollowerOption() {
		waitHelper.waitForElementVisible(removeFollower, 5);
		driver.findElement(removeFollower).click();
		logger.info("Clicked on remove button");
	}
	
	public void clickOnViewProfileFollowerOption() {
		waitHelper.waitForElementVisible(viewProfile, 5);
		driver.findElement(viewProfile).click();
		logger.info("Clicked on view follower profile button");
	}
	
	public void clickOnBlockFollowerOption() {
		waitHelper.waitForElementVisible(blockFollower, 5);
		driver.findElement(blockFollower).click();
		logger.info("Clicked on block follower button");
	}
	
	public void clickYesOnConfirmationPopup() {
		waitHelper.waitForElementVisible(yesButtonOnConfirmation, 5);
		driver.findElement(yesButtonOnConfirmation).click();
		logger.info("Clicked on yes button on confirmation popup");
	}
	
	public void clickNoOnConfirmationPopup() {
		waitHelper.waitForElementVisible(noButtonOnConfirmation, 5);
		driver.findElement(noButtonOnConfirmation).click();
		logger.info("Clicked on no button on confirmation popup");
	}
	
}
