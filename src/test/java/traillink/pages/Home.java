package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class Home extends TestBase {
	
	final WebDriver driver;
	
	@FindBy(xpath="//*[@id='hero-search-location']")
	private WebElement LOCATIONTEXBOX;
	
	@FindBy(xpath="//*[@id='hero-search-keyword']")
	private WebElement KEYWORDTEXBOX;
	
	@FindBy(css=".button.button-small.bold-arvo.search")
	private WebElement SEARCHBUTTON;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome to TrailLink!')]")
	private WebElement WELECOMELABLE;
	
	
	public Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void homePagelableVerify(){
		checkObjectIsDisplayed(WELECOMELABLE);
		assertEquals(WELECOMELABLE.getText(), "Welcome to TrailLink!");
	}
	
	public void enterKeyword(String keyWord){
		this.waitForVisibility(driver,KEYWORDTEXBOX);
		clearAndwrite(KEYWORDTEXBOX, keyWord);	
		Log.info("Password entered.");
	}
	
	public void clickSearch(){
		this.waitForVisibility(driver,SEARCHBUTTON);
		SEARCHBUTTON.click();	
	}
	
	
}
