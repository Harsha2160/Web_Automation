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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Testlisten implements ITestListener {
	Screenshot sc;
	ReportCategory_Conditionalities RCC;
	public static ExtentTest logger;
	private static ExtentReports extent;
	private static ExtentHtmlReporter HtmlReporter;
	public static int Sheetnum=0;
	public static int rownum_ExpectedResult=1;
	public static Object[] InputParameters;
	public static Object[] TempParameters;
	public static String packagename;
	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName());
		packagename=result.getTestClass().getRealClass().getPackage().getName();
		RCC=new ReportCategory_Conditionalities();
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		rownum_ExpectedResult++;
	}

	public void onTestSkipped(ITestResult result) {
		
		logger = extent.createTest(result.getName());
		String Throwable_Message=result.getThrowable().getMessage();
		packagename=result.getTestClass().getRealClass().getPackage().getName();
		RCC=new ReportCategory_Conditionalities();
		
		if(Throwable_Message.contains("depends"))
		{
		if(InputParameters!=null)
		Sheetnum++;
		rownum_ExpectedResult++;
		}
		else
		TempParameters=result.getParameters();
		
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	    logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
	    }

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		if (HtmlReporter == null) {
			HtmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "./test-output/STMExtentReport.html");
            extent = new ExtentReports();
			extent.attachReporter(HtmlReporter);
			extent.setSystemInfo("Host Name", "5CD9229M66");
			extent.setSystemInfo("Environment", "Test");
			extent.setSystemInfo("Test Automation Engineer", "Harsha");
			HtmlReporter.config().setDocumentTitle("Regression Test Report");

			HtmlReporter.config().setReportName("Regression Test Report");

			HtmlReporter.config().setTheme(Theme.STANDARD);
		}
	}

	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName());
		packagename=result.getTestClass().getRealClass().getPackage().getName();
		RCC=new ReportCategory_Conditionalities();
	    rownum_ExpectedResult++;
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
		InputParameters=result.getParameters();
		
		
		}
}
	


