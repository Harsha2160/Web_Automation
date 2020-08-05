package com.MercuryTours.qa.ExtentReport;

public class ReportCategory_Conditionalities extends Testlisten {
	
	public ReportCategory_Conditionalities()
	{
		if(packagename.equals("com.MercuryTours.qa.Home"))
		{
		String category="Home";
		logger.assignCategory(category);
		}
		else if(packagename.equals("com.MercuryTours.qa.Register"))
		{
		String category="Registration";
		logger.assignCategory(category);
		}
		else if(packagename.equals("com.MercuryTours.qa.CarRentals"))
		{
		String category="Car Rentals";
		logger.assignCategory(category);
		}
	}

}
