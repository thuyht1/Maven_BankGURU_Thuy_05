package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.BankHomePageUI;
import bankguru.BankNewCustomerPageUI;
import commons.AbstractPage;

public class BankNewCustomerPageObject extends AbstractPage {
	WebDriver driver;	
	
	public BankNewCustomerPageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}
	
}
