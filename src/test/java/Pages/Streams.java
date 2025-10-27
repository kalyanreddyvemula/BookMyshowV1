package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Streams {
	
	WebDriver driver;
	
	public Streams(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[text() = 'New on Stream']")
	WebElement verifyStream;
	
	public Boolean streamDisplayed() {
		Boolean as = verifyStream.isDisplayed();
		return as;
	}

}
