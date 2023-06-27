package org.mmp.methods;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MMPUtil {

	WebDriver driver;
	
	public MMPUtil(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void launchBrowser(String url) {
		
		driver.get(url);
	}
	
	public void login(String username,String password) {
				
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
	}
        
        public static WebElement explicitTimeOut(WebDriver driver,int timeinSeconds,By locator) {
        	
        	 //Explicit wait or webdriverwait is equal
    	    Duration d =Duration.ofSeconds(timeinSeconds);
    	    WebDriverWait wait = new WebDriverWait(driver,d);
    	    WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	   return e;
        	
        }
		
}

