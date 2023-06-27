package classwork;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MMPHealthCare {

	public static WebDriver driver;
	
	@Test
	
	public void Login() throws Exception {
		//WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	    driver = new ChromeDriver(co);
		
	   driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	   
       driver.findElement(By.xpath("//input[@id ='username']")).sendKeys("Ria1");
       
       driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("Ria12345");
       
       driver.findElement(By.xpath("//input[@type='submit']")).click();
       
	   	driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
	   	
	   	try {
	   	WebElement readOnly = driver.findElement(By.xpath("//input[@readonly = 'readonly']"));	 	
	    String readonly = readOnly.getAttribute("readonly");
	   // Assert.assertNotNull(readonly);
	    
	    
	    System.out.println("Licence field is read only");
	   	}
	    	catch(Exception e)
	    	
	    	{
	    		
	    		System.out.println("Licence field is  editible");
	    		
	    	}            
    }
}


	
