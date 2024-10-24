package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public  class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod	
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		contactsPage = new ContactsPage();
		dealsPage=new DealsPage();
		tasksPage=new TasksPage();
		loginPage.EnterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePageTitle() {
		String Title=homePage.verifyHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO", "Home Page Title Not Matching");	
	}
	
	@Test(priority=2)
	public void validateloggedinUserName() {
		driver.switchTo().frame("mainpanel");
		String UserName=homePage.verifyloggedinUserName();
		Assert.assertEquals(UserName.trim(), "User: Vighnesh Prabhu", "Logged in User's name is not matching");	
	}
	
	@Test(priority=3)
	public void validateclickContacts() {
		driver.switchTo().frame("mainpanel");
		contactsPage=homePage.clickContacts(); 
		String Contacts=driver.findElement(By.xpath("//td[contains(text(), 'Contacts')]")).getText();
		Assert.assertEquals(Contacts, "Contacts", "Contacts is not displayed");
	}
	
	@Test(priority=4)
	public void validateclickDeals() {
		driver.switchTo().frame("mainpanel");
		dealsPage=homePage.clickDeals(); 
		Boolean Deals =driver.findElement(By.xpath("//td[contains(text(), 'Deals')]")).isDisplayed();
		Assert.assertEquals(Deals, true, "Deals is not displayed");
		
	}
	
	@Test(priority=5)
	public void validateclickTasks() {
		driver.switchTo().frame("mainpanel");
		tasksPage=homePage.clickTasks(); 
		Boolean Tasks =driver.findElement(By.xpath("//td[contains(text(), 'Tasks')]")).isDisplayed();
		Assert.assertEquals(Tasks, true, "Tasks is not displayed");
	}
	
	
	@AfterMethod	
	public void teardown() {
		driver.quit();
	}

	
	

}
