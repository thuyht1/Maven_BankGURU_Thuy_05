package commons;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankguru.BankAbstractPageUI;
import live.pageObjects.LiveHomePageObject;
import live.pageObjects.LivePageFactoryManager;
import live.pageObjects.MyAccountPageObject;
import live.pageUIs.LiveAbstractPageUI;
import pageObjects.BankEditCustomerPageObject;
import pageObjects.BankHomePageObject;
import pageObjects.BankNewAccountPageObject;
import pageObjects.BankNewCustomerPageObject;
import pageObjects.BankPageManagerDriver;
//import pageObjects.EditCustomerPageObject;
//import pageObjects.HomePageObject;
//import pageObjects.NewAccountPageObject;
//import pageObjects.NewCustomerPageObject;
//import pageObjects.PageManagerDriver;

public class AbstractPage {

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}
	
	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	} 
	//no
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void clickToElement (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void clickToElement1 (WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	//no
	public void sendKeyToElement(WebDriver driver, String locator, String inputValue, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("---Sendkey to dynamic element: " + locator + "----");
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(inputValue);
		
		
	}
	
	public void selectItemInDropDown (WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String dropdown, String listItems, String valueItem) throws Exception {
	WebElement dropdownElement = driver.findElement (By.xpath(dropdown));
	WebDriverWait wait = new WebDriverWait(driver, longTimeout);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
	dropdownElement.click();
	List<WebElement> allItems = driver.findElements(By.xpath(listItems));
	wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
	for (WebElement item : allItems) {
		if (item.getText().trim().equals(valueItem)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
			item.isDisplayed();
			item.click();
			break;
		}
	}
	}
	
	public String getFirstSelectedItem (WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}
	
	//No
	public String getTextInElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public int getSizeElement(WebDriver driver, String locator) {
		List <WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public boolean checkTheCheckBox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		if (element.isSelected()) {
		return true;
		} else {
			return false;
		}
		}
	
	
	public void unCheckTheCheckBox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public void acceptToAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelToAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	//No
	public String getTextAlert (WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	//No
	public void sendKeyToAlert (WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		 alert.sendKeys(value);
	}
	//No
	public boolean switchToWindowByID(WebDriver driver,  String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				// switch qua id do
				driver.switchTo().window(runWindows);
				// Dong ID
				driver.close();
			}
		}
		// Switch qua parent Windows ID
		driver.switchTo().window(parentWindow);
		// Kiem tra no chi con lai 1 window (parent)
		if (driver.getWindowHandles().size() == 1)
			// return lai gia tri cho ham closeAllWithoutParentWindows
			return true;
		else
			return false;

	}
	//No
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentTitle = driver.getTitle();
			if (currentTitle.equals(title)) {
				break;
			}
		}

	}
	//No
	public void switchToIframe (WebDriver driver, String locator) {
	WebElement element = driver.findElement(By.xpath(locator));
	driver.switchTo().frame(element);
	}
	//No
	public void doubleClick (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
//No
	public void  hoverMouse (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void  hoverToElement (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	
	public void uploadFile(WebDriver driver, String fileName) {
		String proDir = System.getProperty("user.dir");
		String filePath = proDir + "\\fileUpload" + fileName;
		WebElement element = driver.findElement(By.xpath("input[@type='file']"));
		element.sendKeys(filePath);
	}
	//No
	public void  rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element);
	}
	//No
	public void  dragAndDrop(WebDriver driver, String draggable, String droptarget) {
		WebElement sourceElement = driver.findElement(By.xpath(draggable));
		WebElement targetElement = driver.findElement(By.xpath(droptarget));
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement).perform();
	}
	//No
	public void keyPressElement(WebDriver driver, String locator, int index) {
		List<WebElement> listNumbers = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		listNumbers.get(index).click();
		action.keyUp(Keys.CONTROL).build().perform();
	}
	
	public void pressKeyForElement(WebDriver driver, String locator, Keys keyname) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, keyname);
	}
	//No
	public void uploadBySendkeys_API(WebDriver driver, String locator, String imagePath) {
		String workingDirectory = System.getProperty("user.dir");
		String filePath = workingDirectory + imagePath;
		WebElement addFiles = driver.findElement(By.xpath(locator));
		addFiles.sendKeys(filePath);
	}

