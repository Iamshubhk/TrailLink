package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import traillink.testbase.TestBase;

public class MyTrailLink extends TestBase {
	
	final WebDriver driver;
	
	@FindBy(xpath="//*[@id='account-section__settings-label']")
	private WebElement ACCOUNTSETTINGS;
	
	
	@FindBy(css=".change-password.show-for-medium")
	private WebElement CHANGEPASSWORDLINK;

	@FindBy(css="#account-settings-password-new")
	private WebElement NEWPASSWORDTEXTBOX;
	
	@FindBy(css="#account-settings-password-confirm")
	private WebElement CONFIRMPASSWORDTEXTBOX;
	
	@FindBy(css="#btn-save-acct-settings")
	private WebElement SAVEBUTTON;
	
	@FindBy(xpath="//*[@id='account-settings-first-name']")
	private WebElement FIRSTNAME;
	
	@FindBy(xpath="//*[@id='main-menu']//a[contains(text(),'My Profile')]")
	private WebElement MYPROFILE;
	
	@FindBy(css=".fa.fa-search.search-button")
	private WebElement SEARCHLINK;
	
	@FindBy(xpath="//*[@id='account-section__my-favorites']//a[contains(text(),'Submit a Trail')]")
	private WebElement SUBMITTRAILBTN;
	
	@FindBy(xpath="//*[@id='account-section__my-photos']//a[contains(text(),'Search for Trails')]")
	private WebElement SEARCHTRAILBTN;
	
	@FindBy(xpath="//*[@id='account-section__my-reviews']//a[contains(text(),'Search for Trails')]")
	private WebElement REVIEWSSEARCHTRAILBTN;
	
	@FindBy(xpath="//*[@class='profile-stats--photos']")
	private WebElement PHOTOSCOUNT;
	
	@FindBy(xpath="//*[@class='profile-stats--reviews']")
	private WebElement REVIEWSCOUNT;
	
	@FindBy(xpath="//*[@class='profile-stats--routes']")
	private WebElement TRAILSCOUNT;
	
	@FindBy(xpath="//section[1]//div[@class='review-text']//p")
	private WebElement REVIEWSTEXT;
	
	public MyTrailLink(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickAccountSettings(){
		this.waitForVisibility(driver,ACCOUNTSETTINGS);
		ACCOUNTSETTINGS.click();	
	}
	
	public void clickonChangePasswordLink(){
		this.waitForVisibility(driver,CHANGEPASSWORDLINK);
		CHANGEPASSWORDLINK.click();	
	}
	
	public void enterNewPassword(String password){
		this.waitForVisibility(driver,NEWPASSWORDTEXTBOX);
		clearAndwrite(NEWPASSWORDTEXTBOX, password);	
		Log.info("New Password entered.");
	}
	
	public void enterConfirmPassword(String password){
		this.waitForVisibility(driver,CONFIRMPASSWORDTEXTBOX);
		clearAndwrite(CONFIRMPASSWORDTEXTBOX, password);	
		Log.info("Confirm Password entered.");
	}
	
	public void clickSaveButton(){
		this.waitForVisibility(driver,SAVEBUTTON);
		scrollAndFind(SAVEBUTTON);
		SAVEBUTTON.click();
		sleep(3000);
		Log.info("Clicked on save profile button.");
	}
	
	public void enterFirstName(String firstName){
		this.waitForVisibility(driver,FIRSTNAME);
		clearAndwrite(FIRSTNAME, firstName);	
	}
	
	public String getTrailCount(){
		this.waitForVisibility(driver,TRAILSCOUNT);
		return TRAILSCOUNT.getText();	
	}
	
	public String clickonTrailCount(){
		this.waitForVisibility(driver,TRAILSCOUNT);
		return TRAILSCOUNT.getText();	
	}
	
	public String getPhotosCount(){
		this.waitForVisibility(driver,PHOTOSCOUNT);
		return PHOTOSCOUNT.getText();	
	}
	
	public void verifyPhotosCount(String previousCount ,String CurrentCount){
		boolean isOk=checkCountIncrease(previousCount, CurrentCount);
		assertEquals(isOk, true);
	}
	
	public void verifyReviewCount(String previousCount ,String CurrentCount){
		boolean isOk=checkCountIncrease(previousCount, CurrentCount);
		assertEquals(isOk, true);
	}
	
	public void verifyTrailCount(String previousCount ,String CurrentCount){
		boolean isOk=checkCountIncrease(previousCount, CurrentCount);
		assertEquals(isOk, true);
	}
	
	public String getReviewsCount(){
		this.waitForVisibility(driver,REVIEWSCOUNT);
		return REVIEWSCOUNT.getText();	
	}
	
	public void clickReviewsCount(){
		this.waitForVisibility(driver,REVIEWSCOUNT);
		REVIEWSCOUNT.click();
		sleep(3);
	}
	
	public String getReviewsText(){
		this.waitForVisibility(driver,REVIEWSTEXT);
		return REVIEWSTEXT.getText();	
	}
	
	public void clickSubmitTrailBtn(){
		this.waitForVisibility(driver,SUBMITTRAILBTN);
		SUBMITTRAILBTN.click();	
	}
	
	public void clickSearchTrailBtn(){
		this.waitForVisibility(driver,SEARCHTRAILBTN);
		SEARCHTRAILBTN.click();	
	}
	
	public void clickReviewsSearchTrailBtn(){
		this.waitForVisibility(driver,REVIEWSSEARCHTRAILBTN);
		REVIEWSSEARCHTRAILBTN.click();	
	}
	
	public void clickSearchLink(){
		this.waitForVisibility(driver,SEARCHLINK);
		SEARCHLINK.click();
		sleep(3);
	}
}
