package org.mmp.patientmodule.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class MMP_002_LoginTests {

	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	    driver = new ChromeDriver(co);
		
	}
	
	@Parameters({"url","username","password"})
	@Test
	public void TC_001_validateLogin(String url,String username,String password)  {
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		String actual =driver.findElement(By.xpath("//h3[normalize-space()='Patient Portal']")).getText();
		String expected="Patient Portal";
		//Assert.assertEquals(actual, expected);
		Assertion a1  = new Assertion();
	    a1.assertEquals(actual.trim(), expected);
		
		driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();	
	
	}
	
	@Parameters({"url","invusername","invpassword"})
	@Test
	public void TC_003_invalidateLogin(String url,String invusername,String invpassword) {
		 
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(invusername);
		driver.findElement(By.xpath("//input[@id ='password']")).sendKeys(invpassword);
		driver.findElement(By.name("submit")).click();
		Alert alrt = driver.switchTo().alert();
		String actual =alrt.getText().trim();
		String expected="Wrong username and password.";
		//Assert.assertEquals(actual, expected);
		Assertion a1  = new Assertion();
	    a1.assertEquals(actual.trim(), expected);
		
		
	}	
	
}
