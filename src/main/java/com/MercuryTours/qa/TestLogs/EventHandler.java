package com.MercuryTours.qa.TestLogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.MercuryTours.qa.Base.TestBase;

public class EventHandler extends TestBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigating To"+""+url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated To"+""+url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating To previous Page"+":"+ driver.getTitle());
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated To previous Page"+":"+ driver.getTitle());
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating To Page"+":"+ driver.getTitle());
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated To Page"+":"+ driver.getTitle());
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Refreshing the Page"+":"+ driver.getTitle());
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Refreshed the Page"+":"+ driver.getTitle());
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("finding the WebELement"+":"+ by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("found the WebELement"+":"+ by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicking on the WebELement"+":"+ element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on the WebELement"+":"+ element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Entering a value"+":"+ element.toString());
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Entered a value"+":"+ element.toString());
		
	}

	public void beforeScript(String script, WebDriver driver) {
	    System.out.println("Test Execution started");
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("Test Execution Ended");
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception thrown"+":"+ throwable.getMessage());
		
	}

}
