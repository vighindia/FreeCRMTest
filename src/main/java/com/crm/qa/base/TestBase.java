package com.crm.qa.base;

import java.io.FileInputStream;	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
		prop= new Properties();
		FileInputStream fip = new FileInputStream("/Users/VKPRABHU/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
		prop.load(fip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

    
     public static void initialization(){
    	 
    	 String browserName=prop.getProperty("browser");
    	 
    	 if (browserName.equals("chrome")) {
    		 System.setProperty("webdriver.chrome.driver", "/Users/VKPRABHU/Documents/chrome/chromedriver");
    		 driver = new ChromeDriver();
    	 } else if(browserName.equals("FF")) {
    		 System.setProperty("webdriver.gecko.driver", "/Users/VKPRABHU/Documents/geckodriver");
    		 driver = new FirefoxDriver();
    	 }
    	 driver.manage().window().maximize();
    	 String pageLoadTimeout=prop.getProperty("implicitWait");
    	 long num1 = Long.parseLong(pageLoadTimeout);
    	 String implicitWait=prop.getProperty("implicitWait");
    	 long num2 = Long.parseLong(implicitWait);    	 
    	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(num1));
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num2));
    	 
    	 // Navigate to a web page
    	 
    	 driver.get(prop.getProperty("url"));
    	 
     }
     

}     