package classwork;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshot {

	  public static  WebDriver driver;   
	
	public static void main(String[] args) throws Exception {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
   	    driver = new ChromeDriver(co);
   	    
   	    driver.get("https://www.amazon.com/");
   	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screen.png"));
   	    
	}

}
