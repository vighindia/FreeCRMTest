package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


	
public class HomePage extends TestBase {
	
		
		//Page Factory
		
		@FindBy(xpath="//td[contains(text(),'Vighnesh Prabhu')]")
		 WebElement loggedinUserName;
		
		@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
		 WebElement HomePageTitle;
		
		@FindBy(xpath="//a[@title='Contacts']")
		 WebElement Contacts;
		
		@FindBy(xpath="//a[contains(text(), 'Deals')]")
		 WebElement Deals;
		
		@FindBy(xpath="//a[@title='Tasks']")
		 WebElement Tasks;
		
		@FindBy(xpath="//a[contains(text(),'New Contact')]")
		WebElement NewContactLink;
		
		@FindBy(xpath="//a[contains(text(),'New Task')]")
		WebElement NewTaskLink;
		
		@FindBy(xpath="//a[@href='https://classic.freecrm.com/index.cfm?logout=1']")
		WebElement logout;    

		//Initializing the page objects
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		
		public String verifyHomePageTitle() {
			
			return driver.getTitle();
		}
		
		public String verifyloggedinUserName() {
			
			return loggedinUserName.getText();
		}
		
        public ContactsPage clickContacts() {
			
        	Contacts.click();
			
			return new ContactsPage();
		}
        
        public DealsPage clickDeals() {
			
			Deals.click();
			
			return new DealsPage();
		}
		
        public TasksPage clickTasks() {
			
			Tasks.click();
			
			return new TasksPage();
		}
        
    	public ContactsPage ClickNewConactsLink() {
    		Actions actions = new Actions(driver);
    	    actions.moveToElement(Contacts).build().perform();
    	    NewContactLink.click();
			return new ContactsPage();

    	}
    	
    	public void ClickConactsLink() {
    		Actions actions = new Actions(driver);
    	    actions.moveToElement(Contacts).build().perform();
    	    NewContactLink.click();

    	}
    	
    	public void ClickLogout() {
    		logout.click();

    	}

		
		
}
	
