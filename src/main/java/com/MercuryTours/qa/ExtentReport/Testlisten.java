package com.MercuryTours.qa.ExtentReport;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.MercuryTours.qa.Utilities.Screenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Testlisten implements ITestListener {
	Screenshot sc;
	ReportCategory_Conditionalities RCC;
	public static ExtentTest logger;
	private static ExtentReports extent;
	private static ExtentSparkReporter SparkReporter;
	public static int Sheetnum=1;
	private static Object[] InputParameters;
	public static String packagename;

	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName());
		packagename=result.getTestClass().getRealClass().getPackage().getName();
		RCC=new ReportCategory_Conditionalities();
		
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));

	}

	public void onTestSkipped(ITestResult result) {
		
		logger = extent.createTest(result.getName());
		InputParameters=result.getParameters();
		if (InputParameters != null)
			Sheetnum++;
		packagename=result.getTestClass().getRealClass().getPackage().getName();
		RCC=new ReportCategory_Conditionalities();
	
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		if (SparkReporter == null) {
			SparkReporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "./test-output/STMExtentReport.html");
            extent = new ExtentReports();
			extent.attachReporter(SparkReporter);
			extent.setSystemInfo("Host Name", "5CD9229M66");
			extent.setSystemInfo("Environment", "Test");
			extent.setSystemInfo("Test Automation Engineer", "Harsha");
			SparkReporter.config().setDocumentTitle("Regression Test Report");

			SparkReporter.config().setReportName("Regression Test Report");

			SparkReporter.config().setTheme(Theme.STANDARD);
		}
	}

	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName());
		packagename=result.getTestClass().getRealClass().getPackage().getName();
		RCC=new ReportCategory_Conditionalities();
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		logger.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		if (result.isSuccess() == false)
			sc = new Screenshot(logger);

	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
    }

	public void onTestStart(ITestResult result) {
		

	}

}
