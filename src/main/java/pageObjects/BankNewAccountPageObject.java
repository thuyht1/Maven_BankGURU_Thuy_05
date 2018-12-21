package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.BankHomePageUI;
import bankguru.BankNewAccountPageUI;
import bankguru.BankNewCustomerPageUI;
import commons.AbstractPage;

public class BankNewAccountPageObject extends AbstractPage {
	WebDriver driver;	
	
	public BankNewAccountPageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}
	
}
