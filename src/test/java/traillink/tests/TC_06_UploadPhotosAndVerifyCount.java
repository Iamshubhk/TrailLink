package traillink.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import traillink.pages.AdminstratorWFO;
import traillink.pages.Header;
import traillink.pages.Login;
import traillink.pages.MyTrailLink;
import traillink.pages.SearchResults;
import traillink.pages.SubmitPhotos;
import traillink.pages.TrailProfile;
import traillink.testbase.TestBase;


public class TC_06_UploadPhotosAndVerifyCount extends TestBase{
	
	private final String testcasename= "TC_06_UploadPhotosAndVerifyCount";

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		startTestCase(testcasename);
	}
	
	@Test
	public void uploadPhotosAndverifyPhotoCount() throws Throwable{
		
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
			
		MyTrailLink MytrailObj = new MyTrailLink(driver);		
		String prePhotoCount = MytrailObj.getPhotosCount();
		Log.info("Getting current photo count "+prePhotoCount+" before upload.");
		
		headobj.HoverMytrail();
		headobj.clickMyPhotos();
		Log.info("Clicked on my photos link.");
		
		MytrailObj.clickSearchLink();
		Log.info("Clicked on search trail button");
		
		SearchResults searchResObj = new SearchResults(driver);
		String keyword = getcelldata("Testcase Data", 8, 2).toString();
		searchResObj.enterKeyword(keyword);
		Log.info("Enter keyword.");
		
		searchResObj.clickSearchOnProfile();
		Log.info("Clicked on search button");

		searchResObj.CheckSearchResults();
		Log.info("Verified the search results.");
		
		searchResObj.clickOnResult();
		Log.info("click the search result.");
		 
		TrailProfile trailProfileobj = new TrailProfile(driver);	
		trailProfileobj.clickOnUploadPhoto();
		Log.info("Clicked upload photos button.");
		
		SubmitPhotos submitPhotoobj = new SubmitPhotos(driver);
		submitPhotoobj.verifySubmitPhotosLabel();
		Log.info("Verified submit photos label.");
		
		Log.info("Uploading the trail photo...");
		String photoName = getcelldata("Testcase Data", 8, 3).toString();
		submitPhotoobj.UploadPhoto(photoName);
		
		Log.info("Entering photo title...");
		String photoTitle = getcelldata("Testcase Data", 8, 4).toString();
		submitPhotoobj.enterPhotoTitle(photoTitle+getRandomString(3));
		
		Log.info("Entering photo caption...");
		String photoCaption = getRandomString(5);
		submitPhotoobj.enterPhotoCaption(photoCaption);
	
		submitPhotoobj.clickOnSubmitPhoto();
		Log.info("Clicked on submit photos");
		
		submitPhotoobj.verifySubmitSuccess();
		Log.info("Photo uploaded successfully with "+photoCaption+" caption");
		
		AdminstratorWFO adminObj = new AdminstratorWFO(driver);
		adminObj.navigateToAdminEnv();
		Log.info("Navigating to WFO Admin");
		
		adminObj.doLogin();
		Log.info("Succesfully logged in on WFO");
		
		adminObj.clickTrailLink();
		Log.info("Click on WFO Traillink");
		
		adminObj.clickApprovePhotoLink();
		Log.info("Click on approve photo link");
		
		adminObj.approvePhotos(photoCaption);
		Log.info("Selected approve option from the status dropdown.");

		adminObj.clickOnUpdate();
		Log.info("Click on update button");	
		
		switchTabs(driver, 0);
		Log.info("Click on previos tab");
		
		headobj.HoverMytrail();
		headobj.ClickonMyProfile();
		Log.info("Clicked on my profile link.");
				
		String postPhotosCount = MytrailObj.getPhotosCount();
		Log.info("Getting current photos count "+postPhotosCount+ " after upload");
		
		MytrailObj.verifyPhotosCount(prePhotoCount, postPhotosCount);
		Log.info("Verified that photo uploaded successfully and photos count increases on profile page.");
		
		} 
		
	@AfterMethod
	public void tearDown(ITestResult result){
		endTestCase(testcasename);
		driver.quit();
	}
}
