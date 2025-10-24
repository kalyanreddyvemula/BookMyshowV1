package Utils;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class ExtentTestManager {
	
	static ExtentReports exRerports = ExtentManager.getExtentReport();
	
	static Map<Long, ExtentTest> extentMap = new HashMap<>();
	
	public static ExtentTest startTest(String testName) {
		ExtentTest eTest = exRerports.createTest(testName);
		extentMap.put(Thread.currentThread().getId(), eTest);
		return eTest;
	}
	
	public static ExtentTest getExtentTest() {
		return extentMap.get(Thread.currentThread().getId());
	}
	
	public static void logInfo(String info) {
		
		getExtentTest().log(Status.INFO, info);
		
	}
	
	public static void logPass(String info) {
		getExtentTest().log(Status.PASS, info);
	}
	
	public static void logFail(String info) {
		getExtentTest().log(Status.FAIL, info);
	}
	
	public static void logSkip(String info) {
		
		getExtentTest().log(Status.SKIP, info);
		
	}
	
	public static void logScreenShot(String errorDetails, String screenShotPath) {
		
		getExtentTest().fail(errorDetails).addScreenCaptureFromPath(screenShotPath);
		
	}
	
	public static void endTestandFlush() {
		exRerports.flush();
	}
}


