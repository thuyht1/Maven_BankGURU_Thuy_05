package com.liveguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import live.pageObjects.LiveHomePageObject;
import live.pageObjects.LivePageFactoryManager;
import live.pageObjects.MyAccountPageObject;
import live.pageObjects.MyDashboardPageObject;
import live.pageObjects.RegisterPageObject;

public class Account_01_RegisterAndLogin extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		driver = openMultiBrowser(browserName, urlName);

		firstname = "Automation";
		lastName = "Testing Online";
		email = "auto05" + randomEmail() + "@gmail.com";
		password = "123123";

		homePage = LivePageFactoryManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Regiser() {
		myAccountPage = homePage.openMyAccountPage(driver);
		myAccountPage.clickToDynamicButton(driver, "Create Account");
		registerPage = new RegisterPageObject(driver);
		registerPage.sendkeyToDynamicTextbox(driver, "firstname", firstname);
		registerPage.sendkeyToDynamicTextbox(driver, "lastname", lastName);
		registerPage.sendkeyToDynamicTextbox(driver, "email_address", email);
		registerPage.sendkeyToDynamicTextbox(driver, "password", password);
		registerPage.sendkeyToDynamicTextbox(driver, "confirmation", password);

		myDashboard = registerPage.clickToRegisterButton();

		homePage = myDashboard.openLogoutPage(driver);
	}

	@Test
	public void TC_02_Login() {
		myAccountPage = homePage.openMyAccountPage(driver);
		myAccountPage.sendkeyToDynamicTextbox(driver, "email", email);
		myAccountPage.sendkeyToDynamicTextbox(driver, "pass", password);
		myAccountPage.clickToDynamicButton(driver, "Login");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	WebDriver driver;
	private String firstname, lastName, email, password;
	private LiveHomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private RegisterPageObject registerPage;
	private MyDashboardPageObject myDashboard;

}
