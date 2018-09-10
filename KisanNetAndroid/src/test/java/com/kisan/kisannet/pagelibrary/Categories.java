package com.kisan.kisannet.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kisan.kisannet.helper.Logger.LoggerHelper;
import com.kisan.kisannet.helper.Wait.WaitHelper;

import io.appium.java_client.android.AndroidDriver;


public class Categories {
	
	public AndroidDriver<?> driver;
	private final Logger logger = LoggerHelper.getLogger(Categories.class);
	WaitHelper waitHelper;
	
	public By agricultureCategory = By.xpath("//android.widget.TextView[@text='Agriculture']");
	public By horticultureCategory = By.xpath("//android.widget.TextView[@text='Horticulture']");
	public By irrigationCategory = By.xpath("//android.widget.TextView[@text='Irrigation']");
	public By animalHusbandryCategory = By.xpath("//android.widget.TextView[@text='Animal Husbandry']");
	public By farmAlliedActivitiesCategory = By.xpath("//android.widget.TextView[@text='Farm Allied Activities']");
	public By machineandToolsCategory = By.xpath("//android.widget.TextView[@text='Machine & Tools']");
	public By postHarvestCategory = By.xpath("//android.widget.TextView[@text='Post Harvest']");
	public By agriTradingCategory = By.xpath("//android.widget.TextView[@text='Agri Trading']");
	public By bioTechnologyCategory = By.xpath("//android.widget.TextView[@text='Bio-Technology']");
	public By organicFarmingCategory = By.xpath("//android.widget.TextView[@text='Organic Farming']");
	public By agroChemicalsCategory = By.xpath("//android.widget.TextView[@text='Agro Chemicals']");
	public By agriBusinessCategory = By.xpath("//android.widget.TextView[@text='Agri Business']");
	public By farmServicesCategory = By.xpath("//android.widget.TextView[@text='Farm Services']");
	public By agriFinanceAndInsuranceCategory = By.xpath("//android.widget.TextView[@text='Agri Finance & Insurance']");
	public By alternateEnergyCategory = By.xpath("//android.widget.TextView[@text='Alternate Energy']");
	
	
	public By nextBtn = By.id("com.kisan.samvaad.dev:id/action_next");
	public By backArrow = By.className("android.widget.ImageButton");
	
	public Categories(AndroidDriver<?> driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
		
	public void selectAgricultureCategory(){
		waitHelper.waitForElementVisible(agricultureCategory, 10);
		driver.findElement(agricultureCategory).click();
		logger.info("Clicked on Agriculture Category");
	}	
	
	public void selectHorticultureCategory(){
		waitHelper.waitForElementVisible(horticultureCategory, 10);
		driver.findElement(horticultureCategory).click();
		logger.info("Clicked on Horticulture Category");
	}	
	
	public void selectIrrigationCategory(){
		waitHelper.waitForElementVisible(irrigationCategory, 10);
		driver.findElement(irrigationCategory).click();
		logger.info("Clicked on Irrigation Category");
	}
	
	public void selectAnimalHusbandryCategory() {
		waitHelper.waitForElementVisible(animalHusbandryCategory, 10);
		driver.findElement(animalHusbandryCategory).click();
		logger.info("Clicked on Animal Husbandry Category");
	}
	
	public void selectFarmAlliedActivitiesCategory() {
		waitHelper.waitForElementVisible(farmAlliedActivitiesCategory, 10);
		driver.findElement(farmAlliedActivitiesCategory).click();
		logger.info("Clicked on Farm Allied Activities Category");
	}
	
	public void selectMachineandToolsCategory() {
		waitHelper.waitForElementVisible(machineandToolsCategory, 10);
		driver.findElement(machineandToolsCategory).click();
		logger.info("Clicked on Machine and Tools Category");
	}
	
	public void selectPostHarvestCategory() {
		waitHelper.waitForElementVisible(postHarvestCategory, 10);
		driver.findElement(postHarvestCategory).click();
		logger.info("Clicked on Post Harvest Category");
	}
	
	public void selectAgriTradingCategory() {
		waitHelper.waitForElementVisible(agriTradingCategory, 10);
		driver.findElement(agriTradingCategory).click();
		logger.info("Clicked on Agri Trading Category");
	}
	
	public void selectBioTechnologyCategory() {
		waitHelper.waitForElementVisible(bioTechnologyCategory, 10);
		driver.findElement(bioTechnologyCategory).click();
		logger.info("Clicked on Bio Technology Category");
	}
	
	public void selectOrganicFarmingCategory() {
		waitHelper.waitForElementVisible(organicFarmingCategory, 10);
		driver.findElement(organicFarmingCategory).click();
		logger.info("Clicked on Organic Farming Category");
	}
	
	public void selectAgroChemicalsCategory() {
		waitHelper.waitForElementVisible(agroChemicalsCategory, 10);
		driver.findElement(agroChemicalsCategory).click();
		logger.info("Clicked on Agro Chemicals Category");
	}
	
	public void selectAgriBusinessCategory() {
		waitHelper.waitForElementVisible(agriBusinessCategory, 10);
		driver.findElement(agriBusinessCategory).click();
		logger.info("Clicked on Agri Business Category");
	}
	
	public void selectFarmServicesCategory() {
		waitHelper.waitForElementVisible(farmServicesCategory, 10);
		driver.findElement(farmServicesCategory).click();
		logger.info("Clicked on Farm Services Category");
	}
	
	public void selectAgriFinanceAndInsuranceCategory() {
		waitHelper.waitForElementVisible(agriFinanceAndInsuranceCategory, 10);
		driver.findElement(agriFinanceAndInsuranceCategory).click();
		logger.info("Clicked on Agri Finance And Insurance Category");
	}
	
	public void selectAlternateEnergyCategory() {
		waitHelper.waitForElementVisible(alternateEnergyCategory, 10);
		driver.findElement(alternateEnergyCategory).click();
		logger.info("Clicked on Alternate Energy Category");
	}
	
	public void clickNext() {
		SelectContact selectContact = new SelectContact(driver);
		waitHelper.waitForElementVisible(nextBtn, 10);
		driver.findElement(nextBtn).click();
		logger.info("Clicked on Next Button");
		waitHelper.waitForElementVisible(selectContact.doneButton, 40);
	}
	
	public void clickBack() {
		waitHelper.waitForElementVisible(backArrow, 10);
		driver.findElement(backArrow).click();
		logger.info("Clicked on Back Button");
	}
	

}
