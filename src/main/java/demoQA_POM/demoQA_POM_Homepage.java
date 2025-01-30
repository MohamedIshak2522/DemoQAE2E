package demoQA_POM;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import demoQA_Base.demoQA_base;

public class demoQA_POM_Homepage extends demoQA_base{
	
	@FindBy (xpath= "//img[@src='/images/Toolsqa.jpg']")
	WebElement Logo;
	@FindBy (xpath= "//img[@class='banner-image']")
	WebElement Banner;
	@FindBy (xpath="(//div[@class='category-cards']//div//div[@class='avatar mx-auto white'])")
	List<WebElement> Iconsofeachcard;
	@FindBy (xpath="(//div[@class='category-cards']//div//div[@class='card-body']/h5)")
	List<WebElement> Titleofeachcard;
	@FindBy (xpath="//img[@class='tools-qa-header__logo']")
	WebElement TrainingpageLogo;
	
	
	public demoQA_POM_Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
//================================================================
	
	public void LogoValidation() {
		Assert.assertTrue(Logo.isDisplayed());
	}
	
	public void BannerValidation() {
		Assert.assertTrue(Banner.isDisplayed());
	}
	
	public void CardValidationWithIcon () {
		
		int cardcount = Iconsofeachcard.size();
		System.out.println("Total Card Available: "+cardcount);
		for(int i=0; i<cardcount;i++) {
			WebElement cardicon = Iconsofeachcard.get(i);
			Assert.assertTrue(cardicon.isDisplayed());
		}
	}
		
	public void CardTitleValidation () {
		String [] ActualCardTitle = new String[Titleofeachcard.size()];
		
		int cardtitle = Titleofeachcard.size();
		for (int i=0; i<cardtitle;i++) {
			String cards = Titleofeachcard.get(i).getText();
			ActualCardTitle[i] = cards;
		}
			String[] ExpectedCardTitle = {"Elements","Forms","Alerts, Frame & Windows","Widgets","Interactions","Book Store Application"};
			
			Assert.assertEquals(ActualCardTitle, ExpectedCardTitle);
		}
	
	public void NavigationToTrainingPage() {
		String mainWindowHandle = driver.getWindowHandle();
		Banner.click();
		windowhandle(mainWindowHandle);
		implicitWait(10);
		Assert.assertTrue(TrainingpageLogo.isDisplayed());
	//Closing the new window and moving the main window
		driver.close();
		driver.switchTo().window(mainWindowHandle);
	}
	
	public void SelectSingleCard(String cart) {
		int totalcartsize = Titleofeachcard.size();
		System.out.println(totalcartsize);
		for(int i=0; i<= totalcartsize ; i++) {
			
			String singleCard = Titleofeachcard.get(i).getText();

			WebElement singleCardelement = Titleofeachcard.get(i);
			if(singleCard.equalsIgnoreCase(cart)) {
				javaScriptiClick(singleCardelement);
				break;
			}
						
		}
	}
	}
