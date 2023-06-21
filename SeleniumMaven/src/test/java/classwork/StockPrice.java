package classwork;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class StockPrice {

    public WebDriver driver;
	
	@Test
	public void FetchStock() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	     driver = new ChromeDriver(co);
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
	}
	
	@Test
	public void fetchPrice() {
		
		List<WebElement> trList= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("The size of the dynamic table : " + trList.size());
		
		WebElement e = driver.findElement(By.xpath("//a[contains(text(),'Eureka Forbes')]/parent::td/following-sibling::td[2]"));
		try{
			if(e.isDisplayed())
			{
					String price =  e.getText();
					System.out.println("Stock Price : " + price);
			}
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("Stock does not exist"+ ex.getMessage());
		}
	}
	
}
