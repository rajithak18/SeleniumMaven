package org.mmp.methods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {

	 public static String getFutureDate(int noofdays,String pattern)
 	{

 		Calendar cal = 	Calendar.getInstance();
 		cal.add(Calendar.DAY_OF_MONTH, noofdays);
 		Date d = cal.getTime();
 		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
 		String formatDate = sdf.format(d);
 		return formatDate;
 		
 		//String l1Expected="हिन्दी";
 		//   String l1Actual = driver.findElement(By.xpath("//a[contains(text(),'हिन्दी')]")).getText();
 	}

	
}
