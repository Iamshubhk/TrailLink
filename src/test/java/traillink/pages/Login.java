package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

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
		loggers.log(Status.INFO, "Email entered.");
	}
	
	public void enterPassword(String password){
		this.waitForVisibility(driver,EMAILTEXTBOX);
		
		clearAndwrite(PASSWORDTEXTBOX, password);	
		loggers.log(Status.INFO, "Password entered.");
	}
	
	public void clickLoginButton(){
		checkObjectIsDisplayed(LOGINBUTTON);
		LOGINBUTTON.click();
		sleep(5000);
		loggers.log(Status.INFO, "Clicked on Login button.");
	}
	
	public void doLogin(){
		String email = environment.getProperty("email");
		String password = environment.getProperty("password");
		clickLoginButton();	
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();	
	}
}
