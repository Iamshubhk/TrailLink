package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class Login extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//h3[@class='h5 text-center' and contains(text(),'Log in with Email or Username')]")
	private WebElement LOGINPAGELABLE;
	
	@FindBy(xpath="//*[@id='login-modal-email']")
	private WebElement EMAILTEXTBOX;
	
	
	@FindBy(xpath="//*[@id='login-modal-password']")
	private WebElement PASSWORDTEXTBOX;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	private WebElement LOGINBUTTON;
	
	@FindBy(xpath="//*[@id='login-modal-error-form']")
	private WebElement LOGINVALIDATION;
	
	@FindBy(xpath="//span[contains(text(),'Your email or password was incorrect. Please try again.')]")
	private WebElement LOGININVALIDEMAILVAL;
	
	@FindBy(css="#login-error-form")
	private WebElement LOGINERROR;

	
	
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginlableVerify(){
		checkObjectIsDisplayed(LOGINPAGELABLE);
		assertEquals(LOGINPAGELABLE.getText(), "Log in with Email or Username");
	}
	
	public void enterEmail(String email){
		this.waitForVisibility(driver,EMAILTEXTBOX);
		clearAndwrite(EMAILTEXTBOX, email);	
		Log.info("Email entered.");
	}
	
	public void enterPassword(String password){
		this.waitForVisibility(driver,EMAILTEXTBOX);
		
		clearAndwrite(PASSWORDTEXTBOX, password);	
		Log.info("Password entered.");
	}
	
	public void clickLoginButton(){
		checkObjectIsDisplayed(LOGINBUTTON);
		LOGINBUTTON.click();
		sleep(5000);
		Log.info("Clicked on Login button.");
	}
	
	public void loginValidationVerify(){
		checkObjectIsDisplayed(LOGINVALIDATION);
		assertEquals(LOGINVALIDATION.getText(), "Please fill in the required fields");
	}
	
	public void loginInvalidEmailVerify(){
		checkObjectIsDisplayed(LOGININVALIDEMAILVAL);
		assertEquals(LOGININVALIDEMAILVAL.getText(), "Your email or password was incorrect. Please try again.");
	}
	
	public void doLogin(){
		String email = environment.getProperty("email");
		String password = environment.getProperty("password");
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();	
	}
	
	
	public void doLoginNagativeCase(){
		String email = environment.getProperty("email");
		String password = environment.getProperty("password");
		clickLoginButton();
		sleep(3);
		loginValidationVerify();
		sleep(2);
		enterEmail("Invalid Email");
		enterPassword(password);
		clickLoginButton();
		sleep(3);
		loginInvalidEmailVerify();
		sleep(2);
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();	
	}
}
