package live.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import live.pageUIs.LiveRegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	
public RegisterPageObject (WebDriver mappingDriver) {
	driver = mappingDriver;
}

public MyDashboardPageObject clickToRegisterButton() {
	waitForControlVisible(driver, LiveRegisterPageUI.REGISTER_BUTTON);
	clickToElement(driver, LiveRegisterPageUI.REGISTER_BUTTON);
	return LivePageFactoryManager.getMyDashboardPage(driver);
	
}

}
