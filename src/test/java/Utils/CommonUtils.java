package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CommonUtils {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	final static String screenShotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator;
	
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public static String captureScreenshot(WebDriver driver) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File(screenShotPath+"Test_Fail_Screenshot_" + timeStamp + ".png");
		
		FileUtils.copyFile(sourceFile, destinationFile);
		
		String filePath = destinationFile.getAbsolutePath();
	
		System.out.println("Screenshot saved at: " + filePath);
		
		return filePath;
		
		
	}
	
	
	public  void clickElement(WebElement element) {
		
		try {
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			
			
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
	}
	
	public  void sendKeys(WebElement element, String s) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element)).click();
			
			element.clear();
			element.sendKeys(s, Keys.ENTER);
			
			
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public  void clickSingleElementinList(List<WebElement> element, String s) {
		
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			for(WebElement el : element) {
				String city = el.getText().trim();
				if(city.equalsIgnoreCase(s)) {
					el.click();
					System.out.println("Clicked City: " + city);
					return;
				}
			}
	        System.out.println("Element with text '" + s + "' not found in list.");

		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
	}
	
	
	public void goBack() {
		driver.navigate().back();
	}
	
	
	
	
	
	

	
}