//No
	public void uploadByAutoIT(WebDriver driver, String locator, String imagePath, String autoITBrowserPath) throws Exception {
		String workingDirectory = System.getProperty("user.dir");
		String filePath = workingDirectory + imagePath;
		WebElement addFiles = driver.findElement(By.xpath(locator));
		addFiles.click();
		Runtime.getRuntime().exec(new String[] {autoITBrowserPath, filePath });
	}
	//No
	public Object executeJSForBrowserElement(WebDriver driver, String javaScript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaScript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
//No
	public Object clickByJSForWebElement (WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);		
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	//No
	public Object scrollToBottomPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	//No
	public Object srollToElement (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.id(locator));
		return ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	//No
	public void waitForControlPresence (WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
	}
	//No
	public void waitForControlPrecence(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForControlVisible (WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}
	
	//No
	public void waitControlVisible(WebDriver driver, String locator, String value){
		locator = String.format(locator, value);
		System.out.println("----Wait for element visible: " + locator + "----");
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}
	
	public void waitForControlInvisible(WebDriver driver, String locator) { 
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}
	//No
	public void waitForAlertPresence(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}	
	
	/*  BANK GURU PAGEs*/
	public BankNewCustomerPageObject openNewCustomerPage (WebDriver driver) {
		waitForControlVisible(driver, BankAbstractPageUI.NEW_CUSTOMER_PAGE_LINK);
		clickToElement(driver, BankAbstractPageUI.NEW_CUSTOMER_PAGE_LINK);
		return BankPageManagerDriver.getNewCustomerPage(driver);
	}
	
	public BankEditCustomerPageObject openEditCustomerPage (WebDriver driver) {
		waitForControlVisible(driver, BankAbstractPageUI.EDIT_CUSTOMER_PAGE_LINK);
		clickToElement(driver, BankAbstractPageUI.EDIT_CUSTOMER_PAGE_LINK);
		return BankPageManagerDriver.getEditCustomerPage(driver);
	}

	public BankNewAccountPageObject openNewAccountPage (WebDriver driver) {
		waitForControlVisible(driver, BankAbstractPageUI.NEW_ACCOUNT_PAGE_LINK);
		clickToElement(driver, BankAbstractPageUI.NEW_ACCOUNT_PAGE_LINK);
		return BankPageManagerDriver.getNewAccountPage(driver);
	}
	public BankHomePageObject openHomePage (WebDriver driver) {
		waitForControlVisible(driver, BankAbstractPageUI.HOME_PAGE_LINK);
		clickToElement(driver, BankAbstractPageUI.HOME_PAGE_LINK);
		return BankPageManagerDriver.getHomePage(driver);
	}
 
	/* LIVE GURU PAGES*/
	public MyAccountPageObject openMyAccountPage(WebDriver driver) {
		waitControlVisible(driver, LiveAbstractPageUI.DYNAMIC_FOOTER_LINK, "My Account");
		clickToElement1(driver, LiveAbstractPageUI.DYNAMIC_FOOTER_LINK, "My Account");
		return LivePageFactoryManager.getMyAccountPage(driver);
	}
	public void clickToDynamicButton(WebDriver driver, String titleName) {
		waitControlVisible(driver, LiveAbstractPageUI.DYNAMIC_BUTTON, titleName);
		clickToElement1(driver, LiveAbstractPageUI.DYNAMIC_BUTTON, titleName);
		
			}
	
	public void sendkeyToDynamicTextbox(WebDriver driver, String textboxName, String value) {
		waitControlVisible(driver, LiveAbstractPageUI.DYNAMIC_TEXTBOX_RADIO_CHECKBOX, textboxName);
		sendKeyToElement(driver, LiveAbstractPageUI.DYNAMIC_TEXTBOX_RADIO_CHECKBOX, value, textboxName);
		
	}
	

	public LiveHomePageObject openLogoutPage(WebDriver driver) {
		waitControlVisible(driver, LiveAbstractPageUI.DYNAMIC_HEADER_LABEL_TEXT, "Account");
		clickToElement1(driver, LiveAbstractPageUI.DYNAMIC_HEADER_LABEL_TEXT, "Account");
		waitControlVisible(driver, LiveAbstractPageUI.DYNAMIC_HEADER_LINK, "Log out");
		clickToElement1 (driver, LiveAbstractPageUI.DYNAMIC_HEADER_LINK, "Log out");
		return LivePageFactoryManager.getHomePage(driver);
	}
	
	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}
	
	private int longTimeout = 30;
	private long shortTimeout = 5;

}

















