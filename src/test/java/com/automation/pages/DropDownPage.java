package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {

	public DropDownPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "id_state")
	private WebElement dropdown;
	
	public void selectOptionByVisibleText(String option){
		Select dropdownSelect = new Select(dropdown);
		dropdownSelect.selectByVisibleText(option);
}
}
