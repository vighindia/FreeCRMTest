package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.pages.HomePage;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
		
		}
	
	@BeforeMethod	
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitletest() {
		String Title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Free CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2)
	public void validatefreecrmLinkTest() {
		Assert.assertEquals(loginpage.validatefreecrmLink(), true, "Free CRM Link is not displayed");
		
	}
	
	@Test(priority=3)
	public void validatePricingLinkTest() {
		String PricingText=loginpage.clickPricingLink();
		Assert.assertEquals(PricingText, "Cloud CRM", "PricingText is NOT matching");
		
	}
	
	@Test(priority=4)
	public void EnterLoginCredentialsTest() {
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		homePage=loginpage.EnterLoginCredentials(username, password);
	}
	
	@Test(priority=4)
	public void LogoutTest() {
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		homePage=loginpage.EnterLoginCredentials(username, password);
		driver.switchTo().frame("mainpanel");
		homePage.ClickLogout();
		Assert.assertEquals(loginpage.validatefreecrmLink(), true, "Free CRM Link is not displayed");
	
	}
	
	
	@AfterMethod	
	public void teardown() {
		driver.quit();
	}


}
