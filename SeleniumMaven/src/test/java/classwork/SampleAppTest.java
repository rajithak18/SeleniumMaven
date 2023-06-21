package classwork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleAppTest {

	public WebDriver driver;
	String btype = "chrome";
	String url = "https://magento.softwaretestingboard.com/";
	
    @Test(priority=1)
	public void launchBrowser() {
		
//    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\softwares\\driverexes\\chromedriver.exe");
//	       System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\softwares\\driverexes\\geckodriver.exe");
//	       
//	       if(btype.equalsIgnoreCase("firefox")) {
//	    	   driver = new FirefoxDriver();
//	       } else if(btype.equalsIgnoreCase("chrome")) {
//	    	   driver = new ChromeDriver(); 
//	    	   
//	       }
    	
    	ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(co);
	    
	       
	        driver.get(url);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
    @Test(priority=3)
    public void searchTshirts() throws Exception {
    	  Thread.sleep(2000);
    	  String searchX = "//input[@id='search']"; //failed case with xpath:- //input[@id='search1']-search1 not existing
	      driver.findElement(By.xpath(searchX)).sendKeys("T-shirts");//using a avariable for xpath with the above statement
	      driver.findElement(By.xpath(searchX)).sendKeys(Keys.ENTER);
	      Thread.sleep(1000);
    }
    
    @Test(priority=5)
    public void closeBrowser() throws Exception {
    	  Thread.sleep(1000);
    	  driver.quit();
    }
	
}
