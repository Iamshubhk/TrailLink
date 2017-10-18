package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

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
		loggers.log(Status.INFO, "New Password entered.");
	}
	
	public void enterConfirmPassword(String password){
		this.waitForVisibility(driver,CONFIRMPASSWORDTEXTBOX);
		clearAndwrite(CONFIRMPASSWORDTEXTBOX, password);	
		loggers.log(Status.INFO, "Confirm Password entered.");
	}
	
	public void clickSaveButton(){
		this.waitForVisibility(driver,SAVEBUTTON);
		scrollAndFind(SAVEBUTTON);
		SAVEBUTTON.click();
		sleep(3000);
		loggers.log(Status.INFO, "Clicked on save profile button.");
	}
	
	public void enterFirstName(String firstName){
		this.waitForVisibility(driver,FIRSTNAME);
		clearAndwrite(FIRSTNAME, firstName);	
	}
	
}
