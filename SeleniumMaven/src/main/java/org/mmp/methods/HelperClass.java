package org.mmp.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HelperClass {

	WebDriver driver;
	
	//use any one either page object model(easy one) or page factory
	//Page object model
	private By usernameID = By.id("username");
	
	//Page factory model-
	@FindBy(how=How.ID,using="password")
	private WebElement passwordId;//driver.findElement(By.id("password"));
	
	
	
	public HelperClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);//this will invoke @FindBy
	}
	
	public void login(String username,String password) {
		
		driver.findElement(usernameID).sendKeys(username);
		passwordId.sendKeys(username);
		driver.findElement(By.name("submit")).click();
		
	}
	
}
