package org.mmp.patientmodule.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ScheduleAppt {

    public WebDriver driver;
    public String url = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
	
	@BeforeClass
	public void launchBrowser() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	    driver = new ChromeDriver(co);
		
	}
	
	@Test
	public void scheduleAppointment() {
		
        driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ria1");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		String actual =driver.findElement(By.xpath("//h3[normalize-space()='Patient Portal']")).getText();
		String expected="Patient Portal";
//		 Assertion a1  = new Assertion();
//		 a1.assertEquals(actual, expected);
		driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
		
	}
		
}
