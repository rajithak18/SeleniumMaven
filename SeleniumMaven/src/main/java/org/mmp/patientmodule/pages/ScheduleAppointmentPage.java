package org.mmp.patientmodule.pages;

import java.util.HashMap;

import org.mmp.methods.MMPUtil;
import org.mmp.methods.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScheduleAppointmentPage {

	public WebDriver driver;
	 
	
	  private By linkText = By.linkText("Schedule Appointment");	  
	  private By createAppointmentCSS =(By.cssSelector("input[value='Create new appointment']"));	  
	  private By datePickerID =(By.id("datepicker"));	  
	  private By nextLinkText =By.linkText("Next");
	  private By timeID =By.id("time");
	  private By statusID = By.id("status");
	  private By symID = By.id("sym");
	  String selectDoctorXpath = "//h4[normalize-space()='Dr.$drName$']/ancestor::ul/following-sibling::button";
	
	public ScheduleAppointmentPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public HashMap<String, String> bookAppointment(String drName) {
		
		  HashMap<String,String> sHmap = new HashMap<String,String>();
			
			driver.findElement(linkText).click();
			driver.findElement(createAppointmentCSS).click();
			sHmap.put("doctor", drName);
			driver.findElement(By.xpath(selectDoctorXpath.replace("$drName$", drName))).click();
			
			driver.switchTo().frame("myframe");
						
			driver.findElement(datePickerID).click();
			driver.findElement(nextLinkText).click();
			driver.findElement(By.linkText("20")).click();
			sHmap.put("date", driver.findElement(datePickerID).getAttribute("value"));
			
		    {
		      WebElement dropdown = driver.findElement(timeID);
		      dropdown.findElement(By.xpath("//option[. = '12Pm']")).click();
		    }
		    sHmap.put("time", driver.findElement(timeID).getAttribute("value"));
		    
		    //Explicitwait or webdriverwait are both same
		    //Duration d = Duration.ofSeconds(30);
		    //WebDriverWait wait = new WebDriverWait(driver, d);
		   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ChangeHeatName")));
		    
		    By okStatus = statusID;
		    WebElement okMessage = MMPUtil.explicitTimeOut(driver,30,okStatus);
		    System.out.println("Message in the pop-up" + okMessage);
		    
		    By continueButton = By.id("ChangeHeatName");
		    WebElement continueWe = MMPUtil.explicitTimeOut(driver,30,continueButton);
		    continueWe.click();
		    
		    driver.findElement(By.id("ChangeHeatName")).click();
		    driver.switchTo().defaultContent();
		    driver.findElement(symID).click();
		    driver.findElement(symID).sendKeys("Leg Pain");
		    sHmap.put("sym", driver.findElement(symID).getAttribute("value"));
		    driver.findElement(By.cssSelector("input[value='Submit']")).click();
		    return sHmap;
		    
		}
		
		public HashMap<String,String> bookAppointment(String drName,int noofDays)
		{
			HashMap<String,String> sHMap = new HashMap<String,String>();
			driver.findElement(linkText).click();
			driver.findElement(createAppointmentCSS).click();	
			String expectedDrName = drName;
			driver.findElement(By.xpath(selectDoctorXpath.replace("$drName$", drName))).click();
			sHMap.put("doctor", drName);
			driver.switchTo().frame("myframe");
			driver.findElement(datePickerID).click();
			String result = Utility.getFutureDate(noofDays,"MMMM/dd/yyyy");
			String dateArr[]=result.split("/");
			String expectedYear=dateArr[2];
			String expectedMonth = dateArr[0];//Aug
			String expectedDay = dateArr[1];

			String actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();//June
			while(!(expectedYear.equals(actualYear)))
			{
				driver.findElement(By.linkText("Next")).click();
				actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
			}
			String actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();//June
			while(!(expectedMonth.equals(actualMonth)))
			{
				driver.findElement(linkText).click();
				actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			}

			driver.findElement(By.linkText(expectedDay)).click();
			
			String expectedDate   = driver.findElement(By.id("datepicker")).getAttribute("value");
			sHMap.put("date", expectedDate);
			driver.findElement(timeID).click();
			{
				WebElement dropdown = driver.findElement(timeID);
				dropdown.findElement(By.xpath("//option[. = '12Pm']")).click();
			}
			String expectedTime=driver.findElement(timeID).getAttribute("value");
			sHMap.put("time", expectedTime);
			
			By continueButton = By.id("ChangeHeatName");
		    WebElement continueWe = MMPUtil.explicitTimeOut(driver,30,continueButton);
		    continueWe.click();
			
			driver.findElement(By.id("ChangeHeatName")).click();
			driver.switchTo().defaultContent();
			driver.findElement(symID).click();
			driver.findElement(symID).sendKeys("Chest pain");
			String expectedSym = driver.findElement(symID).getAttribute("value");
			sHMap.put("sym", expectedSym);
			driver.findElement(By.cssSelector("input[value='Submit']")).click();
			return sHMap;
		}

		public HashMap<String, String> fetchPatientData()
		{
			HashMap<String,String> pHMap = new HashMap<String,String>();
			pHMap.put("doctor", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(4)")).getText());
			pHMap.put("date", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).getText());
			pHMap.put("time", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getText());
			pHMap.put("sym", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(3)")).getText());
			return pHMap;

		}
			
}
