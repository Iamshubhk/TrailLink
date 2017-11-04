package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class Header extends TestBase {
	
	final WebDriver driver;
	
	@FindBy(xpath="//div[@class='hygiene-nav']//a[contains(text(),'Log in')]")
	private WebElement LOGINLINK;
	
	@FindBy(xpath="//div[@class='hygiene-nav']//a[contains(text(),'Log Out')]")
	private WebElement LOGOUTLINK;
	
	@FindBy(xpath="//div[@class='hygiene-nav']//a[contains(text(),'Register')]")
	private WebElement REGISTRATIONPAGELINK;
	
	@FindBy(xpath="//a[contains(text(),'My TrailLink')]")
	private WebElement MYTRAILLINK;
	
	@FindBy(xpath="//*[@id='main-menu']//a[contains(text(),'My Profile')]")
	private WebElement MYPROFILE;
	
	@FindBy(xpath="//*[@id='main-menu']//a[contains(text(),'My Trails')]")
	private WebElement MYTRAIL;
	
	@FindBy(xpath="//*[@id='main-menu']//a[contains(text(),'My Photos')]")
	private WebElement MYPHOTOS;
	
	@FindBy(xpath="//*[@id='main-menu']//a[contains(text(),'My Reviews')]")
	private WebElement MYREVIEWS;
	
	@FindBy(xpath="//div[@class='hygiene-nav']//a[contains(text(),'Hello,')]")
	private WebElement MYPROFILENAME;
	
	public Header(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogin(){
		this.waitForVisibility(driver,LOGINLINK);
		LOGINLINK.click();
		sleep(1000);
	}
	
	public void clickLogout(){
		this.waitForVisibility(driver,LOGOUTLINK);
		LOGINLINK.click();
		sleep(5000);
	}
	
	public void clickRegister(){
		this.waitForVisibility(driver,REGISTRATIONPAGELINK);
		REGISTRATIONPAGELINK.click();	
	}
	
	public void CheckLogoutLink(){
		checkObjectIsDisplayed(LOGOUTLINK);			
		assertEquals(LOGOUTLINK.getText(), "Log Out");
	}
	
	public void HoverMytrail(){
		checkObjectIsDisplayed(MYTRAILLINK);	
		mouseOverToElement(driver,MYTRAILLINK);
		sleep(1000);
	}
	
	public void ClickonMyProfile(){
		this.waitForVisibility(driver,MYPROFILE);	
		MYPROFILE.click();
	}
	
	public void clickMyTrail(){
		this.waitForVisibility(driver,MYTRAIL);
		MYTRAIL.click();	
	}
	
	public void clickMyPhotos(){
		this.waitForVisibility(driver,MYPHOTOS);
		MYPHOTOS.click();	
	}
	
	public void clickMyReviews(){
		this.waitForVisibility(driver,MYREVIEWS);
		MYREVIEWS.click();	
		sleep(4);
	}
	
	public String getMyProfileName(){
		this.waitForVisibility(driver,MYPROFILENAME);
		return MYPROFILENAME.getText();
	}
}
