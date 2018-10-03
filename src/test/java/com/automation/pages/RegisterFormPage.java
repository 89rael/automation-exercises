package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterFormPage extends BasePage {

	public RegisterFormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='customer_firstname']")
	private WebElement firsrNameInput;
	
	@FindBy(xpath="//input[@name='customer_lastname']")
	private WebElement lastNameInput;
	
	@FindBy(xpath="//input[@name='passwd']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@name='address1']")
	private WebElement addressInput;
	
	@FindBy(id="city")
	private WebElement cityInput;
	
	@FindBy(id="postcode")
	private WebElement zipcodeInput;
	
	@FindBy(id="phone_mobile")
	private WebElement phoneMobileInput;
	
	@FindBy(id="submitAccount")
	private WebElement registerButton;
	//private WebElement firsrNameInput;
	
	public void fillFirstNameInput(String firstName) {
		
		firsrNameInput.sendKeys(firstName);
	}
	
	public void fillLastNameInput(String lastName) {
		
		lastNameInput.sendKeys(lastName);
	}
	
	public void fillPasswordInput(String password) {
			
		passwordInput.sendKeys(password);
	}
	
	public void fillAddressInput(String address) {
			
		addressInput.sendKeys(address);
	}
	
	public void fillCityInput(String city) {
			
		cityInput.sendKeys(city);
	}
	
	public void fillZipcodeInput(String zipcode) {
			
		zipcodeInput.sendKeys(zipcode);
	}
	
	public void fillPhoneMobileInput(String phoneMobile) {
			
		phoneMobileInput.sendKeys(phoneMobile);
	}
	
	public LoggedInPage clickOnRegisterButton() {
		
		registerButton.click();
		
		return new LoggedInPage(driver);
	}
}
