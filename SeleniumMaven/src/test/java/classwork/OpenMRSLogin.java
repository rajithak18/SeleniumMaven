package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class OpenMRSLogin {

	@Test
	
	public void login() throws Exception {
		
	ChromeOptions co = new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(co);
		
	driver.get("https://demo.openmrs.org/openmrs/login.htm");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//ul//li[6]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='loginButton']")).submit();
	
	Thread.sleep(2000);
	
	String actual = driver.findElement(By.xpath("//h4[normalize-space()='Logged in as Jacob Gosselin MD (admin) at Inpatient Ward.")).getText();
	String expected = "Logged in as Jacob Gosselin MD (admin) at Inpatient Ward.";
	
	//Assert.assertEquals(actual.trim(), expected);
	Assertion a1  = new Assertion();
    a1.assertEquals(actual.trim(), expected);
	
	
	System.out.println("Result as expected");
	
	driver.findElement(By.xpath("//a[normalize-space(text())='Logout']")).click();
	Thread.sleep(2000);	
	driver.quit();
		
  }

}
	

