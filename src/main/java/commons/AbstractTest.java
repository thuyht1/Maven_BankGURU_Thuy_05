package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AbstractTest {
	WebDriver driver;

	public WebDriver openMultiBrowser(String browserName, String url) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver",
			// ".\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=13366x768");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("ie11")) {
			System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Can't not int browser");
		}

		//driver.get("http://demo.guru99.com/v4/");
		driver.get("http://live.guru99.com");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public int randomEmail() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}

}
