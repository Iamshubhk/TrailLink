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
import traillink.pages.SearchResults;
import traillink.pages.SubmitPhotos;
import traillink.pages.SubmitReviews;
import traillink.pages.TrailProfile;
import traillink.testbase.TestBase;


public class TC_08_GiveReviewsOnTrailsAndVerifyCount extends TestBase{
	
	private final String testcasename= "TC_08_GiveReviewsOnTrailsAndVerifyCount";

	@BeforeMethod
	public void setup() throws Throwable{
		init();
		startTestCase(testcasename);
	}
	
	@Test
	public void submitReviewAndverifyReviewCount() throws Throwable{
		
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
		String preReviewCount = myTrailObj.getReviewsCount();
		Log.info("Getting current reviews count "+preReviewCount+" before upload.");
		
		headobj.HoverMytrail();
		headobj.clickMyReviews();
		Log.info("Clicked on my reviews link.");
		
		myTrailObj.clickSearchLink();
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
		trailProfileobj.clickOnSubmitreviews();
		Log.info("Clicked submit review button.");
		
		SubmitReviews submitReviewsObj = new SubmitReviews(driver);
		submitReviewsObj.verifySubmitReviewLabel();
		Log.info("Verified submit reviews label.");
		
		Log.info("Entering review ratings...");
		submitReviewsObj.clickOnRatings();
		
		Log.info("Entering review title...");
		String title = getcelldata("Testcase Data", 9, 4).toString();
		submitReviewsObj.enterReviewTitle(title);
		
		Log.info("Entering review description..");
		String review = getRandomString(5);
		submitReviewsObj.enterReviewDesc(review);
	
		submitReviewsObj.clickOnPreview();
		Log.info("Clicked on preview button");
		
		submitReviewsObj.clickOnSubmit();
		Log.info("Clicked on submit button");
		
		AdminstratorWFO adminObj = new AdminstratorWFO(driver);
		adminObj.navigateToAdminEnv();
		Log.info("Navigating to WFO Admin");
		
		adminObj.doLogin();
		Log.info("Succesfully logged in on WFO");
		
		adminObj.clickTrailLink();
		Log.info("Click on WFO Traillink");
		
		adminObj.clickApproveReviewLink();
		Log.info("Click on approve review link");
		
		adminObj.approveReviews(review);
		Log.info("Selected approve option from the status dropdown.");

		adminObj.clickOnUpdate();
		Log.info("Click on update button");	
		
		switchTabs(driver, 0);
		Log.info("Click on previos tab");
		
		headobj.HoverMytrail();
		headobj.ClickonMyProfile();
		Log.info("Clicked on my profile link.");
		
		String postReviewCount = myTrailObj.getReviewsCount();
		Log.info("Getting current review count: "+postReviewCount+ "after upload");
		
		myTrailObj.verifyReviewCount(preReviewCount, postReviewCount);
		Log.info("Verified that review given successfully and review count increases on profile page.");
		
		myTrailObj.clickReviewsCount();
		Log.info("Clicked review count.");

		String actualReviewText = myTrailObj.getReviewsText();
		Log.info("Getting current review text after approve from admin");
		
		assertEquals(true, verifyText(review, actualReviewText));
		Log.info("Review text is verified on my review page.");
		} 
		
	@AfterMethod
	public void tearDown(ITestResult result){
		endTestCase(testcasename);
		driver.quit();
	}
}
