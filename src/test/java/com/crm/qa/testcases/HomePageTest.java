package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	// Create constructor 
	public HomePageTest() {
	super();	
	}

	
	
	@BeforeMethod
	public void setup(){
		
		initilization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePagetitle = homepage.verifyHomePageTitle();
		AssertJUnit.assertEquals(homePagetitle, "Cogmento CRM", "Home Page title doesnt match");
		
		
	}
	@Test(priority=2)
	public void verifyusernameTest() {
		homepage.verifyCorrectusername();
		AssertJUnit.assertTrue(homepage.verifyCorrectusername());
	}
	
	
	@Test(priority=3)
	public void verifyContactslinkTest() {
		contactspage = 	homepage.Clickoncontactlink();
		
	}
	
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	
}
