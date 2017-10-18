package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

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
		loggers.log(Status.INFO, "Email entered.");
	}
	
	public void enterPassword(){
		this.waitForVisibility(driver,EMAILTEXTBOX);
		String password = "Test123456";
		clearAndwrite(PASSWORDTEXTBOX, password);	
		loggers.log(Status.INFO, "Password entered.");
	}
	
	public void clicktermsCheckbox(){
		checkObjectIsDisplayed(TERMSCHECKBOX);
		TERMSCHECKBOX.click();	
		loggers.log(Status.INFO, "Clicked on terms and condition checkbox.");
	}
	
	public void clickRegisterButton(){
		checkObjectIsDisplayed(REGISTERBUTTON);
		REGISTERBUTTON.click();	
		loggers.log(Status.INFO, "Clicked on Register button.");
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
		loggers.log(Status.INFO, "Firstname entered.");
	}
	
	public void enterLastName(String lastName){
		this.waitForVisibility(driver,LASTNAMETEXTBOX);
		clearAndwrite(LASTNAMETEXTBOX, lastName);	
		loggers.log(Status.INFO, "Lastname entered.");
	}
	
	public void enterZipCode(String zipCode){
		this.waitForVisibility(driver,ZIPTEXTBOX);
		clearAndwrite(ZIPTEXTBOX, zipCode);	
		loggers.log(Status.INFO, "Zipcode entered.");
	}
	
	public void clickFinishButton(){
		checkObjectIsDisplayed(FINISHBUTTON);
		FINISHBUTTON.click();	
		loggers.log(Status.INFO, "Clicked on Finish button.");
	}
	
	public void CheckRegisteredUser(){
		checkObjectIsDisplayed(REGISTEREDUSERNAMELINK);			
		assertEquals(REGISTEREDUSERNAMELINK.getText(), "Hello, Autotest");
	}
	
	public void registerUser(String firstName, String lastName, String zipCode){
		clickRegisterButton();
		sleep(2);
		RegistrationValidationVerify();
		clearAndwrite(EMAILTEXTBOX, "testbird2015@gmail.com");
		enterPassword();
		clicktermsCheckbox();
		clickRegisterButton();
		sleep(2);
		duplicateEmailValidationVerify();
		enterEmail();
		clickRegisterButton();
		sleep(2);
		clickFinishButton();
		sleep(2);
		RegistrationDetailsValidationVerify();
		sleep(2);
		enterFirstName(firstName);
		enterLastName(lastName);
		enterZipCode(zipCode);
		clickFinishButton();	
	}
}
