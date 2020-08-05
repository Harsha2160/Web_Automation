package com.MercuryTours.qa.Register;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.MercuryTours.qa.Base.TestBase;
import com.MercuryTours.qa.Pages.RegistrationPage;
import com.MercuryTours.qa.TestData.ObjectArray_Input;



public class RegistrationPageTest extends TestBase{
	RegistrationPage RP;

	@Test(groups="Registration")
	public void PageTitle_Registration() {
		ActualResult=driver.getTitle();
		SoftAssert SA=new SoftAssert();
		SA.assertEquals(ActualResult, "Register: Mercury Tours");
		RP = new RegistrationPage();
		SA.assertAll();
	}
	
	@DataProvider
	public Object[][] Register_Data() throws IOException 
	{
		//Returning Method inside a Method
		return ObjectArray_Input.Register_data();                   
	}

	@Test(dataProvider="Register_Data", groups="Registration", dependsOnMethods="PageTitle_Registration")
	public void REGISTER(String Firstname, String Lastname, Long Phonenumber) 
	{
	ActualResult=RP.Register(Firstname,Lastname ,Phonenumber);
	Assert.assertEquals(ActualResult, "Home");
	}
	
	
}
