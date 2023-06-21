package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JSDemoType {
	
	public WebDriver driver;
	
     @Test
     public void launchBrowser() {
    	 
    	 ChromeOptions co = new ChromeOptions();
 		co.addArguments("--remote-allow-origins=*");
 		WebDriver driver = new ChromeDriver(co);
 		driver.get("https://demo.openmrs.org/openmrs/login.htm");	
    
 		JavascriptExecutor jse= (JavascriptExecutor) driver;
 		
 		String ptitle = jse.executeScript("return document.title;").toString();
 		System.out.println("Current title is : " + ptitle);
 		
		jse.executeScript("document.getElementById('username').value='Admin'");		
		jse.executeScript("document.getElementById('password').value='Admin123'");
		jse.executeScript("document.getElementById('Isolation Ward').click()");
}
     
     
     
     
     
//	public WebDriver driver;
//	
//	@BeforeClass 
//	public void LaunchBrowser() {
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(co);
//			
//		driver.get("https://demo.openmrs.org/openmrs/login.htm");
//		
//	}
//	
//	@Test
//	public void login() {
//		 //we type the text in the textbox in selenium without using sendKeys :
//		 WebElement uname = driver.findElement(By.name("username"));
//		 JavascriptExecutor jse= (JavascriptExecutor) driver;
//		 jse.executeScript("arguments[0].value='Admin'",uname);
//		 jse.executeScript("document.getElementById('username').value='Admin'");
//
//	}
//	
}	
