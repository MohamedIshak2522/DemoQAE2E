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
public void ValidationForElementOptions() {
	elements = new demoQA_POM_Elements(driver);
//Elements side navbar components validation	
	elements.ElementsOptions();
//Logo, body and advertisement validation	
	elements.ElementsPageComponent();
	
}
}
