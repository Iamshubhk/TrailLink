package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class SubmitReviews extends TestBase {
	
	final WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Submit a Review')]")
	private WebElement SUBMITREVIEWLABEL;
	
	
	@FindBy(xpath="//*[@id='review-form']//span[@data-rating='4']")
	private WebElement FOURSTARRATING;
	
	@FindBy(xpath="//*[@id='account-form-review-title']")
	private WebElement REVIEWTITLE;
	
	@FindBy(xpath="//*[@id='account-form-review-text']")
	private WebElement DESCRIPTION;
	
	@FindBy(xpath="//*[@id='btn-preview-review']")
	private WebElement PREVIEWBTN;
	
	@FindBy(xpath="//*[@id='btn-submit-review']")
	private WebElement SUBMITBTN;
	
	
	
	public SubmitReviews(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifySubmitReviewLabel(){
		checkObjectIsDisplayed(SUBMITREVIEWLABEL);			
		assertEquals(SUBMITREVIEWLABEL.getText(), "Submit a Review");
	}
	
	public void clickOnRatings(){
		checkObjectIsDisplayed(FOURSTARRATING);
		FOURSTARRATING.click();	
	}

	public void enterReviewTitle(String title){
		clearAndwrite(REVIEWTITLE, title);	
	}
	
	public void enterReviewDesc(String desc){
		clearAndwrite(DESCRIPTION, desc);	
	}
	
	public void clickOnPreview(){
		checkObjectIsDisplayed(PREVIEWBTN);
		PREVIEWBTN.click();	
		sleep(4);
	}
	public void clickOnSubmit(){
		checkObjectIsDisplayed(SUBMITBTN);
		SUBMITBTN.click();	
		sleep(4);
	}
	
}
