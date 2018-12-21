package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.BankEditCustomerPageUI;
import bankguru.BankHomePageUI;
import commons.AbstractPage;

public class BankEditCustomerPageObject extends AbstractPage {
	WebDriver driver;	
	
	public BankEditCustomerPageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}
}
