package org.mmp.patientmodule.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.mmp.methods.BaseClass;
import org.mmp.methods.HelperClass;
import org.mmp.methods.MMPUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleAppointmentTests extends BaseClass {
	
	public WebDriver driver;
	MMPUtil mmpUtil;
	
	@BeforeMethod
	public void preRequisite() {
			
		   mmpUtil = new MMPUtil(driver);
		    mmpUtil.launchBrowser(pro.getProperty("patientURL"));
		    HelperClass helperObj =  new HelperClass(driver);
		    helperObj.login(pro.getProperty("patientUsername"), pro.getProperty("patientPassword"));
					
	}
	
	  @BeforeClass
	  public void instantiateDriver() {
		  
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions co = new ChromeOptions();
		  co.addArguments("--remote-allow-origins=*");
	   	  driver = new ChromeDriver(co);
	    
	  }
	  
	  @Parameters({"drName"})
	  @Test
	  public void TC_001_validateScheduleAppointment(String drName) {
	    
		   
		    HashMap<String,String>  expectedHMap = mmpUtil.BookAppointment(drName);
		    HashMap<String,String>  actualHMap = mmpUtil.FetchPatientData();
		    
		  //Assert.assertEquals(actualHMap,expectedHMap);--This was not working so its alternate solution
		    Assertion a1  = new Assertion();
			 a1.assertEquals(actualHMap, expectedHMap);
		    
		    
		}
	    
	    @Parameters({"drName"})
		@Test
		public void TC_003_validateScheduleAppointment(String drName) {
		
	    	
			HashMap<String,String> expectedHMap = mmpUtil.bookAppointment(drName,10);
			HashMap<String,String> actualHMap = mmpUtil.FetchPatientData();
			
			//Assert.assertEquals(actualHMap, expectedHMap);--This was not working so its alternate solution
			Assertion a1  = new Assertion();
			a1.assertEquals(actualHMap, expectedHMap);
	  }
	    
	    public String getFutureDate(int noofdays,String pattern) {

			Calendar cal = 	Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, noofdays);
			Date d = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String formatDate = sdf.format(d);
			return formatDate;
			
		}
}



