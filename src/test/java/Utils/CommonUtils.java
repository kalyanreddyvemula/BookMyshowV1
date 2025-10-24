package Utils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CommonUtils {
	
	WebDriver driver;
	
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
	
	
}
