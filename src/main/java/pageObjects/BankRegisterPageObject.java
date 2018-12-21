package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.BankRegisterPageUI;
import commons.AbstractPage;

public class BankRegisterPageObject extends AbstractPage {
	WebDriver driver;
	
	public BankRegisterPageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}

	public void inputEmail(String email) {
		waitForControlVisible(driver, BankRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, BankRegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void clickSubmitButton() {
		waitForControlVisible(driver, BankRegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, BankRegisterPageUI.SUBMIT_BUTTON);
	}
	public String getUserIDInfor() {
		waitForControlVisible(driver, BankRegisterPageUI.USER_ID_TEXT);
		return getTextInElement(driver, BankRegisterPageUI.USER_ID_TEXT);
	}
	
	public String getPasswordInfor() {
		waitForControlVisible(driver, BankRegisterPageUI.PASSWORD_TEXT);
		return getTextInElement(driver, BankRegisterPageUI.PASSWORD_TEXT);
	}
	
	public BankLoginPageObject openLoginPage (String loginUrl) {
		openAnyUrl(driver,loginUrl);
		return BankPageManagerDriver.getLoginPage(driver);
	}
	
	
	
	
	
}
