package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class SubmitPhotos extends TestBase {
	
	final WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Submit Photo')]")
	private WebElement SUBMITPHOTOLABEL;
	
	
	//@FindBy(xpath="//input[@type='file']")
	@FindBy(xpath="//*[@id='UploadedImage']")
	private WebElement BROWSEBTN;
	
	
	@FindBy(xpath="//*[@id='account-form-page-title']")
	private WebElement PHOTOTITLE;
	
	@FindBy(xpath="//*[@id='account-form-page-caption']")
	private WebElement PHOTOCAPTION;
	
	@FindBy(xpath="//button[contains(text(),'Submit Photo')]")
	private WebElement SUBMITBTN;
	
	@FindBy(xpath="//*[contains(text(),'Thank you for submitting your photo')]")
	private WebElement SUCCESSMSG;
	
	
	
	public SubmitPhotos(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifySubmitPhotosLabel(){
		checkObjectIsDisplayed(SUBMITPHOTOLABEL);			
		assertEquals(SUBMITPHOTOLABEL.getText(), "Submit Photo");
	}
	
	public void verifySubmitSuccess(){
		checkObjectIsDisplayed(SUCCESSMSG);			
		assertEquals(SUCCESSMSG.getText(), "Thank you for submitting your photo");
	}

	public void enterPhotoTitle(String title){
		clearAndwrite(PHOTOTITLE, title);	
	}
	
	public void enterPhotoCaption(String caption){
		scrollAndFind(PHOTOCAPTION);
		checkObjectIsDisplayed(PHOTOCAPTION);
		clearAndwrite(PHOTOCAPTION, caption);	
	}
	
	public void UploadPhoto(String fileName){
		checkObjectIsDisplayed(BROWSEBTN);
		uploadFile(BROWSEBTN,fileName);
	}
	
	public void clickOnSubmitPhoto(){
		checkObjectIsDisplayed(SUBMITBTN);
		SUBMITBTN.submit();
	}
	
}
