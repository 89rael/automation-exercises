package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends BasePage {

	public LoggedInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='account']")
	private WebElement accountNameLabel;
	
	public WebElement getAccountNameLabel() {
		
		return accountNameLabel;
	}

}
