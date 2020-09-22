package org.iit.mmp.helper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.iit.mmp.config.ProjectConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperClass {
private WebDriver driver;
private By userNameId= By.id("username");

	public HelperClass(WebDriver driver) 
	{
		this.driver= driver;
	
		
	
		
	}

	
public void login(String uname, String pword, String url) {
	driver.get(("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php"));
	driver.findElement(By.id("username")).sendKeys("ria1");
	driver.findElement(By.id("password")).sendKeys("Ria12345");
	driver.findElement(By.name("submit")).click();
}

public void navigateToAModule(String moduleName)
{
	driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	
}
public void launchBrowser(String url) {
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

public void adminLogin(String uName, String password){

	driver.findElement(By.id("username")).sendKeys("Thomas_444");
	driver.findElement(By.id("password")).sendKeys("Edison_444");
	driver.findElement(By.name("admin")).click();
}


public void adminModuleNavigation(String moduleName){

	driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
}
public void captureScreenshot(String tc_Name) throws IOException
{
	System.out.println("Inside Capturing Screenshot method");
	TakesScreenshot tsh = (TakesScreenshot)driver;
	File sourceFile = tsh.getScreenshotAs(OutputType.FILE);
	System.out.println(sourceFile.getAbsolutePath());
	String destinationPath = System.getProperty("user.dir")+"\\screenshots\\"+tc_Name+"_"+
										Calendar.getInstance().getTimeInMillis()%1000000000+".jpg";
	File destFile = new File(destinationPath); 
	FileUtils.copyFile(sourceFile,destFile);
	System.out.println(destinationPath);
	System.out.println("Exiting Screenshot");
	
}
public void highLightElement(WebElement ele){
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;')", ele);



	
}


	public void patientLogin() throws Exception 
	{
		ProjectConfiguration pConfig = new ProjectConfiguration();	
		Properties pro = pConfig.loadProperites();  
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pro.getProperty("patientUser"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pro.getProperty("patientPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
	public void adminLogin() throws Exception 
	{
		ProjectConfiguration pConfig = new ProjectConfiguration();	
		Properties pro = pConfig.loadProperites();  
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pro.getProperty("adminUser"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pro.getProperty("adminPassword"));
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

public void closeDriver() {
	//driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();
	driver.close();
}


public void switchToSideBar() {
	driver.findElement(By.xpath("//div[@class='left-sidebar']")).click();
	
}
}