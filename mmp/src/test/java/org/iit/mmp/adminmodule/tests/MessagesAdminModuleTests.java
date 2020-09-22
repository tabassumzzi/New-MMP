package org.iit.mmp.adminmodule.tests;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.iit.mmp.adminmodule.pages.MessagesAdminModulePage;
import org.iit.mmp.helper.HelperClass;
import org.iit.util.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class MessagesAdminModuleTests extends BaseClass {

	HelperClass helperObj;
	MessagesAdminModulePage MAMPage;
	
	String URL = "http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php";
	//String filePath = System.getProperty("user.dir")+"\\Data\\testData.xlsx";
	String moduleName = "Logout";
	HashMap <String, String> hMap;
	String name;
	String subject;
	String description;
	
	@Test 
	//(dataProvider = "testData", description = "US_001 Login to the app as an admin", groups={"US_001", "adminModule"})
	public void MessagesTest() throws Exception {
		instantiateDriver();
		helperObj = new HelperClass(driver);
		helperObj.launchBrowser(URL);
		helperObj.adminLogin("Thomas", "Edison_444");
		helperObj.adminModuleNavigation("Messages");
		MAMPage = new MessagesAdminModulePage(driver);
		hMap = MAMPage.retrieveRecentMessageDetails();
		MAMPage.validateMessageFromAdminModule(hMap, name, subject, description);




}	
		
	}

