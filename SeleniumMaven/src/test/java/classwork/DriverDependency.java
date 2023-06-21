package classwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;


public class DriverDependency {

	public  WebDriver driver;
	
	
	@BeforeTest
	public void LaunchBrowser() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(co);
	}
	}
	
	

