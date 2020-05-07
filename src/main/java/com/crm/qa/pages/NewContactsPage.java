package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactsPage  extends TestBase{

	@FindBy(xpath="//div[text()='Create New Contact']")
	WebElement newcontactslabel;
	
	// Initializing the Page Objects 
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
		
		}
	
	
	
}
