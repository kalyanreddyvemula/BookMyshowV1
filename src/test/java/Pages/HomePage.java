package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Utils.CommonUtils;

public class HomePage {
	
	

    WebDriver driver;
    WebDriverWait wait;
    CommonUtils cu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        cu = new CommonUtils(driver);
    }
    
    @FindBy(xpath = "//input[@id = 'dummy']")
    WebElement searchForCity;
    
    @FindBy(xpath = "//p[@class='sc-1jg5yz-4 hbJJIz']")
    List<WebElement> popularCities;
    
    @FindBy(xpath = "//p[text() = 'View All Cities']")
    WebElement viewAllCities;
    
    @FindBy(xpath = "//p[text() = 'Hide all cities']")
    WebElement hideCities;
    
    @FindBy(xpath = "//li[@class = 'sc-1a0jimq-0 hhOIxv']")
    List<WebElement> allCities;
    
    @FindBy(xpath = "//span[text()='\" + s + \"']")
    WebElement locationVerification;
    
    
    @FindBy(xpath = "//a[text() = 'Movies']")
    WebElement pMovie;
    
    @FindBy(xpath = "//a[contains(@href, 'stream?')]")
    WebElement pStream;
    
    @FindBy(xpath = "//a[text() = 'Events']")
    WebElement pEvents;
    
    @FindBy(xpath = "//a[text() = 'Plays']")
    WebElement pPlays;
    
    @FindBy(xpath = "//a[text() = 'Sports']")
    WebElement pSports;
    
    @FindBy(xpath = "//a[text() = 'Activities']")
    WebElement pActivities;
    
    @FindBy(xpath = "//span[@class = 'sc-1or3vea-16 gPcyDI']")
    WebElement currentCityNodal;
    
    
    public void popularCities(String s) {
    	
    	cu.clickSingleElementinList(popularCities, s);
    	
    }
    
    public Boolean cityNameVisible(String s) {
    	WebElement city =  driver.findElement(By.xpath("//span[text()='" + s + "']"));
    	Boolean oh = city.isDisplayed();
    	return oh;
    }
    
    public void searchforCity(String s) {
    	cu.sendKeys(searchForCity, s);
    	
    }
    
    public void clickMoreCities() {
    	cu.clickElement(viewAllCities);
    }
    
    public void searchAllcities(String s) {
    	
    	cu.clickSingleElementinList(allCities, s);
    	
    }
    
    public void hideCities() {
    	cu.clickElement(hideCities);
    }
    
    public Boolean hidecity() {
    	
    	if(hideCities.isDisplayed()) {
    		return true;
    	}else {
    		return false;
    	}	
    	
    }
    
    public void clickPMovies() {
    	cu.clickElement(pMovie);
    }
    
    public void clickPStream() {
    	cu.clickElement(pStream);
    }
    
    public void clickPEvents() {
    	cu.clickElement(pEvents);
    }
    
    public void clickPPlays() {
    	cu.clickElement(pPlays);
    }
    
    public void clickPSports() {
    	cu.clickElement(pSports);
    }
    
    public void clickPAct() {
    	cu.clickElement(pActivities);
    }
    
    public void cityNodal() {
    	cu.clickElement(currentCityNodal);
    }
    
    public String newCityName() {
    	String cName = currentCityNodal.getText();
    	return cName;
    }
    
   
}

