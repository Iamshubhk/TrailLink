package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class Registration extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//h3[@class='h5 text-center' and contains(text(),'Register with Email')]")
	private WebElement REGISTRATIONPAGELABLE;
	
	@FindBy(xpath="//*[@id='register-modal-email']")
	private WebElement EMAILTEXTBOX;
	
	
	@FindBy(xpath=".//*[@id='register-modal-password']")
	private WebElement PASSWORDTEXTBOX;
	
	@FindBy(xpath="//*[@id='register-modal-terms']")
	private WebElement TERMSCHECKBOX;
	
	@FindBy(xpath="//button[contains(text(),'Register for Free')]")
	private WebElement REGISTERBUTTON;
	
	@FindBy(xpath="//div[@id='page1']//span[contains(text(),'Please fill in the required fields')]")
	private WebElement VALIDATIONREG;
	
	@FindBy(xpath="//div[@id='page1']//span[contains(text(),'email is already in use')]")
	private WebElement DUPLICATEEMAILVALIDATIONREG;
	
	@FindBy(xpath="//*[@id='register-first-name']")
	private WebElement FIRSTNAMETEXTBOX;
	
	@FindBy(xpath="//*[@id='register-last-name']")
	private WebElement LASTNAMETEXTBOX;
	
	@FindBy(xpath="//*[@id='register-zip']")
	private WebElement ZIPTEXTBOX;
	
	@FindBy(css=".button.bold-arvo.show-for-large")
	private WebElement FINISHBUTTON;
	
	@FindBy(xpath="//div[@id='page2']//span[contains(text(),'Please correct all errors')]")
	private WebElement VALIDATIONREGDETAILS;
	
	@FindBy(xpath="//div[@class='hygiene-nav']//a[contains(text(),'Hello, Autotest')]")
	private WebElement REGISTEREDUSERNAMELINK;
	
	
	public Registration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RegistrationlableVerify(){
		checkObjectIsDisplayed(REGISTRATIONPAGELABLE);
		assertEquals(REGISTRATIONPAGELABLE.getText(), "Register with Email");
	}
	
	public void enterEmail(){
		this.waitForVisibility(driver,EMAILTEXTBOX);
		String randomtext = getRandomString(4);
		String email = "Auto"+randomtext+"@mailinator.com";
		clearAndwrite(EMAILTEXTBOX, email);	
		Log.info("Email entered.");
	}
	
	public void enterPassword(){
		this.waitForVisibility(driver,EMAILTEXTBOX);
		String password = "Test123456";
		clearAndwrite(PASSWORDTEXTBOX, password);	
		Log.info("Password entered.");
	}
	
	public void clicktermsCheckbox(){
		checkObjectIsDisplayed(TERMSCHECKBOX);
		TERMSCHECKBOX.click();	
		Log.info("Clicked on terms and condition checkbox.");
	}
	
	public void clickRegisterButton(){
		checkObjectIsDisplayed(REGISTERBUTTON);
		REGISTERBUTTON.click();	
		Log.info("Clicked on Register button.");
	}
	
	public void RegistrationValidationVerify(){
		checkObjectIsDisplayed(VALIDATIONREG);
		assertEquals(VALIDATIONREG.getText(), "Please fill in the required fields");
	}
	
	public void duplicateEmailValidationVerify(){
		checkObjectIsDisplayed(DUPLICATEEMAILVALIDATIONREG);
		assertEquals(DUPLICATEEMAILVALIDATIONREG.getText(), "email is already in use");
	}
	public void RegistrationDetailsValidationVerify(){
		checkObjectIsDisplayed(VALIDATIONREGDETAILS);
		assertEquals(VALIDATIONREGDETAILS.getText(), "Please correct all errors");
	}
	
	public void enterFirstName(String firstName){
		this.waitForVisibility(driver,FIRSTNAMETEXTBOX);
		clearAndwrite(FIRSTNAMETEXTBOX, firstName);	
		Log.info("Firstname entered.");
	}
	
	public void enterLastName(String lastName){
		this.waitForVisibility(driver,LASTNAMETEXTBOX);
		clearAndwrite(LASTNAMETEXTBOX, lastName);	
		Log.info("Lastname entered.");
	}
	
	public void enterZipCode(String zipCode){
		this.waitForVisibility(driver,ZIPTEXTBOX);
		clearAndwrite(ZIPTEXTBOX, zipCode);	
		Log.info("Zipcode entered.");
	}
	
	public void clickFinishButton(){
		checkObjectIsDisplayed(FINISHBUTTON);
		FINISHBUTTON.click();	
		Log.info("Clicked on Finish button.");
	}
	
	public void CheckRegisteredUser(){
		checkObjectIsDisplayed(REGISTEREDUSERNAMELINK);			
		assertEquals(REGISTEREDUSERNAMELINK.getText(), "Hello, Autotest");
	}
	
	
	public void registerUserNegativeCases(String firstName, String lastName, String zipCode){
		clickRegisterButton();
		sleep(3);
		RegistrationValidationVerify();
		clearAndwrite(EMAILTEXTBOX, "testbird2015@gmail.com");
		enterPassword();
		clicktermsCheckbox();
		clickRegisterButton();
		sleep(3);
		duplicateEmailValidationVerify();
		enterEmail();
		clickRegisterButton();
		sleep(3);
		clickFinishButton();
		sleep(3);
		RegistrationDetailsValidationVerify();	
	}
	
	public void registerUser(String firstName, String lastName, String zipCode){
		enterEmail();
		enterPassword();
		clicktermsCheckbox();
		clickRegisterButton();
		sleep(2);
		enterFirstName(firstName);
		enterLastName(lastName);
		enterZipCode(zipCode);
		clickFinishButton();	
	}
}
