package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
	
	@FindBy(name="username")
	 WebElement username;
	
	@FindBy(name="password")
	 WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement freeCRM;
	
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement pricing;
	
	@FindBy(xpath="//h1[contains(text(), 'Cloud CRM')]")
	WebElement pricingText;
	
	//Initializing the page objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();  
	 
	}
	
	public  boolean validatefreecrmLink() {
		
		return  freeCRM.isDisplayed();
	 
	}
	
	
	public HomePage EnterLoginCredentials(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
    	JavascriptExecutor js =  (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		
		return new HomePage();
	 
	}
	
	public String clickPricingLink() {
		 
		pricing.click();
		return pricingText.getText();
		
		
	}
		 

	
	
}
