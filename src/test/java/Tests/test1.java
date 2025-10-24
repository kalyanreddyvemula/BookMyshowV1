package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.HomePage;


public class test1 extends BaseTest {
	
	static WebDriver driver;
	
	HomePage hp;
	
	
	
	@BeforeMethod
	public void pages() {
		
		hp = new HomePage(driver);
		
	}
	
	@Test
	public void testCase01()   {
		
		
	}
	

}
