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

//Elements sidebar
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
//Element page componeent
	@FindBy (xpath="//img[@src='/images/Toolsqa.jpg']")
	WebElement Logoimage;
	@FindBy (xpath="//div[@class='col-12 mt-4 col-md-6']/text()")
	WebElement PageBodyText;
	@FindBy (id="RightSide_Advertisement")
	WebElement Advertisement;
//TextBox 
	@FindBy (xpath="//h1[contains(text(),'Text Box')]")
	WebElement Textboxheader;
	@FindBy (xpath="//label[@class='form-label']")
	List<WebElement> Fieldsname;
	@FindBy (xpath="//div[@class='col-md-9 col-sm-12']/input[@placeholder='Full Name']")
	WebElement Fullnameinputboxplaceholder;
	@FindBy (xpath="//div[@class='col-md-9 col-sm-12']/input[@placeholder='name@example.com']")
	WebElement Emailinputboxplaceholder;
	@FindBy (xpath="//div[@class='col-md-9 col-sm-12']/textarea[@placeholder='Current Address']")
	WebElement Currentaddrtextareaplaceholder;
	@FindBy (xpath="//div[@class='col-md-9 col-sm-12']/textarea[@id='permanentAddress']")
	WebElement Permenantaddrtextarea;
	@FindBy (xpath = "//button[@id='submit']")
	WebElement Submitbutton;
	@FindBy (xpath="//div[@class='border col-md-12 col-sm-12']/p")
	List<WebElement> resultlist;
//Check Box
	@FindBy (xpath="//h1[contains(text(),'Check Box')]")
	WebElement Checkboxheader;
	@FindBy (xpath="//button[@class='rct-option rct-option-expand-all']")
	WebElement Plustoexpand;
	@FindBy (xpath="//button[@class='rct-option rct-option-collapse-all']")
	WebElement Minustocollapse;
	@FindBy (xpath="//button[@class='rct-collapse rct-collapse-btn']")
	List<WebElement> Toggles;
	@FindBy (xpath="//span[@class='rct-checkbox']")
	List<WebElement> Checkboxes;
	@FindBy (xpath="//span[@class='rct-node-icon']")
	List<WebElement> Foldericons;
	@FindBy (xpath="//span[@class='rct-title']")
	List<WebElement> Folderandfilestitles;
	@FindBy (xpath="//div[@id='result']")
	WebElement resulttable;
//Radio Button
	@FindBy (xpath="//h1[contains(text(),'Radio Button')]")
	WebElement Radiobuttonheader;
	@FindBy (xpath="//div[contains(text(),'Do you like the site?')]")
	WebElement Feedbackquestion;
	@FindBy (xpath="//div[@class='custom-control custom-radio custom-control-inline']/input")
	List<WebElement> Enabledbuttons;
	@FindBy (xpath="//div[@class='custom-control custom-radio custom-control-inline']/label")
	List<WebElement> Enabledbtnsname;
	@FindBy (xpath="//div[@class='custom-control disabled custom-radio custom-control-inline']/input")
	List<WebElement> Disabledbuttons;
	@FindBy (xpath="//div[@class='custom-control disabled custom-radio custom-control-inline']/label")
	WebElement Disabledbtnsname;
	@FindBy (xpath="//p[contains(text(),'You have selected ')]")
	WebElement Resulttext;
	@FindBy (xpath="//p[contains(text(),'You have selected ')]/span")
	WebElement Selectedoption;
	
	


	public demoQA_POM_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//(((((((((((((((((((Reusable methods))))))))))))))))))))
	
	public List<String> StoringWebelementsInList(List<WebElement> elements) {
		List<String> ActualOptions = new ArrayList<String>();
		int totaloptions = elements.size();
		for(int i=0; i<totaloptions;i++) {
			String option = elements.get(i).getText();

			ActualOptions.add(option);	
		}
		return ActualOptions;
	}

//We can reuse this method to click any options under Elements	
	public void ClickAnyElementoptions(String ouroption) {
		for(int i=0;i<ElementsOptions.size();i++) {
			String options = ElementsOptions.get(i).getText();
			if(options.equalsIgnoreCase(ouroption)) {
				ElementsOptions.get(i).click();
			}
		}
	}	


