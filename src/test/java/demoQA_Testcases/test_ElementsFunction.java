package demoQA_Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demoQA_Base.demoQA_base;
import demoQA_POM.demoQA_POM_Elements;
import demoQA_POM.demoQA_POM_Homepage;

public class test_ElementsFunction extends demoQA_base{
	demoQA_POM_Elements elements;
	demoQA_POM_Homepage homepage;
	
@BeforeClass
	public void LaunchBrowserAndURL() {
		launchBrowser("chrome");
		openURL("https://demoqa.com/");		
	}

@Test (priority=1)
public void ValidatationForNavigationToElements() throws InterruptedException {
	homepage = new demoQA_POM_Homepage(driver);
	homepage.SelectSingleCard("Elements");
	
	elements = new demoQA_POM_Elements(driver);
	elements.ElementsComponent();	
	
}

/* This will be taken care later
@Test (priority=2)
public void ValidateCollapse() throws InterruptedException {
	elements = new demoQA_POM_Elements(driver);
	elements.CollapseView();
}
*/

@Test (priority =2)
public void ValidationForElementComponentOptions() {
	elements = new demoQA_POM_Elements(driver);
//Elements side navbar components validation	
	elements.ElementsOptions();
//Logo, body and advertisement validation	
	elements.ElementsPageComponent();	
}

@Test (priority =3)
public void ValidationForTextBoxComponents() {
	elements = new demoQA_POM_Elements(driver);
	elements.TextBoxComponents("Text Box");	
}

@Test (priority =4)
public void ValidationForTextBoxFunctionality() {
	elements = new demoQA_POM_Elements(driver);
	elements.FillingTextboxesAndValidate("Test Name", "testemail@test.com");
}

@Test (priority =5)
public void ValidationForCheckBoxComponents() throws InterruptedException {
	elements = new demoQA_POM_Elements(driver);
	elements.CheckBoxComponents("Check Box");
}

@Test (priority =6)
public void ValidationForRadioButton() {
	elements = new demoQA_POM_Elements(driver);
	elements.RadioButtonComponents("Radio Button");
	elements.RadioButtonFunctionality();
}

}
