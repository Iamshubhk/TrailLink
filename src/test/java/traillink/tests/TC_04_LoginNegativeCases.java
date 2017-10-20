package traillink.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import traillink.pages.Header;
import traillink.pages.Login;
import traillink.testbase.TestBase;


public class TC_04_LoginNegativeCases extends TestBase{
	
	private final String testcasename= "TC_04_LoginNegativeCases";
	
	public final String FIRST_NAME = "Autotest";
	public final String LAST_NAME = "AUTOLNAME";
	public final String ZIPCODE = "35801";

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		startTestCase(testcasename);
	}
	
	@Test
	public void loginNegativeCases() throws Throwable{
		
		Header headobj = new Header(driver); 
		headobj.clickLogin();
		Log.info("Clicked on login button.");
		
		Login loginObj = new Login(driver);
		loginObj.loginlableVerify();
		Log.info("Login page lable is verified.");
		
		loginObj.doLoginNagativeCase();
		Log.info("Verified login functionality with negative scenarios.");
	
		} 
		
	@AfterMethod
	public void tearDown(ITestResult result){
		endTestCase(testcasename);
		driver.quit();
	}
}
