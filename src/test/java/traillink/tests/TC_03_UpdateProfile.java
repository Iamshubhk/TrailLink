package traillink.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import traillink.pages.Header;
import traillink.pages.Home;
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
		extent = getExtent();
		loggers= startTest(testcasename);
	}
	
	@Test
	public void updateProfile() throws Throwable{
		
		Header headobj = new Header(driver);
		headobj.clickLogin();
		loggers.log(Status.INFO, "Clicked on login link.");
		
		Login logObj = new Login(driver);
		logObj.loginlableVerify();
		loggers.log(Status.INFO, "Login page lable is verified.");
		
		final String email = getcelldata("Testcase Data", 7, 2);
		logObj.enterEmail(email);
		loggers.log(Status.INFO, "Entered email.");
		
		String password = getcelldata("Testcase Data", 7, 3);
		logObj.enterPassword(password);
		loggers.log(Status.INFO, "Entered new password.");
		
		logObj.clickLoginButton();
		loggers.log(Status.INFO, "clicked on login button.");
		
		headobj.HoverMytrail();
		headobj.ClickonMyProfile();
		loggers.log(Status.INFO, "Clicked on my profile link.");
		
		MyTrailLink MytrailObj= new MyTrailLink(driver);
		MytrailObj.clickAccountSettings();
		loggers.log(Status.INFO, "Clicked on my account and settings link.");

		final String firstName = getRandomString(5);
		MytrailObj.enterFirstName(firstName);
		loggers.log(Status.INFO, "Entered firstName.");
		
		MytrailObj.clickSaveButton();
		loggers.log(Status.INFO, "Clicked on save profile button.");
		
		String actualFName= headobj.getMyProfileName();
		final String ExpectedName = "Hello, "+firstName;
		assertEquals(actualFName.toLowerCase().trim(), ExpectedName.toLowerCase().trim());
		loggers.log(Status.INFO, "Verified that profile name is successfully updated.");
		
		
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
