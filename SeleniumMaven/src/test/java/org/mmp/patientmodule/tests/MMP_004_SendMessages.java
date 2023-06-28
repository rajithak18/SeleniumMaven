package org.mmp.patientmodule.tests;

import org.mmp.methods.BaseClass;
import org.mmp.methods.HelperClass;
import org.mmp.methods.MMPUtil;
import org.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.annotations.BeforeMethod;

public class MMP_004_SendMessages extends BaseClass {

	MMPUtil mmpUtil;
	ScheduleAppointmentPage sPage;
	
	@BeforeMethod
	public void preRequisite() {
			
		    mmpUtil = new MMPUtil(driver);
		    mmpUtil.launchBrowser(pro.getProperty("patientURL"));
		    HelperClass helperObj =  new HelperClass(driver);
		    helperObj.login(pro.getProperty("patientUsername"), pro.getProperty("patientPassword"));
		    sPage = new ScheduleAppointmentPage(driver);
					
	}
		
	
}
