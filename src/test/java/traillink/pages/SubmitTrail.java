package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class SubmitTrail extends TestBase {
	
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
	
	@FindBy(xpath="//*[@id='main-menu']//a[contains(text(),'My Trails')]")
	private WebElement MYTRAIL;
	
	@FindBy(xpath="//*[@id='account-section__my-favorites']//a[contains(text(),'Submit a Trail')]")
	private WebElement SUBMITTRAILBTN;
	
	@FindBy(xpath="//*[@id='account-form-name']")
	private WebElement TRAILNAME;
	
	@FindBy(xpath="//*[@id='account-form-length']")
	private WebElement TRAILLENGTH;
	
	@FindBy(xpath="//*[@id='account-form-category']")
	private WebElement TRAILCATEGORY;
	
	@FindBy(xpath="//option[contains(text(),'Multi-Use Trail')]")
	private WebElement TRAILCATEGORYOPTION;
	
	@FindBy(xpath="//*[@id='account-form-endpt1']")
	private WebElement TRAILEP1;
	
	@FindBy(xpath="//*[@id='account-form-endpt2']")
	private WebElement TRAILEP2;
	
	@FindBy(xpath="//*[@id='account-form-website1']")
	private WebElement TRAILWEBSITE;
	
	@FindBy(xpath="//*[@id='account-form-surfaces']//label[contains(text(),'Asphalt')]")
	private WebElement SURFACESASPHALT;
	
	@FindBy(xpath="//*[@id='account-form-surfaces']//label[contains(text(),'Grass')]")
	private WebElement SURFACESGRASS;
	
	@FindBy(xpath="//*[@id='account-form-activities']//label[contains(text(),'ATV')]")
	private WebElement ACTIVITYATV;
	
	@FindBy(xpath="//*[@id='account-form-activities']//label[contains(text(),'Bike')]")
	private WebElement ACTIVITYBIKE;
	
	@FindBy(xpath="//*[@id='account-form-states']//label[contains(text(),'Alabama')]")
	private WebElement STATESALABAMA;
	
	@FindBy(xpath="//*[@id='account-form-counties']//label[contains(text(),'Autauga')]")
	private WebElement COUN_AUTAUGA;
	
	
	@FindBy(xpath="//*[@id='account-form-description']")
	private WebElement DESCRIPTION;
	
	@FindBy(xpath="//*[@id='account-form-parking']")
	private WebElement PARKING;
	
	@FindBy(xpath="//*[@id='register-modal-terms']")
	private WebElement TERMS;
	
	@FindBy(xpath="//*[@id='btn-preview-trail']")
	private WebElement TRAILPREVIEWBTN;
	
	@FindBy(xpath="//*[@id='btn-submit-trail']")
	private WebElement TRAILSUBMITBTN;
	
	@FindBy(xpath="//div[contains(text(),'Trail Submitted')]")
	private WebElement SUCCESSMSG;
	
	
	
	public SubmitTrail(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTrailName(String name){
		this.waitForVisibility(driver,TRAILNAME);
		clearAndwrite(TRAILNAME, name);	
		Log.info("Trail name entered.");
	}
	
	public void enterTrailLength(String length){
		this.waitForVisibility(driver,TRAILLENGTH);
		clearAndwrite(TRAILLENGTH, length);	
		Log.info("Trail length entered.");
	}
	
	public void clickCategoryDrp(){
		this.waitForVisibility(driver,TRAILCATEGORY);
		TRAILCATEGORY.click();	
	}
	
	public void clickoncatOption(){
		this.waitForVisibility(driver,TRAILCATEGORYOPTION);
		TRAILCATEGORYOPTION.click();
		Log.info("category selected");
	}
	
	public void enterEP1(String ep1){
		this.waitForVisibility(driver,TRAILEP1);
		clearAndwrite(TRAILEP1, ep1);	
		Log.info("End point 1 entered.");
	}
	
	public void enterEP2(String ep2){
		this.waitForVisibility(driver,TRAILEP2);
		clearAndwrite(TRAILEP2, ep2);	
		Log.info("End point 2 entered.");
	}
	
	public void enterwebsite1(String website){
		this.waitForVisibility(driver,TRAILWEBSITE);
		clearAndwrite(TRAILWEBSITE, website);	
		Log.info("website entered.");
	}
	
	public void selectSurfaces(){
		this.waitForVisibility(driver,SURFACESASPHALT);
		scrollAndFind(SURFACESASPHALT);
		SURFACESASPHALT.click();	
		SURFACESGRASS.click();
		Log.info("surfaces selected");
	}
	
	public void selectActivities(){
		this.waitForVisibility(driver,ACTIVITYATV);
		ACTIVITYATV.click();	
		ACTIVITYBIKE.click();
		Log.info("activities selected");
	}
	
	public void selectState(){
		this.waitForVisibility(driver,STATESALABAMA);
		STATESALABAMA.click();
		sleep(3);
		Log.info("state selected");
	}
	
	public void selectCountry(){
		this.waitForVisibility(driver,COUN_AUTAUGA);
		COUN_AUTAUGA.click();
		Log.info("country selected");
	}
	
	public void enterdescription(String desc){
		this.waitForVisibility(driver,DESCRIPTION);
		clearAndwrite(DESCRIPTION, desc);	
		Log.info("DESCRIPTION entered.");
	}
	
	public void enterParking(String parking){
		this.waitForVisibility(driver,PARKING);
		clearAndwrite(PARKING, parking);	
		Log.info("parking entered.");
	}
	
	public void selectTerms(){
		scrollAndFind(TERMS);
		this.waitForVisibility(driver,TERMS);
		TERMS.click();	
		Log.info("terms checkbox selected");
	}
	
	public void clickViewTrailbtn(){
		this.waitForVisibility(driver,TRAILPREVIEWBTN);
		scrollAndFind(TRAILPREVIEWBTN);
		TRAILPREVIEWBTN.click();
		sleep(4);
		Log.info("Clicked on view trail button.");
	}
	
	public void clickSubmitTrailBtn(){
		this.waitForVisibility(driver,TRAILSUBMITBTN);
		scrollAndFind(TRAILSUBMITBTN);
		TRAILSUBMITBTN.click();	
		sleep(4);
		Log.info("Clicked on submit trail button.");
		
	}
	
	public void successVerify(){
		checkObjectIsDisplayed(SUCCESSMSG);
		assertEquals(SUCCESSMSG.getText(), "Trail Submitted");
		Log.info("Trail Submitted !!");
	}
	
	public void submitTrailWithValidDetails(String trailName){
		enterTrailName(trailName);
		enterTrailLength(getcelldata("Testcase Data", 9, 3).toString());
		clickCategoryDrp();
		clickoncatOption();
		enterEP1(getcelldata("Testcase Data", 9, 4).toString());
		enterEP2(getcelldata("Testcase Data", 9, 5).toString());
		enterwebsite1(getcelldata("Testcase Data", 9, 6).toString());
		selectSurfaces();
		selectActivities();
		selectState();
		selectCountry();
		enterdescription(getcelldata("Testcase Data", 9, 7).toString());
		enterParking(getcelldata("Testcase Data", 9, 8).toString());
		selectTerms();
		clickViewTrailbtn();
		clickSubmitTrailBtn();
		successVerify();
	}
	
}
