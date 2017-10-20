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
	
	
	
	public SearchResults(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CheckSearchResults(){
		checkObjectIsDisplayed(SEARCH_RESULTS_ASPEN_AIRPORT);			
		assertEquals(SEARCH_RESULTS_ASPEN_AIRPORT.getText(), "Aspen Airport Business Center Trail");
	}
	
}
