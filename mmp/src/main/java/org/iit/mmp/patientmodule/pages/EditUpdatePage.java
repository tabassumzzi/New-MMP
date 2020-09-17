package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.Random;

import org.iit.util.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditUpdatePage {
	
	WebDriver driver;
	By ageID = By.id("age");
	By editButtonID = By.id("Ebtn");
	By saveButtonID = By.id("Sbtn");
	By weightID = By.id("weight");
	
	Random ran = new Random();
	//store expected values
	HashMap<String,String> hMap1= new HashMap<String,String>();
	//store actual values
		HashMap<String,String> hMap2= new HashMap<String,String>();
		
	public EditUpdatePage(WebDriver driver) {
		this.driver= driver;
	
	

}
	public void editAgeFiled() {
		String randomAge= 10 + ran.nextInt(80) +"";
		hMap1.put("Age",randomAge);
		WebElement e = driver.findElement(ageID);
		e.clear();
		e.sendKeys(randomAge);
		
	}
	
	public void editWeightFiled() {
		String randomWeight= 10 + ran.nextInt(80) +"";
		hMap1.put("WEIGHT",randomWeight);
		WebElement e = driver.findElement(weightID);
		e.clear();
		e.sendKeys(randomWeight);
	}
	public void clickOnEditButton() {
		WebElement e = AppLibrary.waitforElementClickable(driver, 20,editButtonID);
		e.click();
		//driver.findElement(editButtonID).click();
		
		
	}
	public void clickOnSaveButton() {
		driver.findElement(saveButtonID).click();
		
	}
	public String acceptAlert() {
		Alert alrt = driver.switchTo().alert();
		String msg = alrt.getText();
		alrt.accept();
		return msg;
		
		
	}
	
	public  HashMap<String, String> editAllFileds() {
		
		editAgeFiled();
		editWeightFiled();
		//clickOnSaveButton();
		return hMap1;
		
	}
	public HashMap<String, String> getAllFiledValues() {
		hMap2.put("Age",driver.findElement(ageID).getAttribute("value"));
		hMap2.put("Weight",driver.findElement(weightID).getAttribute("value"));
		return hMap2;
		
	}
	
	}
	
		
	
