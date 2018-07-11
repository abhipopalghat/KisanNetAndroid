package com.kisan.kisannet.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;
import com.kisan.kisannet.testBase.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyInterests {
	public AndroidDriver<?> driver;
	public Logger logger = LoggerHelper.getLogger(MyInterests.class);
	public WaitHelper waitHelper;
	
	public By backArrow = By.className("android.widget.ImageButton");
	public By nextButton = By.id("com.kisan.samvaad.test:id/action_next");
	public By categories = By.className("android.widget.CheckBox");
	public By doneButton = By.id("com.kisan.samvaad.test:id/action_done");

	public MyInterests(AndroidDriver<?> driver) {
		this.driver= driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickBackArrow() {
		waitHelper.waitForElementVisible(backArrow, 5);
		driver.findElement(backArrow).click();
		logger.info("Clicked back arrow");
	}
	
	public void clickNextButton() {
		waitHelper.waitForElementVisible(nextButton, 5);
		driver.findElement(nextButton).click();
		logger.info("Clicked next button");
	}
	
	public void clickDoneButton() {
		waitHelper.waitForElementVisible(doneButton, 5);
		driver.findElement(doneButton).click();
		logger.info("Clicked done button");
	}
	
	public void selectCategories() {
		List<AndroidElement> catetories = (List<AndroidElement>)driver.findElements(categories);
		/*System.out.println(catetories.get(0).isSelected());
		System.out.println(catetories.get(3).isSelected());*/
		for(int i=0;i<5;i++) {
			catetories.get(i).click();
		}
		for(int i=0;i<5;i++) {
			catetories.get(i).click();
		}
	}

}
