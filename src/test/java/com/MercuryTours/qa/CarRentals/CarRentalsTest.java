package com.MercuryTours.qa.CarRentals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.MercuryTours.qa.Base.TestBase;
import com.MercuryTours.qa.Pages.CarRentalsPage;

public class CarRentalsTest extends TestBase {
	CarRentalsPage CR;
	
	@Test(groups="Car Rentals")
	public void PageTitle_CarRentals()
	{
		ActualResult=driver.getTitle();
		SoftAssert SA=new SoftAssert();
		String ExpectedTitle="Under Construction: Mercury Tours";
		SA.assertEquals(ActualResult, ExpectedTitle);
		CR=new CarRentalsPage();
		SA.assertAll();
	}
	
	@Test(groups="Car Rentals", dependsOnMethods="PageTitle_CarRentals")
	public void CarRentals()
	{
		ActualResult=CR.carRentals();
		Assert.assertEquals(ActualResult, "© 2005, Mercury Interactive (v. 011003-1.01-058)");
		
	}

	@AfterClass(alwaysRun=true)
	public void Teardown() 
	{
		driver.quit();
	}


}
