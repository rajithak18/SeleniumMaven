package classwork;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchStockList {
	
	public WebDriver driver;
	
	@Test
	public void login()	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	     driver = new ChromeDriver(co);	
   	     
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		String stockDetails[]= {"TCS","Varun Beverages Ltd."};
		SoftAssert sa = new SoftAssert();
		boolean result = false;
		for(int i = 0; i < stockDetails.length; i++) {
				
	     System.out.println("stock Name" + stockDetails[i]);
			try {
				driver.findElement(By.xpath("//table[@class='dataTable']//a[contains(.,'"+stockDetails[i]+"')]")).isDisplayed();
						
				{
					System.out.println("Stock is available in the table: " + stockDetails[i] );
					
				}
			}
			catch(Exception e)
			{
				
				System.out.println("Stock "  + stockDetails[i]+ " is not available in the table :");
			}
		}

	}	

}
