package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactslabel;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement svtBtn;
	
	// Initializing the Page Objects 
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
		}
	
	 public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	 }
	 
	 public void selectContactsByName(String name) {
		 driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
			
		 
	 }
	 
	 public void createNewContact(String ftname, String ltname) {
		 firstname.sendKeys(ftname);
		 lastname.sendKeys(ltname);
		 
		 svtBtn.click();
		 
		 
	 }

}
