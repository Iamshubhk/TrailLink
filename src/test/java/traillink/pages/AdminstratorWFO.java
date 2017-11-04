package traillink.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class AdminstratorWFO extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@class='loginheader']")
	private WebElement LOGINPAGELABLE;
	
	@FindBy(xpath="//input[@id[contains(.,'UserName')]]")
	private WebElement USERNAMETEXTBOX;
	
	
	@FindBy(xpath="//input[@id[contains(.,'Password')]]")
	private WebElement PASSWORDTEXTBOX;
	
	@FindBy(xpath="//input[@id[contains(.,'LoginButton')]]")
	private WebElement LOGINBUTTON;
		
	@FindBy(xpath="//*[@id='sidenav']//a[contains(text(),'Accounts')]")
	private WebElement AFTERLOGINPAGE;
	
	@FindBy(xpath="//*[@id='sidenav']//a[contains(text(),'TrailLink')]")
	private WebElement TRAILLINK;
	
	@FindBy(xpath="//*[@id='sidenav']//a[contains(text(),'Approve TL Reviews')]")
	private WebElement APPROVEREVIEWLINK;
	
	@FindBy(xpath="//*[@id='sidenav']//a[contains(text(),'Approve TL Photos')]")
	private WebElement APPROVEPHOTOLINK;
	
	@FindBy(xpath="//*[@id='sidenav']//a[contains(text(),'Approve TL Trails')]")
	private WebElement APPROVETRAIL;
	
	@FindBy(xpath="//*[@id[contains(.,'AcctStatus')]]")
	private WebElement TRAILSTATUSDROPDOWN;
	
	@FindBy(xpath="//*[@id[contains(.,'AcctStatus')]]//option[@value='O']")
	private WebElement TRAILSTATUSOPEN;	
	
	@FindBy(xpath="//*[@id[contains(.,'Update')]]")
	private WebElement UPDATEBUTTON;	
	
	@FindBy(xpath="//input[contains(@value, 'Save') and not(contains(@value, 'Return to'))]")
	private WebElement SAVEBUTTON;
		
	
	public AdminstratorWFO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginlableVerify(){
		checkObjectIsDisplayed(LOGINPAGELABLE);
		assertEquals(LOGINPAGELABLE.getText(), "Winfunds Online");
	}
	
	public void enterUsername(String email){
		this.waitForVisibility(driver,USERNAMETEXTBOX);
		clearAndwrite(USERNAMETEXTBOX, email);	
		Log.info("Email entered.");
	}
	
	public void enterPassword(String password){
		this.waitForVisibility(driver,PASSWORDTEXTBOX);
		clearAndwrite(PASSWORDTEXTBOX, password);	
		Log.info("Password entered.");
	}
	
	public void clickLoginButton(){
		checkObjectIsDisplayed(LOGINBUTTON);
		LOGINBUTTON.click();
		sleep(5000);
		Log.info("Clicked on Login button.");
	}
	
	public void loginVerify(){
		checkObjectIsDisplayed(AFTERLOGINPAGE);
		assertEquals(AFTERLOGINPAGE.getText(), "Accounts");
	}
	
	public void clickTrailLink(){
		checkObjectIsDisplayed(TRAILLINK);
		TRAILLINK.click();
		sleep(3);
	}
	
	public void clickApprovePhotoLink(){
		checkObjectIsDisplayed(APPROVEPHOTOLINK);
		APPROVEPHOTOLINK.click();
		sleep(3);
	}
	
	public void approveReviews(String reviewtext){
		String dropdownxpath = "//span[contains(text(),'"+reviewtext+"')]//..//../td[1]";
		String statusxpath = "//span[contains(text(),'"+reviewtext+"')]//..//../td[1]//option[@value='A']";
		driver.findElement(By.xpath(dropdownxpath)).click();
		sleep(1);
		driver.findElement(By.xpath(statusxpath)).click();
		sleep(3);
	}
	
	public void clickOnTrailID(String trailName){
		String dropdownxpath = "//*[@id[contains(.,'Trails')]]//td[contains(text(),'"+trailName+"')]/preceding-sibling::td//a";
		driver.findElement(By.xpath(dropdownxpath)).click();
		sleep(3);
	}
	
	public void selectOpenStatus(){
		checkObjectIsDisplayed(TRAILSTATUSOPEN);
		TRAILSTATUSDROPDOWN.click();
		sleep(2);
		TRAILSTATUSOPEN.click();
		sleep(2);
	}
	
	public void approvePhotos(String photoCaption){	
		String dropdownxpath = "//td[contains(text(),'"+photoCaption+"')]//..//select[@id[contains(.,'Reviews')]]";
		String statusxpath = "//td[contains(text(),'"+photoCaption+"')]//..//select[@id[contains(.,'Reviews')]]//option[@value='A']";
		WebElement wb =driver.findElement(By.xpath(dropdownxpath));
		scrollAndFind(wb);
		wb.click();
		sleep(1);
		driver.findElement(By.xpath(statusxpath)).click();
		sleep(3);
	}
	
	public void clickApproveReviewLink(){
		checkObjectIsDisplayed(APPROVEREVIEWLINK);
		APPROVEREVIEWLINK.click();
		sleep(3);
	}
	
	public void clickApproveTL(){
		checkObjectIsDisplayed(APPROVETRAIL);
		APPROVETRAIL.click();
		sleep(3);
	}
	
	public void clickOnUpdate(){
		checkObjectIsDisplayed(UPDATEBUTTON);
		scrollAndFind(UPDATEBUTTON);
		UPDATEBUTTON.click();
		sleep(3);
	}
	
	public void clickOnSave(){
		checkObjectIsDisplayed(SAVEBUTTON);
		scrollAndFind(SAVEBUTTON);
		SAVEBUTTON.click();
		sleep(3);
	}
	
	
	public void navigateToAdminEnv(){
		String Url = environment.getProperty("AdminURL");
		openUrlinNewTab(driver,Url);
		sleep(5);
	}
	
	public void doLogin(){
		String userName = environment.getProperty("WFOusername");
		String password = environment.getProperty("AdminPassword");
		enterUsername(userName);
		enterPassword(password);
		clickLoginButton();	
	}
}
