package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage  extends TestBase {

	@FindBy(xpath="//span[text()='Ankush Sharma']")
	WebElement  usernamelabel;
	//It will store the location in cache so speed of framework is improved @@CacheLookup	
	@CacheLookup
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement newContactLink;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement Newcontact;
	
	
	// Initial the page object
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
		}
	
	public  boolean verifyCorrectusername() {
		return usernamelabel.isDisplayed();
	}
	
	
	public String verifyHomePageTitle() {
	return driver.getTitle();
	}
	
	

	
	public ContactsPage Clickoncontactlink() {
		contactsLink.click();
		
		return new ContactsPage();
		
		
	}


	
	public TasksPage ClickonTasksPageLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void ClickOnNewContactlink() {
		contactsLink.click();
		//driver.navigate().refresh();
		Newcontact.click();
		
	}

	
}
