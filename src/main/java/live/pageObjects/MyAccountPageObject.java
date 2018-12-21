package live.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MyAccountPageObject extends AbstractPage {
	WebDriver driver;
	
	public MyAccountPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
