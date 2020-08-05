package com.MercuryTours.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MercuryTours.qa.Base.TestBase;

public class RegistrationPage extends TestBase {
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//div[@class='footer']")
	WebElement Write_string;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement Home;
	
	@FindBy(xpath="//a[text()='Car Rentals']")
	WebElement Car_Rentals;
	
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, RegistrationPage.this);
	}
	
	
	
	
	public String Register(String firstname, String lastname, Long phonenumber)
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		PhoneNumber.sendKeys(String.valueOf(phonenumber));
		String Home_name=Home.getText();
		Car_Rentals.click();
		return Home_name;
	}
	
	

}
