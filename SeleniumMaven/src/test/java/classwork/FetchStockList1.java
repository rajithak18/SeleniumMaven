package classwork;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FetchStockList1 {
	
     public WebDriver driver; 	
	
     @Test
     
	 public void Login1() throws Exception {
		 	 
	     ChromeOptions co = new ChromeOptions();
	     co.addArguments("--remote-allow-origins=*");
	     driver = new ChromeDriver(co);
	
	     driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
	     Thread.sleep(2000);
	     
          List<WebElement> trList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
          System.out.println(trList.size());
          int rowsize = trList.size();
          
          List<WebElement> tdList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
          System.out.println(tdList.size()); 
          int colsize = tdList.size(); 
            
          for(int  r= 1; r < rowsize; r++) {
        	  for(int c = 1; c < colsize; c++) {
        		  
        		System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td["+c+"]")).getText());
        	  }
        		  
       	  } 	 
      	 
   }
}
