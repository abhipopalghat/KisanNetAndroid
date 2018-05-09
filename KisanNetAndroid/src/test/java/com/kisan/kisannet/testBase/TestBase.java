package com.kisan.kisannet.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.kisan.kisannet.excelreader.ExcelReader;
import com.kisan.kisannet.helper.assertionHelper.VerificationHelper;
import com.kisan.kisannet.pagelibrary.Categories;
import com.kisan.kisannet.pagelibrary.ChannelDashboard;
import com.kisan.kisannet.pagelibrary.CreateChannelPage;
import com.kisan.kisannet.pagelibrary.EnterChannelInfo;
import com.kisan.kisannet.pagelibrary.InviteManually;
import com.kisan.kisannet.pagelibrary.LeftDrawer;
import com.kisan.kisannet.pagelibrary.MyChat;
import com.kisan.kisannet.pagelibrary.SelectContact;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestBase {

	public AndroidDriver<?> driver;
	public static Properties prop;
	public File file;
	public FileInputStream fis;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ITestResult result;
	public ExcelReader excelreader;
	public static VerificationHelper softAssertion;
	
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	
	
	public void deviceSettings() throws MalformedURLException {
		logger.info("Loading Device Settings");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", prop.getProperty("DeviceName"));
		capabilities.setCapability("platformName", prop.getProperty("PlatformName"));
		capabilities.setCapability("platformVersion", prop.getProperty("PlatformVersion"));
		capabilities.setCapability("appPackage", prop.getProperty("AppPackage"));
		capabilities.setCapability("appActivity", prop.getProperty("AppActivity"));
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("newCommandTimeout","1840");
		driver = new AndroidDriver(new URL(prop.getProperty("Url")), capabilities);
		logger.info("Device settings Loaded");
	}
	
	public void loadDeviceProperties() throws Exception {
		String log4jconfpath = System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jconfpath);
		
		prop = new Properties();
		file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\kisan\\kisannet\\config\\config.properties" );
		fis = new FileInputStream(file);
		prop.load(fis);
		logger.info("Properties file loaded");
	}
	
	public String getScreenShot(String imageName) throws Exception {
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = System.getProperty("user.dir")+"\\src\\test\\java\\com\\kisan\\kisannet\\screenshots\\";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String actualImageName = imageLocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile = new File(actualImageName);
		FileUtil.copyFile(image, destFile);
		return actualImageName;
	}
	
	public void waitTillElementClickable(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitTillElementPresent(AndroidDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\java\\com\\kisan\\kisannet\\report\\test"+formater.format(calendar.getTime())+".html",false);
	}
	
	public void getResult(ITestResult result) throws Throwable {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + "test is pass");
		}
		
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + "test is skipped and reason is :" + result.getThrowable());
		}
		
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + "test is skipped and reason is :" + result.getThrowable());
			String screen = getScreenShot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		}
		
		else if(result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName()+ "test is started");
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		navigateToMyChat();
		getResult(result);
		
	}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test started");
	}
	
	
	
	@BeforeClass
	public void beforeSuite() throws Exception {
		loadDeviceProperties();
		deviceSettings();
		//get_Data("TestData", "ChannelNames");
	}
	
	@AfterClass
	public void afterTest() throws Exception {
		extent.endTest(test);
		extent.flush();
	}
	
	
	public void navigateToMyChat() throws Exception {
		MyChat mychat = new MyChat(driver);
		while(!mychat.isUserOnMyChat()) {
			driver.navigate().back();
		}
		logger.info("Navigated To MyChat");
	}
	
	public String[][] get_Data(String excelname, String sheetname) throws IOException{
		excelreader = new ExcelReader();
		String excellocation = System.getProperty("user.dir")+"\\src\\test\\java\\com\\kisan\\kisannet\\resources"+excelname;
		return excelreader.getExcelData(excellocation, sheetname);
	}
	
	public void navigateToFollowersChannel(AndroidDriver<?> driver) throws Exception {
		MyChat mychat = new MyChat(driver);
		ChannelDashboard channelDashboard = new ChannelDashboard(driver);
		navigateToMyChat();
		mychat.clickOnRightDrawerMenu();
		mychat.clickOnSearchChannelOption();
		mychat.searchFollowersChannel();
		mychat.clickOnSearchedChannel();
		driver.navigate().back();
		channelDashboard.clickOnNewMessageButtonForFollower();	
	}
	
	public void navigateToAdminsChannel(AndroidDriver<?> driver) throws Exception {
		MyChat mychat = new MyChat(driver);
		ChannelDashboard channelDashboard = new ChannelDashboard(driver);
		navigateToMyChat();
		mychat.clickOnRightDrawerMenu();
		mychat.clickOnSearchChannelOption();
		mychat.searchAdminsChannel();
		mychat.clickOnSearchedChannel();
		//driver.navigate().back();
		channelDashboard.clickOnNewMessageButtonForAdmin();
	}
	
	/*public static void main(String[] args) throws Exception {
		TestBase test = new TestBase();
		test.loadDeviceProperties();
		test.deviceSettings();
	}*/
	

}
