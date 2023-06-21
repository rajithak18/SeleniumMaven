package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenMRSLogin1 {
	
	public static WebDriver driver;
		
	@BeforeTest
	public void LaunchBrowser() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(co);
	    driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}
		
	
//	@Test
//	public void Login(String uname,String pwd ) throws Exception {
//		
//		String uname = "//input[@id='username']";
//		driver.findElement(By.xpath(uname)).sendKeys("Admin");
//		Thread.sleep(2000);
//		 
//		String lpwd = "//input[@id='password']";
//		driver.findElement(By.xpath(lpwd)).sendKeys("Admin123");
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//ul//li[6]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='loginButton']")).submit();
//		
//		Thread.sleep(2000);
//		
//	}
	
//	@Test
//	public void VerifyLogin() {
//		
//		String actual = driver.findElement(By.xpath("//h4[normalize-space()='Logged in as Super User (admin) at Inpatient Ward.']")).getText();
//		String expected = "Logged in as Super User (admin) at Inpatient Ward.";
//		
//		Assert.assertEquals(actual.trim(), expected);
//		
//		System.out.println("Result as expected");
//		
//	}
//	
	@AfterTest
	public void Logout() throws Exception {
		driver.findElement(By.xpath("//a[normalize-space(text())='Logout']")).click();
		Thread.sleep(2000);	
		
	}
	
}
