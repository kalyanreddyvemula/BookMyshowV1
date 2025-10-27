package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MovieDetails {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public MovieDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath = "//h1[@class = 'sc-qswwm9-6 ea-drWB']")
	WebElement movieTitle;

	
	@FindBy(xpath = "//div[@class = 'sc-ycjzp1-1 Jqofz']//h5")
	WebElement movieRating;
	
	@FindBy(xpath = "//div[@class = 'sc-ycjzp1-1 Jqofz']//h6")
	WebElement movieVotes;
	
	@FindBy(xpath = "//div[@class = 'sc-o4g232-3 hLIMsj']/span")
	WebElement aboutMovie;
	
	
	public String movieTitle() {
		
		wait.until(ExpectedConditions.visibilityOf(movieTitle));
		String mName = movieTitle.getText().trim();
		return mName;
	}
	
	public String movieRating() {
		wait.until(ExpectedConditions.visibilityOf(movieRating));
		String mRating = movieRating.getText().trim();
		return mRating;
	}
	
	public String movieVotes() {
		wait.until(ExpectedConditions.visibilityOf(movieVotes));
		String votes = movieVotes.getText().trim();
		return votes;
	}
	
	public String aboutMovie() {
		wait.until(ExpectedConditions.visibilityOf(aboutMovie));
		String about = aboutMovie.getText().trim();
		return about;
	}
	
	public String movieT() {
		String na = movieTitle.getText().trim();
		return na;
	}
}

