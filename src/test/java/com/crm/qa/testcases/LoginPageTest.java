package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



@Test
public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	// Create the const LoginPageTest as to intil... the prop with Super keyword
	public LoginPageTest() {
			super();
	}
	
	@BeforeMethod
	public void setup(){
		
		initilization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginpagetitletest() {
	String title =	loginpage.validateLoginPageTitle();
	
	Assert.assertEquals(title, "Cogmento CRM");
	}
	
	
	@Test(priority=2)
	
	public void loginTest() {
	homepage =	loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
		
	}
	
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	

}
