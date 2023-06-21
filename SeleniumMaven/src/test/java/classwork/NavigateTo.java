package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NavigateTo {

	public WebDriver driver;
	public String url ="https://www.amazon.com/";
	@Test
	
	public void launchBrowser() throws Exception {
					
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		
		 driver.get(url);
		Thread.sleep(2000);
		driver.get("https://www.ebay.com/");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
