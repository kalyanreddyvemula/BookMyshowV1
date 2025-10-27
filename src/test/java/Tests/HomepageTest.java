package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import Pages.Events;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static Utils.ExtentTestManager.*;
import Pages.HomePage;
import Pages.Movies;
import Utils.CommonUtils;
import Pages.Streams;
import Pages.Play;
import Pages.Sports;
import Pages.Activities;


public class HomepageTest extends BaseTest{
	//WebDriver driver;
	HomePage hp;
	Movies movie;
	CommonUtils cu;
	Events event;
	Streams stream;
	Play play;
	Sports sport;
	Activities act;
	
	
	static String cityName = "Kochi";
	
	
	@BeforeMethod
	public void beforeMethod() {
		hp = new HomePage(driver);
		movie = new Movies(driver);
		stream = new Streams(driver);
		event = new Events(driver);
		play = new Play(driver);
		sport = new Sports(driver);
		act = new Activities(driver);
	}
	
	
	@Test
	public void selectPopularCity() {
		
		
		SoftAssert sa= new SoftAssert();
		
		logInfo("Starting the browser and Verifying URL");
		
		try {
			
			
			String expUrl = driver.getCurrentUrl();
			
			String acUrl = "https://in.bookmyshow.com/";
			
			sa.assertEquals(expUrl, acUrl, "Url not Matched");
			
			System.out.println(expUrl);
			
			
			hp.popularCities(cityName);
			
			logInfo("Selected City - " + cityName);
			
			sa.assertTrue(hp.cityNameVisible(cityName), "Wrong city");
			
			logInfo("Verified City Name ( " + cityName + " )  after selecting city");
			
			
			
		}catch(Exception e) {
			 logFail("Test failed due to exception: " + e.getMessage());
			 throw e; 
		}
		sa.assertAll();
		
	}
	
	//TEST PASSED
	@Test(enabled = false)
	public void selectCityOnSearch() {
		
		String cityName = "Hyderabad";
		
		
		SoftAssert sa= new SoftAssert();
		
		logInfo("Starting the browser and Verifying URL");
		
		try {
			
			
			String expUrl = driver.getCurrentUrl();
			
			String acUrl = "https://in.bookmyshow.com/";
			
			sa.assertEquals(expUrl, acUrl, "Url not Matched");
			
			System.out.println(expUrl);
			
			
			hp.searchforCity(cityName);
			
			logInfo("Selected City - " + cityName);
			
			sa.assertTrue(hp.cityNameVisible(cityName), "Wrong city");
			
			logInfo("Verified City Name ( " + cityName + " )  after selecting city");
			
			
			
			
			
		}catch(Exception e) {
			logFail("Test failed due to exception: " + e.getMessage());
			throw e; 
		}
		sa.assertAll();
		
	}
	
	//TEST PASSED
	@Test(enabled = false)
	public void veiwingAllCities() {
		
		String cityName = "Armoor";
		
		
		SoftAssert sa= new SoftAssert();
		
		logInfo("Starting the browser and Verifying URL");
		
		try {
			
			
			String expUrl = driver.getCurrentUrl();
			
			String acUrl = "https://in.bookmyshow.com/";
			
			sa.assertEquals(expUrl, acUrl, "Url not Matched");
			
			System.out.println(expUrl);
			
			hp.clickMoreCities();
			
			hp.searchAllcities(cityName);
			
			logInfo("Selected City - " + cityName);
			
			sa.assertTrue(hp.cityNameVisible(cityName), "Wrong city");
			
			logInfo("Verified City Name ( " + cityName + " )  after selecting city");
			
			
			
			
			
		}catch(Exception e) {
			logFail("Test failed due to exception: " + e.getMessage());
			throw e; 
		}
		sa.assertAll();
		
	}
	
	//TEST PASSED
	@Test(enabled = false)
	public void clickAndClose() {

		
		SoftAssert sa= new SoftAssert();
		
		logInfo("Starting the browser and Verifying URL");
		
		try {
			
			
			String expUrl = driver.getCurrentUrl();
			
			String acUrl = "https://in.bookmyshow.com/";
			
			sa.assertEquals(expUrl, acUrl, "Url not Matched");
			
			System.out.println(expUrl);
			
			hp.clickMoreCities();
			
			logInfo("Clicked on View All Cities");
			
			hp.hideCities();
			
			logInfo("Cities are hided");
			
			sa.assertTrue(hp.hidecity(), "Hide City is still displaying");
		
				
			
			
		}catch(Exception e) {
			logFail("Test failed due to exception: " + e.getMessage());
			throw e; 
		}
		sa.assertAll();
		
	}
	
	@Test(enabled = false)
	public void checkProgram() throws Exception {
		
		SoftAssert sa = new SoftAssert();
		
		
		logInfo("Clicking Programs Mentioned in Book My Show");
		try {

			
			logInfo("1. Clicked movie program at Location: "  + cityName);
			
			hp.clickPMovies();
			
			if(movie.verifyMovieDispaly(cityName).isDisplayed()) {
				logInfo("Movies in " + cityName + " is Displayed");
			}else {
				logFail("Message displayed in correctly");
			}	
			
			
			hp.clickPStream();
			
			
			
			logInfo("2. Clicked Stream Program at Location: " + cityName);
			
			sa.assertTrue(stream.streamDisplayed(), "Not Displayed");
			
			logInfo("Stream displayed");
			
			hp.clickPEvents();
			
			if(event.verifyEventDispaly(cityName).isDisplayed()) {
				logInfo("Event in " + cityName + " is Displayed");
			}else {
				logFail("Message displayed in correctly");
			}	
			
			
			hp.clickPPlays();
			
			if(play.verifyPlaysDispaly(cityName).isDisplayed()) {
				logInfo("Plays in " + cityName + " is Displayed");
			}else {
				logFail("Message displayed in correctly");
			}	
			
			hp.clickPSports();
			
			

			if(sport.verifySportDispaly(cityName).isDisplayed()) {
				logInfo("Plays in " + cityName + " is Displayed");
			}else {
				logFail("Message displayed in correctly");
			}
			
			
			hp.clickPAct();
			act.verifyActDispaly(cityName);
			

			if(act.verifyActDispaly(cityName).isDisplayed()) {
				logInfo("Plays in " + cityName + " is Displayed");
			}else {
				logFail("Message displayed in correctly");
			}
			
			
			
			
		}catch (Exception e){

			logFail("Test Failed due to exception: " + e.getMessage());
			throw e;
		}
		
		sa.assertAll();
	}
	
	@Test(dependsOnMethods = "selectPopularCity")
	public void changeCity() {
		
		SoftAssert sa = new SoftAssert();
		
		logInfo("Changing city");
		
		try {
			
			hp.cityNodal();
			logInfo("Clicked on Current City - " + cityName);
			
			String cityName1 = "Hyderabad";
			
			hp.popularCities(cityName1);
			
			logInfo("Selected New City - " + cityName1);
			
			sa.assertNotEquals(hp.newCityName(), cityName1, "City Name Matched");
			
			logInfo("City Changed");
			
			
			
		}catch(Exception e) {
			
			logFail("Test Failed due to Exception: " + e.getMessage());
			throw e;
			
		}
	}
}
