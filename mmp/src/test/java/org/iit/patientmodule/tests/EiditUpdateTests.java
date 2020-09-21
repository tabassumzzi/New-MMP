package org.iit.patientmodule.tests;

import java.util.HashMap;

import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.EditUpdatePage;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.util.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EiditUpdateTests  extends BaseClass{
	@Test
	public void validateEidtfuntioality() {
		
		 SoftAssert sa = new SoftAssert();
		 HelperClass helperObj = new HelperClass(driver);
		 helperObj.login("ria1", "Ria12345", "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		 EditUpdatePage editPage = new EditUpdatePage(driver);
		 helperObj.navigateToAModule("Profile");
		 editPage.clickOnEditButton();
		 HashMap<String,String> hMap1= editPage.editAllFileds();
		 editPage.clickOnSaveButton();
		 String actual = editPage.acceptAlert();
		 String expected = "Your Profile has been updated.";
		 //sa.assertEquals(actual, expected);
		 HashMap<String,String> hMap2 = editPage.getAllFiledValues();
		 sa.assertEquals(hMap1, hMap2);
		// sa.assertAll();
		 System.out.println("added new line");
		
	}
	

	

	}


