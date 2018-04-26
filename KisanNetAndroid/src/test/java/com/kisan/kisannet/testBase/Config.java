package com.kisan.kisannet.testBase;

public class Config extends TestBase {

	public String getDviceName() {
		return prop.getProperty("DeviceName");
	}
	
	public String getPlatformName() {
		return prop.getProperty("PlatformName");
	}
	
	public String getPlatformVersion() {
		return prop.getProperty("PlatformVersion");
	}
	
	public String getAppPackage() {
		return prop.getProperty("AppPackage");
	}
	
	public String getAppActivity() {
		return prop.getProperty("AppActivity");
	}
	
	public String getUrl() {
		return prop.getProperty("Url");
	}
	
	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}
	
	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplicitWait"));
	}
	
	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}
	
}
