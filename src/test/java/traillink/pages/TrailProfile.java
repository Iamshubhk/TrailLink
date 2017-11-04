package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class TrailProfile extends TestBase {
	
	final WebDriver driver;
	
	@FindBy(xpath="//*[@id='trail-detail-photos']//h1[contains(text(),'Photo')]")
	private WebElement PHOTOLABEL;
	
	@FindBy(xpath="//*[@id='trail-detail-photos']//header//a[contains(text(),'Submit Photo')]")
	private WebElement SUBMITPHOTOBTN;
	
	@FindBy(xpath="//*[@id='trail-detail-reviews']//h1[contains(text(),'Reviews')]")
	private WebElement REVIEWSLABEL;
	
	@FindBy(xpath="//footer//a[contains(text(),'Submit Review')]")
	private WebElement SUBMITREVIEWBTN;
	
	
	@FindBy(xpath="//*[@id='nav-search-keyword']")
	private WebElement KEYWORDTEXTBOX;
	
	@FindBy(xpath="//button[contains(text(),'Change Search')]")
	private WebElement SEARCHBTN;
	
	
	public TrailProfile(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyPhotosLabel(){
		scrollAndFind(PHOTOLABEL);
		checkObjectIsDisplayed(PHOTOLABEL);			
		assertEquals(PHOTOLABEL.getText(), "Photos");
	}
	
	public void verifyReviewsLabel(){
		scrollAndFind(REVIEWSLABEL);
		checkObjectIsDisplayed(REVIEWSLABEL);			
		assertEquals(REVIEWSLABEL.getText(), "Reviews");
	}

	public void enterKeyword(String keyword){
		clearAndwrite(KEYWORDTEXTBOX, keyword);	
	}
	
	public void clickSearchbtn(){
		checkObjectIsDisplayed(SEARCHBTN);
		SEARCHBTN.click();
	}
	
	public void clickOnUploadPhoto(){
		scrollAndFind(SUBMITPHOTOBTN);
		checkObjectIsDisplayed(SUBMITPHOTOBTN);
		SUBMITPHOTOBTN.click();	
	}
	
	public void clickOnSubmitreviews(){
		checkObjectIsDisplayed(SUBMITREVIEWBTN);
		scrollAndFind(SUBMITREVIEWBTN);
		SUBMITREVIEWBTN.click();	
	}
	
}
