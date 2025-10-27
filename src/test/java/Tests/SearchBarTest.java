package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Tests.HomepageTest;
import Pages.MovieDetails;

import Pages.HomePage;
import static Utils.ExtentTestManager.*;

import java.time.Duration;

public class SearchBarTest extends BaseTest {

	
	HomePage hp;
	WebDriverWait wait;
	MovieDetails md;
	HomepageTest hpt;
	
	@BeforeMethod
	public void beforeMethod() {
		
		hp = new HomePage(driver);
		hpt = new HomepageTest();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		md = new MovieDetails(driver);
		
	}
	
	@Test
	public void searchMovie() throws Exception {
		
		String cityName = "Hyderabad";
		String ProgramName = "K-Ramp";
		
		SoftAssert sa = new SoftAssert();
		
		logInfo("Verifying search functionality to get result of exact search");
		
		try {
			
			hp.popularCities(cityName);
			
			logInfo("Selected: "  + cityName);
			
			
			hp.searchBarClick();
			
			logInfo("Clicked on Search");
			
			
			
			hp.clickSuggestion(ProgramName);
			
			logInfo("Program found and clicked for more details");
			
			logInfo(md.movieT());
			
			sa.assertEquals(md.movieT(), ProgramName, "Titlte Verification failed");
			
			logInfo("Flow Passed");
			
			
		}catch(Exception e) {
			logFail("Test Failed Due to Exception: " + e.getMessage());
			throw e;
		}
		
		
		
	}
}
