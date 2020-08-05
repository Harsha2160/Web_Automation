package com.MercuryTours.qa.Home;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.MercuryTours.qa.Base.TestBase;
import com.MercuryTours.qa.Pages.HomePage;
import com.MercuryTours.qa.TestData.ObjectArray_Input;



public class HomePageTest extends TestBase {
	HomePage hp;
	

	public HomePageTest() {

	}
	
	
	@Test(groups="Home")
	public void PageTitle_Home() 
	{
		initialization();
		ActualResult=driver.getTitle();
		SoftAssert SA=new SoftAssert();
		String ExpectedTitle="Welcome: Mercury Tours";
		SA.assertEquals(ActualResult, ExpectedTitle);
		hp = new HomePage(); 
		SA.assertAll();
      //Soft Assertion can be used if there are lines below Assertion statement in a TC.
	  //Because we want to execute the statements after Assertion
	//If we need Setup Test in the Report, avoid using Before class.
	}
	
	
	@DataProvider
	public Object[][] Login_Data() throws IOException {
		return ObjectArray_Input.Login_Array();                       //Returning Method inside a Method
	}

	
	@Test(dataProvider="Login_Data", groups="Home", dependsOnMethods="PageTitle_Home")
	public void Home(String username, String Password) 
	{
	ActualResult=hp.Login(username, Password);
	String ExpectedResult="REGISTER";
	Assert.assertEquals(ActualResult, ExpectedResult);
	
	
	
	}

	

}
