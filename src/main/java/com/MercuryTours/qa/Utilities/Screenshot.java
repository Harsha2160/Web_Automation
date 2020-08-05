package com.MercuryTours.qa.Utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.MercuryTours.qa.Base.TestBase;
import com.aventstack.extentreports.ExtentTest;

    public class Screenshot extends TestBase {
	static int i=0;
	public Screenshot(ExtentTest logger) 
	{
    
	//ExtentTest logger = Testlisten.logger;
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try 
	{
	FileUtils.copyFile(scrFile,
			new File("C:\\Users\\101139\\eclipse\\eclipse-workspace\\eSeal\\Screenshots\\"+i+".jpg"));
	logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(
					"C:\\Users\\101139\\eclipse\\eclipse-workspace\\eSeal\\Screenshots\\"+i+".jpg"));
	i++;
	} 
	catch (IOException e) 
	{
	e.printStackTrace();
	}
    }
    }
