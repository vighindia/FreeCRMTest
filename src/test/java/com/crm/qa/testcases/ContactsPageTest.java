package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}

	
	@BeforeMethod	
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		contactsPage = new ContactsPage();
		loginPage.EnterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		driver.switchTo().frame("mainpanel");
	}
	
	@Test(priority=1)
	@Ignore
	public void validateContactspage() {
		homePage.clickContacts();
		boolean contacts=contactsPage.VerifyContactspage();
           Assert.assertEquals(contacts, true, "Contacts page is not displayed");        
	}
	
	@DataProvider
	
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	@Ignore
	public void validateEnterNewConactsDetails(String title, String firstName, String lastName, String email) {
		homePage.ClickNewConactsLink();
		contactsPage.EnterNewConactsDetails(title, firstName, lastName, email);
		contactsPage.VerifyEnteredContactDetails(title, firstName, lastName, email);
		contactsPage.clickContactTab();
		String flName=firstName+" "+lastName;
		contactsPage.searchContact(flName, email);
		contactsPage.contactClick(flName);
		contactsPage.VerifyEnteredContactDetails(title, firstName, lastName, email);
		contactsPage.deleteContact();
		contactsPage.searchContact(flName, email);
		contactsPage.searchforDeletedContact(flName);	
	}
	
	@AfterMethod	
	public void teardown() {
		driver.quit();
	}


}
