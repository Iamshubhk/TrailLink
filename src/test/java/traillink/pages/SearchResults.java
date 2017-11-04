package traillink.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import traillink.testbase.TestBase;

public class SearchResults extends TestBase {
	
	final WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id, 'trailresult_')]//span[contains(text(),'Aspen Airport Business Center Trail')]")
	private WebElement SEARCH_RESULTS_ASPEN_AIRPORT;
	
	@FindBy(xpath="//*[@id='nav-search-keyword']")
	private WebElement KEYWORDTEXTBOX;
	
	@FindBy(xpath="//button[contains(text(),'Change Search')]")
	private WebElement SEARCHBTN;
	
	@FindBy(css=".button.search.button-small")
	private WebElement SEARCHBTN2;
	
	
	public SearchResults(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CheckSearchResults(){
		checkObjectIsDisplayed(SEARCH_RESULTS_ASPEN_AIRPORT);			
		assertEquals(SEARCH_RESULTS_ASPEN_AIRPORT.getText(), "Aspen Airport Business Center Trail");
	}
	
	public void enterKeyword(String keyword){
		clearAndwrite(KEYWORDTEXTBOX, keyword);	
		Log.info("keyword entered.");
	}
	
	public void clickSearchbtn(){
		checkObjectIsDisplayed(SEARCHBTN);
		SEARCHBTN.click();	
	}
	
	public void clickSearchOnProfile(){
		checkObjectIsDisplayed(SEARCHBTN2);
		SEARCHBTN2.click();	
		sleep(3);
	}
	
	public void clickOnResult(){
		checkObjectIsDisplayed(SEARCH_RESULTS_ASPEN_AIRPORT);
		SEARCH_RESULTS_ASPEN_AIRPORT.click();		
	}
	
}
