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
	public void PageTitle_Home() throws IOException 
	{
		initialization();
		ActualResult=driver.getTitle();
		SoftAssert SA=new SoftAssert();
		String ExpectedTitle=ObjectArray_Input.Fetch_ExpectedResult();
		SA.assertEquals(ActualResult, ExpectedTitle);
		hp = new HomePage(); 
		SA.assertAll();
      //Soft Assertion can be used if there are lines below Assertion statement in a TC.
	  //Because we want to execute the statements after Assertion
	
	}
	
	
	@DataProvider
	public Object[][] Login_Data() throws IOException {
		return ObjectArray_Input.Fetch_TestData();                       //Returning Method inside a Method
	}

	
	@Test(dataProvider="Login_Data", groups="Home", dependsOnMethods="PageTitle_Home")
	public void Home(String username, String Password) throws IOException 
	{
	ActualResult=hp.Login(username, Password);
	String ExpectedResult=ObjectArray_Input.Fetch_ExpectedResult();
	Assert.assertEquals(ActualResult, ExpectedResult);
	
	
	
	}

	

}
