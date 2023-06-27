package org.practice.screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestClass extends BaseClass {

	
	@Test
	public void TestGoogle() {
		
		launchBrowser();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		String expected = "selenium  - Google Search";
		String actual = driver.getTitle();
		//Assert.assertEquals(actual,expected, "Title Mismatch");
		Assertion a1  = new Assertion();
	    a1.assertEquals(actual,expected, "Title Mismatch");
		
		driver.quit();
	}
	
	@Test
	
	public void TestFacebook() {
		
		launchBrowser();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("selenium");
		String expected = "Log into facebook";
		String actual = driver.getTitle();
		//Assert.assertEquals(actual,expected, "Title Mismatch");
		Assertion a1  = new Assertion();
	    a1.assertEquals(actual,expected, "Title Mismatch");
		
		driver.quit();
	}
	
}
