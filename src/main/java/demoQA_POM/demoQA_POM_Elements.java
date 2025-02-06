package demoQA_POM;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
//Web Table
	@FindBy (xpath="//h1[contains(text(),'Web Tables')]")
	WebElement WebTableheader;
	@FindBy (id="addNewRecordButton")
	WebElement WT_addbutton;
	@FindBy (id="searchBox")
	WebElement WT_searchbox;
	@FindBy (xpath="//div[@class='rt-tr']/div/div[@class='rt-resizable-header-content']")
	List<WebElement> WT_Tableheaders;
	@FindBy (xpath="//div[@class='rt-tbody']/div")
	List<WebElement> WT_totalrows;
	@FindBy (xpath="//span[@class='-pageInfo']")
	WebElement WT_pageinfo;
	@FindBy (xpath="//select[@aria-label='rows per page']")
	WebElement WT_rowcountdrpdwn;
	@FindBy (xpath="//select[@aria-label='rows per page']/option")
	List<WebElement> WT_rowcountoptions;
	@FindBy (xpath="//button[contains(text(),'Previous')]")
	WebElement WT_previosbtn;
	@FindBy (xpath="//button[contains(text(),'Next')]")
	WebElement WT_nextbtn;
	@FindBy (xpath="//input[@id='firstName']")
	WebElement wt_addfname;
	@FindBy (xpath="//input[@id='lastName']")
	WebElement wt_addlname;
	@FindBy (xpath="//input[@id='userEmail']")
	WebElement wt_addemailaddr;
	@FindBy (xpath="//input[@id='age']")
	WebElement wt_addage;
	@FindBy (xpath="//input[@id='salary']")
	WebElement wt_addsalary;
	@FindBy (xpath="//input[@id='department']")
	WebElement wt_adddept;
	@FindBy (xpath="//button[contains(text(),'Submit')]")
	WebElement wt_submit;
	
	
	
	


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
				javaScriptiClick(ElementsOptions.get(i));
			}
		}
	}

// We use this method to read specific row values in web table
	public List<String> ReadWebTableRows(List<String> actualrowvalue, String fname) {
		for (int i=1;i<=WT_totalrows.size();i++) {
			List<WebElement> values =  driver.findElements(By.xpath("(//div[@class='rt-tbody']/div/div)["+i+"]/div"));
			String fnamevalue = values.get(0).getText();
			if(fnamevalue.equalsIgnoreCase(fname)) {
				for (int j=0;j<(values.size())-1;j++) {
					String actualvalue = values.get(j).getText();
					actualrowvalue.add(actualvalue);					
				}
				break;
			}
		}
		return actualrowvalue;
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
	
//*************Text Box Methods

	public void TextBoxComponents(String option) {
		ClickAnyElementoptions(option);
		
		List<String> ActualOptions = StoringWebelementsInList(Fieldsname);
		
		List<String> ExpectedOptions = new ArrayList<String>(Arrays.asList("Full Name","Email","Current Address","Permanent Address"));

		
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
	
//*************Check Box Methods
	
	public void CheckBoxComponents(String option) throws InterruptedException {
		ClickAnyElementoptions(option);
//~~Validation			
		Assert.assertTrue(Checkboxheader.isDisplayed());
		
		javaScriptiClick(Plustoexpand);
		
		for (int i=0; i<Checkboxes.size();i++) {
		String checkbox = Folderandfilestitles.get(i).getText();

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
	
//*************Radio Button Methods
	
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
//~~Validation
				Assert.assertTrue(Resulttext.isDisplayed());
				Assert.assertEquals(Activeoption, Resultoption);
			}
				
		}
	}
//*************Web Table Methods
	
	public void WebTableComponents(String option) {
		ClickAnyElementoptions(option);
//~~Validation
		Assert.assertTrue(WebTableheader.isDisplayed());
		Assert.assertTrue(WT_addbutton.isEnabled());
		Assert.assertTrue(WT_searchbox.isDisplayed());
		Assert.assertTrue(WT_pageinfo.isDisplayed());
		Assert.assertTrue(WT_previosbtn.isDisplayed());
		Assert.assertTrue(WT_nextbtn.isDisplayed());
		Assert.assertTrue(WT_rowcountdrpdwn.isDisplayed());
		
		List<String> Actualtableheaders = StoringWebelementsInList(WT_Tableheaders);
		List<String> Expectedtableheaders = new ArrayList<String>(Arrays.asList("First Name","Last Name","Age","Email","Salary","Department","Action"));

//~~Validation
		Assert.assertEquals(Actualtableheaders, Expectedtableheaders);
		
	}
	
	public void RowsCountValidation() throws InterruptedException {
		Select select = new Select(WT_rowcountdrpdwn);
		for (WebElement numofrow : WT_rowcountoptions) {
			explicitWaituntilVisibility(numofrow, 20);
			String Rowoption = numofrow.getText();
			select.selectByVisibleText(Rowoption);
			
			String selectedrows = Rowoption.replaceAll("[^0-9]", "");
			int selectedcount = Integer.parseInt(selectedrows);
			int totalrowsintable = WT_totalrows.size();
//~~Validation	
			Assert.assertEquals(selectedcount, totalrowsintable);
		}
	}
	
	public void AddingNewRecordValidation(String fname, String Lname, String Email, String age, String Salary, String department) throws InterruptedException {
		javaScriptiClick(WT_addbutton);
		
		wt_addfname.sendKeys(fname);
		wt_addlname.sendKeys(Lname);
		wt_addemailaddr.sendKeys(Email);
		wt_addage.sendKeys(age);
		wt_addsalary.sendKeys(Salary);
		wt_adddept.sendKeys(department);
		javaScriptiClick(wt_submit);
		
		List<String> actualrow = new ArrayList<String>();
		List<String> expectedrowvalue = new ArrayList<String>(Arrays.asList(fname, Lname, age, Email, Salary, department));

		List<String> actualrowvalue= ReadWebTableRows(actualrow, fname);

//~~Validation	
		Assert.assertEquals(actualrowvalue, expectedrowvalue);
	}
	
	public void EditRecordValidation(String fname, String Lname, String Email, String age, String Salary, String department) {
		
		List<String> actualrow = new ArrayList<String>();
		List<String> expectedrowvalue = new ArrayList<String>(Arrays.asList(fname, Lname, age, Email, Salary, department));
		
		for (int i=1;i<=WT_totalrows.size();i++) {
			List<WebElement> values =  driver.findElements(By.xpath("(//div[@class='rt-tbody']/div/div)["+i+"]/div"));
			String fnamevalue = values.get(0).getText();
			if(fnamevalue.equalsIgnoreCase("TE")) {
				
				WebElement editicon = driver.findElement(By.xpath("(//div[@class='rt-tbody']/div/div)["+i+"]/div/div/span[@title='Edit']"));
				explicitWaituntilClickable(editicon, 20);
				
				Assert.assertTrue(editicon.isDisplayed());
				javaScriptiClick(editicon);
				
				explicitWaituntilClickable(wt_submit, 20);
					
				SendKeys(wt_addfname, fname);
				SendKeys(wt_addlname, Lname);
				SendKeys(wt_addemailaddr, Email);
				SendKeys(wt_addage, age);
				SendKeys(wt_addsalary, Salary);
				SendKeys(wt_adddept, department);
				javaScriptiClick(wt_submit);
			}
		}
				
				List <String> actualrowvalue = ReadWebTableRows(actualrow, fname);
//~~Validation	
				Assert.assertEquals(actualrowvalue, expectedrowvalue);
		
	}

}

