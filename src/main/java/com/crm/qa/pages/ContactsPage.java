package com.crm.qa.pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//Page Factory
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement NewContactLink;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="middle_initial")
	WebElement middleName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement eMail;	
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts') and @title='Contacts']")
	 WebElement Contacts;
	
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	 WebElement ContactsLink;
	
	@FindBy(xpath="//a[@title='Home']")
	WebElement Home;
	
	@FindBy(name="cs_name")
	WebElement fullName;
	
	@FindBy(name="cs_email")
	WebElement fullEmail;
	
	@FindBy(xpath="//input[@type='submit' and @name='cs_submit']")
	WebElement search;
	
	@FindBy(xpath="//input[@type='button' and @value='Delete']")
	WebElement delete;
	
	//Initializing the page objects
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean VerifyContactspage() {
		return ContactsLink.isDisplayed();

	}
	
	
	public void EnterNewConactsDetails(String tit, String fName, String lName, String email) {
		title.sendKeys(tit);
		firstName.sendKeys(fName);
		middleName.sendKeys("");
		lastName.sendKeys(lName);
		eMail.sendKeys(email);
		saveBtn.click();

	}
	
	public void VerifyEnteredContactDetails(String tit, String fName, String lName, String email) {
		Assert.assertEquals(title.getText(), tit, "Title is NOT matching");
		Assert.assertEquals(firstName.getText(), fName, "First Name is NOT matching");
		Assert.assertEquals(lastName.getText(), lName, "Last Name is NOT matching");
		Assert.assertEquals(eMail.getText(), email, "Email is NOT matching");
		
	}
	
	public HomePage clickHomeTab() {
		Home.click();
		return new HomePage();
		
	}
	
	public void searchContact(String flName, String email) {
         fullName.sendKeys(flName);
         fullEmail.sendKeys(email);
         search.click();
		
	}
	
	public void contactClick(String flName) {
		WebElement contactLink=driver.findElement(By.xpath("//a[@_name='" + flName + "' and text()='" + flName + "']"));
		contactLink.click();
	}
	
	public void deleteContact() {
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void searchforDeletedContact(String flName) {
		List<WebElement> elements = driver.findElements(By.xpath("//a[@_name='" + flName + "' and text()='" + flName + "']"));
		if (elements.isEmpty()) {
            // If empty, assert passes
            Assert.assertTrue(true, "Contact doesn't exist");
        } else {
            // If not empty, assert fails
            Assert.fail("WebElement exists: " + elements.get(0).getText());
        }

	}
	
	public void clickContactTab() {
		Contacts.click();
	}
	

}
