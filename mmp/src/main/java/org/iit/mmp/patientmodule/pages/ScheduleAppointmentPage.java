package org.iit.mmp.patientmodule.pages;



import org.iit.util.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;




import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage extends BaseClass {
	

	WebDriver driver;

	By createAppointmentButton = By.xpath("//input[@value='Create new appointment']");
	//String doctorXpath ="//h4[contains(text(),'%%doctorname%%')]/ancestor::ul/following-sibling::button";
	String doctorXpath =  "//h4[contains(text(),'%%doctorName%%')]/ancestor::td/button[@id='opener']";
	By datePickerID =By.id("datepicker");
	By timeID       =By.id("time");
	By continueButton = By.id("ChangeHeatName");
	By symptomsID = By.id("sym");
	By dateofAppointmentHP = By.xpath("//table[@class='table']/tbody/tr[1]/td[1]");
	By timeHP = By.xpath("//table[@class='table']/tbody/tr[1]/td[2]");
	By symptomsHP = By.xpath("//table[@class='table']/tbody/tr[1]/td[3]");
	By doctorHP = By.xpath("//table[@class='table']/tbody/tr[1]/td[4]");
	By dateofAppointmentSP = By.xpath("(//h3[@class='panel-title'])[2]");
	By timeSP = By.xpath("//a[contains(text(),'Time')]");
	By symptomsSP = By.xpath("//a[contains(text(),'Symptoms')]");
	By doctorSP = By.xpath("//a[contains(text(),'Provider')]");
 



	public ScheduleAppointmentPage(WebDriver driver) {
		this.driver = driver;
		
		
	 
	}
 
	public HashMap<String, String> bookAppointment(String doctorName) throws InterruptedException
	{
		HashMap<String,String> hMap = new HashMap<String,String>();
		 
		driver.findElement(createAppointmentButton).click();
	 
		driver.findElement(By.xpath(doctorXpath.replace("%%doctorName%%", doctorName))).click();
		driver.switchTo().frame("myframe");
		driver.findElement(datePickerID).sendKeys("09/08/2020");
		driver.findElement(datePickerID).sendKeys(Keys.TAB);
		Select time = new Select(driver.findElement(timeID));
		time.selectByVisibleText("11Am");
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement continueWE = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueButton)));
		continueWE.click();	
		String symptoms = "Booking an appointment for the doctor "+ doctorName+ "for the symptoms fever";
		driver.findElement(symptomsID).sendKeys(symptoms);
		hMap.put("dateOfAppointment", "09/08/2020");
		hMap.put("time", "10Am");
		hMap.put("symptoms", symptoms);
		hMap.put("doctor", doctorName);
		return hMap;
	}
	public boolean validateAppointmentDetailsinHomePage(HashMap<String,String> hMap)
	{
		 
		boolean result = false;
		if(hMap.get("dateOfAppointment").equals(driver.findElement(dateofAppointmentHP).getText()) &&
				hMap.get("time").equals(driver.findElement(timeHP).getText()) &&
				hMap.get("symptoms").equals(driver.findElement(symptomsHP).getText()) &&
				hMap.get("doctor").equals(driver.findElement(doctorHP).getText()))
		{
			result = true;
		}
		return result;
	}
	public boolean validateAppointmentDetailsinSPage(HashMap<String,String> hMap)
	{
//		Time :     11 Am
//		String str = driver.findElement(dateofAppointmentSP).getText()
//		String strArray[]= str.split(":")
//		          strArray[0] : Time
//		          strArray[1]:  11 Am
//		Actual :           strArray[1].trim()
//
//
//		  driver.findElement(dateofAppointmentSP).getText().split(":")[1].trim()
		 
		boolean result = false;
		if(hMap.get("dateOfAppointment").equals(driver.findElement(dateofAppointmentSP).getText()) &&
				hMap.get("time").equals(driver.findElement(timeSP).getText().split(":")[1].trim()) &&
				hMap.get("symptoms").equals(driver.findElement(symptomsSP).getText().split(":")[1].trim()) &&
				hMap.get("doctor").equals(driver.findElement(doctorSP).getText().split(":")[1].trim()))
		{
			result = true;
		}
		return result;
	}

}

	
	


