package com.MercuryTours.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MercuryTours.qa.Base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//*[@name='userName']")
	WebElement username;
	@FindBy(xpath="//*[@name='password']")
	WebElement password;
	@FindBy(linkText="REGISTER")
	WebElement Register;
	
	public HomePage()
	{
		PageFactory.initElements(driver, HomePage.this);
	}
	
	
	public String Login(String un, String pa)
	{
		username.sendKeys(un);
		password.sendKeys(pa);
		String S=Register.getText();
		Register.click();
		return S;
	}

}
