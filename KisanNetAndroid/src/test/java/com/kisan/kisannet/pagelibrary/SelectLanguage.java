package com.kisan.kisannet.pagelibrary;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;

import io.appium.java_client.android.AndroidDriver;


public class SelectLanguage {
	
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(MyChat.class);
	WaitHelper waitHelper;
	
	public By english= By.xpath("//android.widget.TextView[@text='English']");
	public By marathi=By.xpath("//android.widget.TextView[@text='मराठी']");
	public By hindi=By.xpath("//android.widget.TextView[@text='हिंदी']");
	
	
	public SelectLanguage(AndroidDriver<?> driver) {
		this.driver=driver;
		waitHelper=new WaitHelper(driver);
	}

//Select English language

    public String clickEnglish() throws Exception{
    	waitHelper.waitForElementClickable(driver, 5, english);
    	driver.findElement(english).click();
    	waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
    	return "English";
    }
    
 //Select Marathi language
    
    public String clickMarathi() throws Exception{
    	waitHelper.waitForElementClickable(driver, 5, marathi);
    	driver.findElement(marathi).click();
    	waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
    	return "Marathi";
    }

 //Select Hindi language

    public String clickHindi() throws Exception{
    	waitHelper.waitForElementClickable(driver, 5, hindi);
    	driver.findElement(hindi).click();
    	waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
    	return "Hindi";
    }
    
    
    public void changeLanguage(String language) throws Exception {
  	   	   	  
  	switch (language) {
  	
  	case "English":
  		clickEnglish();
  		break;
  		
  	case "Hindi":
  		clickHindi();
  		break;
  		
  	case "Marathi":
  		clickMarathi();;
  		break;

  	default:
  		break;
  	}
  }

}
