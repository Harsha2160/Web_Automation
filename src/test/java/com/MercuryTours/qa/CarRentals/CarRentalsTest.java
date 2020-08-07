package com.MercuryTours.qa.CarRentals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.MercuryTours.qa.Base.TestBase;
import com.MercuryTours.qa.Pages.CarRentalsPage;
import com.MercuryTours.qa.TestData.ObjectArray_Input;

public class CarRentalsTest extends TestBase {
	CarRentalsPage CR;
	
	@Test(groups="Car Rentals")
	public void PageTitle_CarRentals() throws IOException
	{
		ActualResult=driver.getTitle();
		SoftAssert SA=new SoftAssert();
		String ExpectedTitle=ObjectArray_Input.Fetch_ExpectedResult();
		SA.assertEquals(ActualResult, ExpectedTitle);
		CR=new CarRentalsPage();
		SA.assertAll();
	}
	
	@Test(groups="Car Rentals", dependsOnMethods="PageTitle_CarRentals")
	public void CarRentals() throws IOException
	{
		ActualResult=CR.carRentals();
		String ExpectedResult=ObjectArray_Input.Fetch_ExpectedResult();
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}

	@AfterClass(alwaysRun=true)
	public void Teardown() 
	{
		driver.quit();
	}


}
