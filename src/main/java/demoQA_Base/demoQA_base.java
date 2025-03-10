package demoQA_Base;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demoQA_Constant.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demoQA_base {
	
	public static WebDriver driver;
	
//--->Constants-Property
			public void propertyFile() throws IOException {
				FileInputStream input = new FileInputStream("config.properties");
				
				Properties prop = new Properties();

				prop.load(input);
				
				Constants.Browser = prop.getProperty("browser");
				Constants.URL = prop.getProperty("url");		
			
			}		
//--->Launch Browser
	
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
//--->Open URL
	public void openURL(String URL) {
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		
	}
	
//--->Close the browser
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
//--->Implicit Wait
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
//--->Explicit Waits
	public void explicitWaituntilVisibility(WebElement element, int waitseconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitseconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaituntilClickable(WebElement element, int waitseconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitseconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
//---> JavaScript Click
	public void javaScriptiClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
//--> SenKeys
	public void SendKeys(WebElement element, String input) {
		element.clear();
		element.sendKeys(input);
	}
//---> Double click
	public void doubleclickwithActionclass(WebElement element, WebElement moveele) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(moveele).build().perform();;
		Thread.sleep(1000);
		action.doubleClick(element).perform();
	}
//---> Right Click
	public void rightclickwithActionclass(WebElement element, WebElement moveele) throws InterruptedException {
		Actions action = new Actions(driver);
//		org.openqa.selenium.Point location =  element.getLocation();
//		action.moveByOffset(location.getX(), location.getY()).perform();
		
		action.moveToElement(moveele).build().perform();
		Thread.sleep(1000);
		action.contextClick(element).perform();
	}

//--->Windows Handle
	public void windowhandle(String mainWindowHandle) {
	        // Get all window handles
	        Set<String> allWindowHandles = driver.getWindowHandles();

	        // Switch to the new window (it should be the second window in the set)
	        for (String handle : allWindowHandles) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	                break;  // Switch to the new window and break the loop
	            }
	        }
	}
}
