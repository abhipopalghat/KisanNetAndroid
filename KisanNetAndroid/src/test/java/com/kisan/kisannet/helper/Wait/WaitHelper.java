package com.kisan.kisannet.helper.Wait;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kisan.kisannet.helper.Logger.LoggerHelper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class WaitHelper {
	
	private AndroidDriver driver;
	private Logger Log = LoggerHelper.getLogger(WaitHelper.class);

	
	public WaitHelper(AndroidDriver driver) {
		this.driver = driver;
		Log.debug("WaitHelper : " + this.driver.hashCode());
	}
	
	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	public void setPageLoadTimeout(long timeout, TimeUnit unit) {
		Log.info(timeout);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	private WebDriverWait getWait(int timeOutInSeconds) {
		Log.debug("");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	public void waitForElementVisible(By locator, int timeOutInSeconds) {
		Log.info(locator);
		WebDriverWait wait = getWait(timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElement(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		Log.info("element found..."+element.getText());
	}
	
	public WebElement waitForElement(WebDriver driver,long time,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementClickable(AndroidDriver driver,long time,By locator){
		WebDriverWait wait = new WebDriverWait(driver, time);
		Log.info("Element found..."+driver.findElement(locator).getText());
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForElementClickable(AndroidDriver driver,long time,MobileElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		Log.info("Element found..."+element.getText());
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
