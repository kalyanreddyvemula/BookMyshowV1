package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utils.ExtentTestManager.*;

import Pages.HomePage;


public class HomepageTest extends BaseTest{
	//WebDriver driver;
	HomePage hp;
	
	
	@BeforeMethod
	public void beforeMethod() {
		hp = new HomePage(driver);
	}
	
	
	@Test(enabled = false)
	public void selectPopularCity() {
		
		String cityName = "Kochi";
		
		
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
			System.out.println(e.getMessage());
		}
		sa.assertAll();
		
	}
	
	
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
			System.out.println(e.getMessage());
		}
		sa.assertAll();
		
	}
	
	
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
			System.out.println(e.getMessage());
		}
		sa.assertAll();
		
	}
	
	@Test
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
			System.out.println(e.getMessage());
		}
		sa.assertAll();
		
	}
}
