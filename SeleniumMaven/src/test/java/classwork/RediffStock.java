package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class RediffStock {

	public WebDriver driver;
	
	@Test
	public void FetchStock() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	     driver = new ChromeDriver(co);
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		displayListOfGainers(5,"Eureka Forbes");
	}

	public boolean displayListOfGainers(int nRows,String stockName) {
		
		List<WebElement> trList= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("The size of the dynamic table : " + trList.size());
		boolean result = false;
		//Fetch top 5 rows of data
		for(int i=0; i<5;i++) {
			
			System.out.println(trList.get(i).getText());
		    if(trList.get(i).getText().contains("Eureka Forbes")) {
			
		    	result = true;
		    	break;
		   }		   
		}	 
		return result;
		
	}
	
	
}
