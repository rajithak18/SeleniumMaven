package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMRSParam {

      public static WebDriver driver;
      
	@Parameters("browserName")
	@Test
	
	public void LaunchBrowser(String browserName) {	   
	    
		    switch ("browserName") {
		    case "chrome" :
		    WebDriverManager.chromedriver().setup();
	 	  	driver = new ChromeDriver();	
		    break;
		    default :
		    	System.err.println("Browser name is invalid");
		    	break;
		    }
  	
	}
		
    @Parameters("url")
	@Test
    public void LaunchApp(String url) {
    
           driver.get(url);   
    }
	
	@Parameters({"uname","pwd"})
	@Test
	public void Login(String uname,String pwd) throws Exception {
			 
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("uname");
		Thread.sleep(2000);	 
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pwd");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[text()='Inpatient Ward']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginButton']")).submit();
		
		Thread.sleep(2000);

	}

}
	

