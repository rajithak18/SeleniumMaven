package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FetchStock {

	
public WebDriver driver;
	
	@Test
	public void FetchStock() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	     driver = new ChromeDriver(co);
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		List<WebElement> trList = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("The list of elements :" + trList.size());
		System.out.println(trList.get(0).getText());
		System.out.println(trList.get(1).getText());
	}
	
}
