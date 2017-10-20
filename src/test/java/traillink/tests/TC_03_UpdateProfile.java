package traillink.tests;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import traillink.pages.Header;
import traillink.pages.Login;
import traillink.pages.MyTrailLink;
import traillink.testbase.TestBase;


public class TC_03_UpdateProfile extends TestBase{
	
	private final String testcasename= "TC_03_UpdateProfile";
	
	public final String FIRST_NAME = "Autotest";
	public final String LAST_NAME = "AUTOLNAME";
	public final String ZIPCODE = "35801";

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		startTestCase(testcasename);
	}
	
	@Test
	public void updateProfile() throws Throwable{
		
		Header headobj = new Header(driver);
		headobj.clickLogin();
		Log.info("Clicked on login link.");
		
		Login logObj = new Login(driver);
		logObj.loginlableVerify();
		Log.info("Login page lable is verified.");
		
		final String email = getcelldata("Testcase Data", 7, 2);
		logObj.enterEmail(email);
		Log.info("Entered email.");
		
		String password = getcelldata("Testcase Data", 7, 3);
		logObj.enterPassword(password);
		Log.info("Entered new password.");
		
		logObj.clickLoginButton();
		Log.info("clicked on login button.");
		
		headobj.HoverMytrail();
		headobj.ClickonMyProfile();
		Log.info("Clicked on my profile link.");
		
		MyTrailLink MytrailObj= new MyTrailLink(driver);
		MytrailObj.clickAccountSettings();
		Log.info("Clicked on my account and settings link.");

		final String firstName = getRandomString(5);
		MytrailObj.enterFirstName(firstName);
		Log.info("Entered firstName.");
		
		MytrailObj.clickSaveButton();
		Log.info("Clicked on save profile button.");
		
		String actualFName= headobj.getMyProfileName();
		final String ExpectedName = "Hello, "+firstName;
		assertEquals(actualFName.toLowerCase().trim(), ExpectedName.toLowerCase().trim());
		Log.info("Verified that profile name is successfully updated.");
		
		
		} 
		
	@AfterMethod
	public void tearDown(ITestResult result){
		endTestCase(testcasename);
		driver.quit();
	}
}
