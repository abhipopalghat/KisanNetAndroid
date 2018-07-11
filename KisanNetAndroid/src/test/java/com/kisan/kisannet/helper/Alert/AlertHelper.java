
package com.kisan.kisannet.helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.kisan.kisannet.helper.Logger.LoggerHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AlertHelper{
	
	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(AndroidDriver<?> driver) {
		this.driver = driver;
		oLog.debug("AlertHelper : " + this.driver.hashCode());
	}
	
	public Alert getAlert() {
		oLog.debug("");
		return driver.switchTo().alert();
	}
	
	public void AcceptAlert() {
		oLog.info("");
		getAlert().accept();
	}
	
	public void DismissAlert() {
		oLog.info("");
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();
		oLog.info(text);
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			oLog.info("true");
			return true;
		} catch (NoAlertPresentException e) {
			// Ignore
			oLog.info("false");
			return false;
		}
	}

	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		AcceptAlert();
		oLog.info("");
	}

	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();
		oLog.info("");
	}
	
	public void AcceptPrompt(String text) {
		
		if (!isAlertPresent())
			return;
		
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
		oLog.info(text);
	}
	
	public void AcceptPermissions() {
		By allowButton = By.id("com.android.packageinstaller:id/permission_allow_button");
		
		while(isAlertPopUpPresent(allowButton)){
			driver.findElement(allowButton).click();
		}
	}
	
	public boolean isAlertPopUpPresent(By allowButton) {
		boolean alertPresent;
		try {
				driver.findElement(allowButton).isDisplayed(); 
				alertPresent = true;
			}
		catch (Exception e) {
			alertPresent = false;
		}			
		
		return alertPresent;
		
	}
}
