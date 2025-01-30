package demoQA_Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demoQA_Base.demoQA_base;
import demoQA_Constant.Constants;
import demoQA_POM.demoQA_POM_Homepage;

public class test_HomePage extends demoQA_base{
	demoQA_POM_Homepage home;

@BeforeClass
	public void LaunchBrowserAndURL() {
		launchBrowser("chrome");
		openURL("https://demoqa.com/");
		
	}
	
@Test (priority=1)
	public void TitleValidation () throws InterruptedException {	
	implicitWait(15);
	
	String expectedTitle = "DEMOQA";
	String actualTitle = driver.getTitle();
	
//--Validation for Title	
	Assert.assertEquals(actualTitle, expectedTitle);	
}

@Test (priority=2)
	public void HomePageComponentValidation() {
	home = new demoQA_POM_Homepage(driver);
		
//--Validation for Logo is displayed
		home.LogoValidation();
		
//--Validation for Banner is displayed
		home.BannerValidation();
}

@Test (priority=3)
	public void CardValidation() {
	home = new demoQA_POM_Homepage(driver);
//--Validation for card with displayed icons.
		home.CardValidationWithIcon();			
		}

@Test (priority=4)
public void CardTitleValidation() {
	home = new demoQA_POM_Homepage(driver);
//--Validation for card title
	home.CardTitleValidation();			
	}

@Test (priority=5)
public void TrainingPageNavigation() {
	home = new demoQA_POM_Homepage(driver);
//--Validation for training page validation
	home.NavigationToTrainingPage();
}

@AfterClass
public void CloseTheBrowser() {
	closeBrowser();
}

}
