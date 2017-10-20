package traillink.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import traillink.pages.Header;
import traillink.pages.Home;
import traillink.pages.Login;
import traillink.pages.SearchResults;
import traillink.testbase.TestBase;


public class TC_02_SearchTrail extends TestBase{
	
	private final String testcasename= "TC_02_SearchTrail";
	
	public final String KEYWORD = "Aspen Airport Business Center Trail";
	

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		startTestCase(testcasename);
	}
	
	@Test
	public void searchTrail() throws Throwable{
		
		Header headobj = new Header(driver);
		headobj.clickLogin();
		Log.info("Clicked on login link.");
		
		Login logObj = new Login(driver);
		logObj.loginlableVerify();
		Log.info("Login page lable is verified.");
		
		logObj.doLogin();
		Log.info("Logged in using valid credentials.");
		
		headobj.CheckLogoutLink();
		Log.info("Verified the logout link on home page.");
		
		Home homeobj = new Home(driver);
		homeobj.enterKeyword(KEYWORD);
		Log.info("Entered the Keyword.");
		
		homeobj.clickSearch();
		Log.info("Clicked on search button");
		
		SearchResults searchobj=new SearchResults(driver);
		searchobj.CheckSearchResults();
		Log.info("Verified the search results.");
	}
		
	@AfterMethod
	public void tearDown(ITestResult result){
		endTestCase(testcasename);
		driver.quit();
	}
}