//((((((((((((((((((((Main methods)))))))))))))))))))))))))

	public void ElementsComponent() throws InterruptedException {

		Thread.sleep(2000);
//~~Validation
		Assert.assertTrue(HeaderElementicon.isDisplayed());
	//Assert.assertTrue(HeaderElementsTitle.isDisplayed()); (Have to rework later)
		Assert.assertTrue(HeaderExpandIcon.isDisplayed());
		Assert.assertTrue(ExpandedElementPanel.isDisplayed());

	}

	public void ElementsPageComponent() {
//~~Validation
		Assert.assertTrue(Logoimage.isDisplayed());
	//Assert.assertTrue(PageBodyText.isDisplayed()); (Have to figure out solution)
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
		List<String> ActualOptions = StoringWebelementsInList(ElementsOptions);

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
//~~Validation
		Assert.assertEquals(ActualOptions, ExpectedOptions);
	}

	public void TextBoxComponents(String option) {
		ClickAnyElementoptions(option);
		
		List<String> ActualOptions = StoringWebelementsInList(Fieldsname);
		
		List<String> ExpectedOptions = new ArrayList<String>();
		ExpectedOptions.add("Full Name");
		ExpectedOptions.add("Email");
		ExpectedOptions.add("Current Address");
		ExpectedOptions.add("Permanent Address");
		
//~~Validation
		Assert.assertEquals(ActualOptions, ExpectedOptions);
		Assert.assertTrue(Fullnameinputboxplaceholder.isDisplayed());
		Assert.assertTrue(Emailinputboxplaceholder.isDisplayed());
		Assert.assertTrue(Currentaddrtextareaplaceholder.isDisplayed());
		Assert.assertTrue(Permenantaddrtextarea.isDisplayed());
		Assert.assertTrue(Submitbutton.isEnabled());
	}
	
	public void FillingTextboxesAndValidate(String name, String email) {
		Fullnameinputboxplaceholder.sendKeys(name);
		Emailinputboxplaceholder.sendKeys(email);
		Currentaddrtextareaplaceholder.sendKeys("xxx\nyyy\nzzz");
		Permenantaddrtextarea.sendKeys("xxx\nyyy\nzzz");
		javaScriptiClick(Submitbutton);
		
		List<String> actualresults = StoringWebelementsInList(resultlist);
		
		List<String> expectedresults = new ArrayList<String>();
		expectedresults.add("Name:"+name);
		expectedresults.add("Email:"+email);
		expectedresults.add("Current Address :xxx yyy zzz");
		expectedresults.add("Permananet Address :xxx yyy zzz");
		
//~~Validation		
		Assert.assertEquals(actualresults, expectedresults);	
	}
	
	public void CheckBoxComponents(String option) throws InterruptedException {
		ClickAnyElementoptions(option);
//~~Validation			
		Assert.assertTrue(Checkboxheader.isDisplayed());
		
		javaScriptiClick(Plustoexpand);
		
		for (int i=0; i<Checkboxes.size();i++) {
		String checkbox = Folderandfilestitles.get(i).getText();
		System.out.println(checkbox);
		if(checkbox.equals("Downloads") || checkbox.equals("Desktop") || checkbox.equals("Documents")) {
				javaScriptiClick(Checkboxes.get(i));
		}
//~~Validation	
		Assert.assertTrue(Checkboxes.get(i).isDisplayed(), "Checkbox not displayed");
		Assert.assertTrue(Foldericons.get(i).isDisplayed());
		
		}
		int Expectedtoggles = 6;
		int Actualtoggles = Toggles.size();
		int Expectedcheckboxes = 17;
		int Actualcheckboxes = Folderandfilestitles.size();
		
//~~Validation	
			Assert.assertEquals(Actualtoggles, Expectedtoggles);
			Assert.assertEquals(Actualcheckboxes, Expectedcheckboxes);
			Assert.assertTrue(resulttable.isDisplayed());
	}
	
	public void RadioButtonComponents(String option) {
		ClickAnyElementoptions(option);
//~~Validation		
		Assert.assertTrue(Radiobuttonheader.isDisplayed());
		Assert.assertTrue(Feedbackquestion.isDisplayed());
		
		for (int i=0; i<Enabledbuttons.size();i++) {
//~~Validation	
			Assert.assertTrue(Enabledbuttons.get(i).isEnabled());
		}
		
		for (int i=0; i<Disabledbuttons.size();i++) {
//~~Validation
			Assert.assertFalse(Disabledbuttons.get(i).isEnabled());
		}
		
		List<String> actualoption = StoringWebelementsInList(Enabledbtnsname);
		List<String> expectedoption = new ArrayList<String>();
		expectedoption.add("Yes");
		expectedoption.add("Impressive");
//~~Validation
		Assert.assertEquals(actualoption, expectedoption);
		Assert.assertEquals(Disabledbtnsname.getText(), "No");
		
	}
	
	public void RadioButtonFunctionality() {
		for (int i=0;i<Enabledbuttons.size();i++) {
			javaScriptiClick(Enabledbuttons.get(i));
			
			if(Enabledbuttons.get(i).isSelected()) {
				String Activeoption = Enabledbtnsname.get(i).getText();			
				String Resultoption = Selectedoption.getText();
				
				Assert.assertTrue(Resulttext.isDisplayed());
				Assert.assertEquals(Activeoption, Resultoption);
			}
				
		}
	}

}

