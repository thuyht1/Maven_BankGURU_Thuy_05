package live.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MyDashboardPageObject extends AbstractPage {
	WebDriver driver;
	
	public MyDashboardPageObject (WebDriver  mappingDriver) {
		driver = mappingDriver;
	}
	

}
