package traillink.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import traillink.pages.Header;
import traillink.pages.Registration;
import traillink.testbase.TestBase;


public class TC_04_RegistrationNegativeCases extends TestBase{
	
	private final String testcasename= "TC_01_Registration";
	
	public final String FIRST_NAME = "Autotest";
	public final String LAST_NAME = "AUTOLNAME";
	public final String ZIPCODE = "35801";

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		extent = getExtent();
		loggers= startTest(testcasename);
	}
	
	@Test
	public void registration() throws Throwable{
		
		Header headobj = new Header(driver);
		headobj.clickRegister();
		loggers.log(Status.INFO, "Clicked on Register button.");
		
		Registration regObj = new Registration(driver);
		regObj.RegistrationlableVerify();
		loggers.log(Status.INFO, "Registration page lable is verified.");
		
		regObj.registerUser(FIRST_NAME,LAST_NAME,ZIPCODE);
		loggers.log(Status.INFO, "Entered all the User details.");
		
		regObj.CheckRegisteredUser();
		loggers.log(Status.INFO, "Verified that User is registerd successfully.");
		
		} 
		
	@AfterMethod
	public void tearDown(ITestResult result){
		try {
			endTest(driver,testcasename,result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.flush();
		driver.quit();
	}
}
