package org.practice.screenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	   public WebDriver driver;
	   
	   @BeforeTest
	   public void launchBrowser() {
		 
	     ChromeOptions co = new ChromeOptions();
	     co.addArguments("--remote-allow-origins=*");	     
	     driver = new ChromeDriver(co);
	
    }
	   
	   @AfterTest
	   public void TearDown() {
		   
		   driver.quit();
	   }
	   
	   public void Screeshot() {
		   
		   
	   }
	   
}	   
