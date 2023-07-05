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
	public void Login() throws Exception {
		//WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	     driver = new ChromeDriver(co);
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		Thread.sleep(2000);
		String stockDetails[] = {"Mirza International","ITC Ltd"};
		Thread.sleep(3000);
		SoftAssert sa = new SoftAssert();
		boolean result = false;
			for(int i = 0; i < stockDetails.length; i++) {
				
			System.out.println("stock Name " + stockDetails[i]);
			
			try {
			result = (driver.findElement(By.xpath("//table[@class='dataTable']//a[contains(.,'"+stockDetails[i]+"')]"))
					.isDisplayed());
			if(result)
			{
			  System.out.println("Stock is available in the table :" + stockDetails[i]);
			  sa.assertTrue(result);
			
			  } 
			} 
			catch(Exception e) 	
			          {
				       result = false;
				       sa.assertTrue(result);
					   System.out.println("Stock is not available in the table : " +stockDetails[i] );	
					
					}
					sa.assertAll();
		}
	}
	
}
