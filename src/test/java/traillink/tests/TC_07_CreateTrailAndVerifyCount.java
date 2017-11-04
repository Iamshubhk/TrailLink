package traillink.tests;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import traillink.pages.AdminstratorWFO;
import traillink.pages.Header;
import traillink.pages.Login;
import traillink.pages.MyTrailLink;
import traillink.pages.SubmitTrail;
import traillink.testbase.TestBase;


public class TC_07_CreateTrailAndVerifyCount extends TestBase{
	
	private final String testcasename= "TC_07_CreateTrailAndVerifyCount";
	
	@BeforeMethod
	public void setup() throws Throwable{
		init();
		startTestCase(testcasename);
	}
	
	@Test
	public void createAndSubmitTrail() throws Throwable{
		
		Header headobj = new Header(driver);
		headobj.clickLogin();
		Log.info("Clicked on login link.");
		
		Login logObj = new Login(driver);
		logObj.loginlableVerify();
		Log.info("Login page lable is verified.");
		
		Log.info("Enter valid credential and login.");
		logObj.doLogin();
		
		headobj.HoverMytrail();
		headobj.ClickonMyProfile();
		Log.info("Clicked on my profile link.");
			
		MyTrailLink myTrailObj = new MyTrailLink(driver);		
		String trailCountBefore = myTrailObj.getTrailCount();
		Log.info("Getting current trail count "+trailCountBefore+" before create.");
		
		headobj.HoverMytrail();
		headobj.clickMyTrail();
		Log.info("Clicked on my trail link.");
		
		myTrailObj.clickSubmitTrailBtn();
		Log.info("Clicked on submit trail button.");

		SubmitTrail submitTrailObj= new SubmitTrail(driver);
		//String trailName = getcelldata("Testcase Data", 9, 2);
		String finaltrailName = getRandomString(6);
		submitTrailObj.submitTrailWithValidDetails(finaltrailName);
		Log.info("Fill all the valid details and submit trail.");
		
		Log.info("Verifying that trail submitted successfully.");
		submitTrailObj.successVerify();
		
		AdminstratorWFO adminObj = new AdminstratorWFO(driver);
		adminObj.navigateToAdminEnv();
		Log.info("Navigating to WFO Admin");
		
		adminObj.doLogin();
		Log.info("Succesfully logged in on WFO");
		
		adminObj.clickTrailLink();
		Log.info("Click on WFO Traillink");
		
		adminObj.clickApproveTL();
		Log.info("Click on approve trail link");
		
		adminObj.clickOnTrailID(finaltrailName);
		Log.info("Click on trail id.");

		adminObj.selectOpenStatus();
		Log.info("Select open status");	
		
		adminObj.clickOnSave();
		Log.info("Click on save button");	
		
		switchTabs(driver, 0);
		Log.info("Click on previos tab");
		
		headobj.HoverMytrail();
		headobj.ClickonMyProfile();
		Log.info("Clicked on my profile link.");
		
		String trailCountafter = myTrailObj.getTrailCount();
		Log.info("Getting current review count: "+trailCountafter+ "after upload");
		
		myTrailObj.verifyTrailCount(trailCountBefore, trailCountafter);
		Log.info("Verified that trail created successfully and trail count increases on profile page.");
		
		} 
		
	@AfterMethod
	public void tearDown(ITestResult result){
		endTestCase(testcasename);
		driver.quit();
	}
}
