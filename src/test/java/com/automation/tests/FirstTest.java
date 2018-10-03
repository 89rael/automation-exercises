package com.automation.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.automation.models.User;
import com.automation.pages.DropDownPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoggedInPage;
import com.automation.pages.RegisterFormPage;
import com.automation.pages.RegisterPage;

public class FirstTest extends BaseTest {
	
		User user = new User(
				"Cosme ", 
				"Fulanito",
				"12345",
				"742 Evergreen Terrace",
				"Bariloche",
				"00000",
				"123456789");
		
		String email = RandomStringUtils.random(4, true, false)+"cosme.fulanito@test.com";
		String state = "Florida";
 
		
		@Test
		public void resgister() {
			
			driver.get("http://automationpractice.com/index.php");
			
			HomePage homePage = new HomePage(driver);
			RegisterPage registerPage = homePage.clickOnSignIn();
			registerPage.fillEmailCreateBox(email);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			RegisterFormPage registerFormPage = registerPage.clickOnCreateAnAccountButton();
			registerFormPage.fillFirstNameInput(user.getName());
			registerFormPage.fillLastNameInput(user.getLastName());
			registerFormPage.fillPasswordInput(user.getPassword());
			registerFormPage.fillAddressInput(user.getAddress());
			registerFormPage.fillCityInput(user.getCity());
			DropDownPage dropDownPage = new DropDownPage(driver);
			dropDownPage.selectOptionByVisibleText("Florida");
			registerFormPage.fillZipcodeInput(user.getZipcode());
			registerFormPage.fillPhoneMobileInput(user.getPhoneMobile());
			LoggedInPage loggedInPage =  registerFormPage.clickOnRegisterButton();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			assertEquals(loggedInPage.getAccountNameLabel().getText(), "Cosme Fulanito");
		}

}
