package traillink.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import traillink.pages.Header;
import traillink.pages.Registration;
import traillink.testbase.TestBase;


public class TC_05_RegistrationNegativeCases extends TestBase{
	
	private final String testcasename= "TC_05_RegistrationNegativeCases";
	
	public final String FIRST_NAME = "Autotest";
	public final String LAST_NAME = "AUTOLNAME";
	public final String ZIPCODE = "35801";

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		startTestCase(testcasename);
	}
	
	@Test
	public void registrationNegativeCases() throws Throwable{
		
		Header headobj = new Header(driver);
		headobj.clickRegister();
		Log.info("Clicked on Register button.");
		
		Registration regObj = new Registration(driver);
		regObj.RegistrationlableVerify();
		Log.info("Registration page lable is verified.");
		
		regObj.registerUserNegativeCases(FIRST_NAME,LAST_NAME,ZIPCODE);
		Log.info("Regestration page validation verified.");
		
		} 
		
	@AfterMethod
	public void tearDown(ITestResult result){
		endTestCase(testcasename);
		driver.quit();
	}
}
