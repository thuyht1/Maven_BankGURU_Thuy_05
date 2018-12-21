package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import bankguru.BankLoginPageUI;

public class BankLoginPageObject extends AbstractPage{
	WebDriver driver;
	
	public BankLoginPageObject(WebDriver mapDriver) {
		driver = mapDriver;
		
	}
	public String getLoginUrl( ) {
		return getCurrentPageUrl(driver);	
	}
	public BankRegisterPageObject clickHereLink() {
		waitForControlVisible(driver, BankLoginPageUI.HERE_LINK);
		clickToElement(driver, BankLoginPageUI.HERE_LINK);
		return BankPageManagerDriver.getRegisterPage(driver);
	}
	
	public void inputUserID(String email) {
		waitForControlVisible(driver, BankLoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, BankLoginPageUI.USER_ID_TEXTBOX, email);
	}
	public void inputPassword(String password) {
		waitForControlVisible(driver, BankLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, BankLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public BankHomePageObject clickSubmitButton() {
		waitForControlVisible(driver, BankLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, BankLoginPageUI.LOGIN_BUTTON);
		return BankPageManagerDriver.getHomePage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	

}
