package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ListOfWebelements {

	public WebDriver driver;
	
	@Test
	public void Elements() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	    driver = new ChromeDriver(co);
   	    
   	    driver.get("https://www.amazon.com/");
   	    
   	    List <WebElement> listOfElements = driver.findElements(By.className("nav-a"));
   	    
   	      for(WebElement we :  listOfElements) {
   	    	  System.out.println(we.getAttribute("textContent"));
   	      }
	}
	
}
