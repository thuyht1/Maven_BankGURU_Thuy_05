package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.BankHomePageUI;
import commons.AbstractPage;

public class BankHomePageObject extends AbstractPage {
	WebDriver driver;
	
	public BankHomePageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}
	
	public boolean verifyWelcomeMessageDisplayed() {
		waitForControlVisible(driver, BankHomePageUI.WELCOME_MESSAGE);
		return isControlDisplayed(driver, BankHomePageUI.WELCOME_MESSAGE);
	}
	public BankNewCustomerPageObject openNewCustomerPage () {
		waitForControlVisible(driver, BankHomePageUI.NEW_CUSTOMER_PAGE_LINK);
		clickToElement(driver, BankHomePageUI.NEW_CUSTOMER_PAGE_LINK);
		return new BankNewCustomerPageObject(driver);
	}

}
