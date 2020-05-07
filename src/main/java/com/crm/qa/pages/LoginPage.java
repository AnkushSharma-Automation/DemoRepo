package com.crm.qa.pages;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	// PageFactory or Object Repos we need to define with @FindBy()
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='https://api.cogmento.com/register']")
	WebElement SignUpbtn;
	
	//Create the Constructor to intil..
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
		}
	
	
	// Create Method : Actions
	public String  validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
}
