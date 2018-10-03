package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement signInButton;
	
	public RegisterPage clickOnSignIn() {
		
		signInButton.click();
		
		return new RegisterPage(driver);
	}
}
