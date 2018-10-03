package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='email_create']")
	private  WebElement emailCreateBox;
	
	@FindBy(name="SubmitCreate")
	private WebElement createAnAccountButton;
	
	public void fillEmailCreateBox(String email) {
		
		emailCreateBox.clear();
		emailCreateBox.sendKeys(email);
	}

	public RegisterFormPage clickOnCreateAnAccountButton() {
		
		createAnAccountButton.click();
		return new RegisterFormPage(driver);
	}
}
