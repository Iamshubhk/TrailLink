package traillink.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import traillink.pages.Header;
import traillink.pages.Home;
import traillink.pages.Login;
import traillink.pages.Registration;
import traillink.pages.SearchResults;
import traillink.testbase.TestBase;


public class TC_02_SearchTrail extends TestBase{
	
	private final String testcasename= "TC_02_SearchTrail";
	
	public final String KEYWORD = "Aspen Airport Business Center Trail";
	

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		extent = getExtent();
		loggers= startTest(testcasename);
	}
	
	@Test
	public void searchTrail() throws Throwable{
		
		Header headobj = new Header(driver);
		headobj.clickLogin();
		loggers.log(Status.INFO, "Clicked on login link.");
		
		Login logObj = new Login(driver);
		logObj.loginlableVerify();
		loggers.log(Status.INFO, "Login page lable is verified.");
		
		logObj.doLogin();
		loggers.log(Status.INFO, "Logged in using valid credentials.");
		
		headobj.CheckLogoutLink();
		loggers.log(Status.INFO, "Verified the logout link on home page.");
		
		
		Home homeobj = new Home(driver);
		homeobj.enterKeyword(KEYWORD);
		loggers.log(Status.INFO, "Entered the Keyword.");
		
		homeobj.clickSearch();
		loggers.log(Status.INFO, "Clicked on search button");
		
		SearchResults searchobj=new SearchResults(driver);
		searchobj.CheckSearchResults();
		loggers.log(Status.INFO, "Verified the search results.");
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
