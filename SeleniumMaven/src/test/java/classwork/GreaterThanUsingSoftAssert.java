package classwork;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GreaterThanUsingSoftAssert {

	public WebDriver driver;
	
	@Test
	
	public void GreaterThan() {
		
		int a =10;
		int b = 5;
		
		SoftAssert sa = new SoftAssert();
		boolean result = false;
		
		
		try {			
			result = a<b;
		    if(result) {
			
			           System.out.println("The result is true");
			           //sa.assertTrue(result);
		            } 
		    }
		    catch(Exception e)  
		    {
		   	     //result = false;
		   	     sa.assertTrue(result);
			     System.out.println("The result is false");
		     }
		      sa.assertAll();
			
		   }
    }
	
 

