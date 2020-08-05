package com.MercuryTours.qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.MercuryTours.qa.TestLogs.EventHandler;
import com.MercuryTours.qa.Utilities.Waits;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String ActualResult;
	public TestBase(){
		
	try {
	
		prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\101139\\eclipse\\eclipse-workspace"
				+ "\\Web_Automation\\src\\main\\java\\com\\MercuryTours\\qa\\Config\\config.properties");
		prop.load(file);
	    }  
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void initialization()
	{
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\101139\\eclipse\\eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("FireFox"))
		{
			
		}
		 EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		 EventHandler EH=new EventHandler();
		 eventDriver.register(EH);
		 driver=eventDriver;
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Waits.PageLoad_Timeout, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(Waits.Implicit_Wait, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
	}

}
