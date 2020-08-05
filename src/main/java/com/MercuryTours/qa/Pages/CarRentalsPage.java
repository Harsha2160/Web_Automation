package com.MercuryTours.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MercuryTours.qa.Base.TestBase;

public class CarRentalsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='footer']")
	WebElement footer;
	
	public CarRentalsPage()
	{
		PageFactory.initElements(driver, CarRentalsPage.this);
	}
	
	public String carRentals()
	{
		
		String footertext=footer.getText();
		return footertext;
		
	}

}
