package demoQA_POM;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import demoQA_Base.demoQA_base;

public class demoQA_POM_Elements extends demoQA_base{
	
	@FindBy (xpath="(//span[@class='pr-1'])[1]")
	WebElement HeaderElementicon;
	@FindBy (xpath="(//div[@class='header-text'])[1]/text()")
	WebElement HeaderElementsTitle;
	@FindBy (xpath = "(//div[@class='icon'])[1]")
	WebElement HeaderExpandIcon;
	@FindBy (xpath="(//div[@class='element-group'])[1]//div//ul")
	WebElement ExpandedElementPanel;
	@FindBy (xpath="(//div[@class='element-group'])[1]//div//ul//li")
	List<WebElement> ElementsOptions;
	@FindBy (xpath="//img[@src='/images/Toolsqa.jpg']")
	WebElement Logoimage;
	@FindBy (xpath="//div[@class='col-12 mt-4 col-md-6']/text()")
	WebElement PageBodyText;
	@FindBy (id="RightSide_Advertisement")
	WebElement Advertisement;
	
	public demoQA_POM_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//================================================
	
	public void ElementsComponent() throws InterruptedException {

		Thread.sleep(2000);
		Assert.assertTrue(HeaderElementicon.isDisplayed());
		
		//Assert.assertTrue(HeaderElementsTitle.isDisplayed()); (Have to rework later)
		
		Assert.assertTrue(HeaderExpandIcon.isDisplayed());
		Assert.assertTrue(ExpandedElementPanel.isDisplayed());

		}
	
	public void ElementsPageComponent() {
		Assert.assertTrue(Logoimage.isDisplayed());
		
//		Assert.assertTrue(PageBodyText.isDisplayed()); (Have to figure out solution)
		Assert.assertTrue(Advertisement.isDisplayed());
		
	}

/*
	public void CollapseView() throws InterruptedException {
		HeaderExpandIcon.click();
		Thread.sleep(3000);
		Assert.assertTrue(FirstExpandedElement.isEnabled());
	}
*/	
	
	public void ElementsOptions() {
		List<String> ActualOptions = new ArrayList<String>();
		int totaloptions = ElementsOptions.size();
		for(int i=0; i<totaloptions;i++) {
			String option = ElementsOptions.get(i).getText();
			
			ActualOptions.add(option);	
		}
		List<String> ExpectedOptions = new ArrayList<String>();
		ExpectedOptions.add("Text Box");
		ExpectedOptions.add("Check Box");
		ExpectedOptions.add("Radio Button");
		ExpectedOptions.add("Web Tables");
		ExpectedOptions.add("Buttons");
		ExpectedOptions.add("Links");
		ExpectedOptions.add("Broken Links - Images");
		ExpectedOptions.add("Upload and Download");
		ExpectedOptions.add("Dynamic Properties");		
		
	Assert.assertEquals(ActualOptions, ExpectedOptions);
		
	}
		
	}

