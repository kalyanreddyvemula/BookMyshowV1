package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import Pages.Movies;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Tests.HomepageTest;
import Pages.MovieDetails;

import Pages.HomePage;
import static Utils.ExtentTestManager.*;

import java.time.Duration;
import java.util.List;

public class SearchBarTest extends BaseTest {

	
	HomePage hp;
	WebDriverWait wait;
	MovieDetails md;
	HomepageTest hpt;
	Movies mv;
	
	@BeforeMethod
	public void beforeMethod() {
		
		hp = new HomePage(driver);
		hpt = new HomepageTest();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		md = new MovieDetails(driver);
		mv= new Movies(driver);
		
	}
	
	@Test(enabled = false)
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
			
			sa.assertAll();
		}catch(Exception e) {
			logFail("Test Failed Due to Exception: " + e.getMessage());
			throw e;
		}
		
		
		
	}
	
	
	@Test(enabled = false   )
	public void searchRel() {
		String cityName = "Hyderabad";
		String partial = "Oppe";
		SoftAssert sa = new SoftAssert();
		
		logInfo("Checking if the search suggests related to entered text");
		
		try {
			
			hp.popularCities(cityName);
			
			logInfo("Selected: " + cityName);
			
			hp.searchBarClick();
			
			logInfo("Clicked Search");
			
			List<String> asa = hp.checkTextRelation(partial);
			logInfo("Entered Partial text in search");
			
			sa.assertTrue(
				    asa.stream().anyMatch(s -> s.toLowerCase().contains(partial.toLowerCase())),
				    "Did not suggest related text");

			
			logInfo("Flow Passed");
			
			sa.assertAll();
		}catch(Exception e) {
			logFail("Test Failed Due to Exception: " +e.getMessage());
			
		}
	}
	
	@Test
	public void filterGenereAction() {
		
		String cityName = "Hyderabad";
		String genre = "Action";
		SoftAssert sa = new SoftAssert();
		
		logInfo("Apply 'GENERE - ACTION' on Filter and verify it displays related movies");
		
		
		try {
			
			hp.popularCities(cityName);
			logInfo("Selected: " + cityName);
			
			hp.clickPMovies();
			
			logInfo("Clicked Movies");
			
			mv.selectLanguage();
			mv.genereFilter();
			
			logInfo("Clicked Genres");
			
			mv.selectGenere(genre);
			
			logInfo("Selected Genre: " + genre);
			
			
			sa.assertTrue(mv.verifyAction(genre), "genre Not Found");
			
			
			logInfo("Selecting Genre Flow Verified");
			
			
			
			
			
		}catch(Exception e) {
			logFail("Test Failed Due to exception: " + e.getMessage());
			throw e;
		}
	}
}

