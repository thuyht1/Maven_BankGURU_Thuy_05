package pageObjects;

import org.openqa.selenium.WebDriver;

public class BankPageManagerDriver {
	private static BankLoginPageObject loginPage;
	private static BankRegisterPageObject registerPage;
	private static BankNewCustomerPageObject newCustomerPage;
	private static BankEditCustomerPageObject editCustomerPage;
	private static BankNewAccountPageObject newAccountPage;
	private static BankHomePageObject homePage;
	
	
	//Singleton Pattern
	public static BankLoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			return new BankLoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static BankRegisterPageObject getRegisterPage (WebDriver driver) {
		if(registerPage == null) {
			registerPage = new BankRegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static BankNewCustomerPageObject getNewCustomerPage (WebDriver driver) {
		if(newCustomerPage == null) {
			return new BankNewCustomerPageObject (driver);
		}
		return newCustomerPage;
	}
	
	public static BankEditCustomerPageObject getEditCustomerPage (WebDriver driver) {
		if(editCustomerPage == null) {
			return new BankEditCustomerPageObject(driver);
		}
		return editCustomerPage;
	}
	public static BankNewAccountPageObject getNewAccountPage (WebDriver driver) {
		if(newAccountPage == null) { 
			return new BankNewAccountPageObject (driver);
		}
		return newAccountPage;
	}
	public static BankHomePageObject getHomePage (WebDriver driver)  {
		if(homePage == null) {
			return new BankHomePageObject (driver);
		}
		return homePage;
	}
	
}
