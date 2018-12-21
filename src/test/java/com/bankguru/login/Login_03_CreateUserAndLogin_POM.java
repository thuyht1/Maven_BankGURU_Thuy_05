package com.bankguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.BankEditCustomerPageObject;
import pageObjects.BankHomePageObject;
import pageObjects.BankLoginPageObject;
import pageObjects.BankNewAccountPageObject;
import pageObjects.BankNewCustomerPageObject;
import pageObjects.BankPageManagerDriver;
import pageObjects.BankRegisterPageObject;

public class Login_03_CreateUserAndLogin_POM extends AbstractTest {
	WebDriver driver;
	String  username, password, loginUrl, email, userId;

	@Parameters("browser")
	
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		// Step01 - open App URL -> Login Page
		driver = openMultiBrowser(browserName, urlName);
		email = "kimthuy.ht106" + randomEmail() + "@gmail.com";	
	}
	
  @Test
  public void TC_Login_01_CreateUser() {
	//----------LOGIN PAGE KHOI TAO L1----------//
	  loginPage = BankPageManagerDriver.getLoginPage(driver);
	  loginUrl = loginPage.getLoginUrl();
	  
	  //Step 02- Click here Link -> return Register page
	  registerPage = loginPage.clickHereLink();
	  registerPage.inputEmail(email);
	  registerPage.clickSubmitButton();
	  
	  userId = registerPage.getUserIDInfor();
	  password = registerPage.getPasswordInfor();
  }
  
  @Test
  public void TC_Login_02_LoginToApplication() {
	  // Step 03 - open login page again -> return login page
	  loginPage = registerPage.openLoginPage(loginUrl);
	  loginPage.inputUserID(userId);
	  loginPage.inputPassword(password);
	  homePage= loginPage.clickSubmitButton();
	  Assert.assertTrue(homePage.verifyWelcomeMessageDisplayed());
	  
	  //Step 04 - Open New Customer Page -> return New Customer Page
	  newCustomerPage = homePage.openNewCustomerPage(driver);
	  
	  //Step 05 - Open New Account Page -> return New Account Page
	 newAccountPage = newCustomerPage.openNewAccountPage(driver);
	  
	  //Step 06 - Open Edit  Customer Page
	 editCustomerPage = newAccountPage.openEditCustomerPage(driver);
	 
	 //Step07 -Open HomePage -> return Home Page
	 homePage = editCustomerPage.openHomePage(driver);
	 
	 //Step08 - Open New Customer -> return New Customer
	 newCustomerPage = homePage.openNewCustomerPage();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  private BankLoginPageObject loginPage;
  private BankRegisterPageObject registerPage;
  private BankHomePageObject homePage;
  private BankNewCustomerPageObject newCustomerPage;
  private BankNewAccountPageObject newAccountPage;
  private BankEditCustomerPageObject editCustomerPage;
  
}
