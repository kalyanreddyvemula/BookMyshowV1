package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    
    @FindBy(xpath = "//div[@class = 'sc-1or3vea-13 kbbBtJ']")
    WebElement searchBar;
    
    @FindBy(xpath = "//input[@class = 'sc-vuznvr-5 extnng']")
    WebElement searchInActive;
    
    
    @FindBy(xpath = "//a[text() = 'About Us']")
    WebElement aboutusFooter;
    
    @FindBy(xpath = "//a[text() = 'Terms and Conditions']")
    WebElement footerTandC;
    
    @FindBy(xpath = "//a[text() = 'Privacy Policy']")
    WebElement pandPfooter;
    
    @FindBy(xpath = "//span[@class = 'sc-f42fb7-2 ieglPM']")
    List<WebElement> suggestions;
    
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
    
    public void searchBarClick() {
    	cu.clickElement(searchBar);
    }
   
    public void searchText(String program) {
    	cu.sendKeys(searchInActive, program);
    	
    }
    
    public void scrolltoAbout() {
    	cu.clickElement(aboutusFooter);  	
    	
    }
    
    public void scrolltoTandC () {
    	cu.clickElement(footerTandC);  	
    	
    }
    
    public void scrolltoPP () {
    	cu.clickElement(pandPfooter);  	
    }
    
    public void back() {
    	cu.goBack();
    }
    
    public void clickSuggestion(String s) {
    	searchInActive.click();
    	searchInActive.sendKeys(s);
    	
    	boolean Clicked = false;
    	
    	wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
    	
    	for(int i = 0; i<suggestions.size(); i++) {
    		
    		String sasa = suggestions.get(i).getText().trim();
    		if(sasa.contains(s)) {
    			suggestions.get(i).click();
    			Clicked = true;
    			break;
    		}
    		
    	}
    	if(!Clicked) {
			System.out.println("No Suggestion found: " +s);
		}	
    	
    }
    
    public List<String> checkTextRelation(String s) throws InterruptedException {
    	
    	searchInActive.click();
    	searchInActive.clear();
    	searchInActive.sendKeys(s);
    	
    	Thread.sleep(2000);
    	
    	
    	wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
    	
    	List<String> sugg = new ArrayList<>();
    	
    	int count = Math.min(3, suggestions.size());
    	
    	for(int i=0; i<count; i++) {
    		String sasa = suggestions.get(i).getText().trim();  
    		sugg.add(sasa);
    		
    	}
    	
    	System.out.println(sugg);
    	
    	return sugg;
    	
    }
    
    
}

