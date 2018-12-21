package live.pageObjects;
import org.openqa.selenium.WebDriver;

public class LivePageFactoryManager {
	public static MyAccountPageObject  getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static LiveHomePageObject getHomePage(WebDriver driver) {
		return new LiveHomePageObject (driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
		
	}
	
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
		
	}

}
