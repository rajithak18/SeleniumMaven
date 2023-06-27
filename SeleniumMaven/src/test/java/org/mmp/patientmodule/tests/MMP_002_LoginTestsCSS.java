package org.mmp.patientmodule.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class MMP_002_LoginTestsCSS {

	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	    driver = new ChromeDriver(co);
		
	}
	
	@Parameters({"url","username","password"})
	@Test
	public void MMPlogin(String url,String username,String password) {
     
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
	
	
	@Test
	  public void mMPlogin() {
	    driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	    
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("ria1");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("Ria12345");
	    driver.findElement(By.name("submit")).click();
	  }
}
