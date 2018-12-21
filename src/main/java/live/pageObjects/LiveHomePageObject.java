package live.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class LiveHomePageObject extends AbstractPage {
	WebDriver driver;
	
	public LiveHomePageObject (WebDriver  mappingDriver) {
		driver = mappingDriver;
	}
	

}
