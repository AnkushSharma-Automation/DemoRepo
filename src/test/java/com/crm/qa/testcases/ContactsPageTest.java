package com.crm.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest  extends TestBase{
	
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	String sheetName="contacts";
	
	
	public ContactsPageTest() {
		PageFactory.initElements(driver, this);
		
		}

	@BeforeMethod
	public void setup(){
		
		initilization();
		contactspage = new ContactsPage(); // create the object 
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
		contactspage = homepage.Clickoncontactlink();
	
		
	}
	
	
	
	
	
	  @Test(priority=1) public void verifyContansPagelabel() {
	  Assert.assertTrue(contactspage.verifyContactsLabel()
	  ,"contacts label is missing"); driver.navigate().refresh(); }
	 
	
	
	  @Test(priority=2) public void selectContactsText() {
		  driver.navigate().refresh();	  
	  contactspage.selectContactsByName("EVOL Mishra");
	  
	  
	  
	  }
	  
	  // read data from sheet by @dataprovider annotations in TestUtil package we have created the method to store data in 2d object array
	  @DataProvider
	  public Object [][] getCRMTestData() {
		Object data [][]  =  TestUtil.getTestData(sheetName);
		return data;
		  
	  }
	  
	  
	  @Test(priority=3,dataProvider="getCRMTestData")
	  public void validateCreatenewContact(String firstname, String lastname) {
		homepage.ClickOnNewContactlink();
		driver.navigate().refresh();
		driver.navigate().refresh();
		contactspage.createNewContact(firstname, lastname);
		
	//	contactspage.createNewContact("Lion", "King");
		  
		  
	  }
	 
	
	
	
	
	
	
	  @AfterMethod public void Teardown() { driver.quit();
	  
	  }
	 
	 
	
}
