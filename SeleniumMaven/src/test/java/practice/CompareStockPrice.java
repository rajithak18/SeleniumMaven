package practice;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompareStockPrice {

	public WebDriver driver;
	
	@Test
	public void compareStock() {		
	
	   ChromeOptions co = new ChromeOptions();
	   co.addArguments("--remote-allow-origins=*");
	   driver = new ChromeDriver(co);
	   driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
	   
	}
	
	@Test
	
	public void fetchprice() {
		
		List<WebElement> trList= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("The size of the dynamic table : " + trList.size());
		
		List<WebElement> tdList= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td"));
		System.out.println("The size of the dynamic table : " + tdList.size());
				
//			long price1 =  Long.parseLong(driver.findElement(By.xpath("//a[contains(text(),'Eureka Forbes')]/parent::td/following-sibling::td[2]")).getText());		
//			long price2 =  Long.parseLong(driver.findElement(By.xpath("//a[contains(text(),'Jindal Saw')]/parent::td/following-sibling::td[2]")).getText());
								
		WebElement we1 = driver.findElement(By.xpath("//a[contains(text(),'Eureka Forbes')]/parent::td/following-sibling::td[2]"));
		String price1 =  we1.getText();
		System.out.println("Stock Price : " + price1);
		
		WebElement we2 = driver.findElement(By.xpath("//a[contains(text(),'Jindal Saw')]/parent::td/following-sibling::td[2]"));
		String price2 =  we2.getText();
		System.out.println("Stock Price : " + price2);	
					
			
		}
		
	}

	
	   
	   
	  
		   
	
	  
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
   

