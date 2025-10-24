package Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Driver.Driver;
import Utils.ExtentTestManager;
import Utils.CommonUtils;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void createDriver() {
        Driver.setupDriver("chrome");
        driver = Driver.getDriver();
        driver.get("https://in.bookmyshow.com/");
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        ExtentTestManager.startTest(m.getName());
    }

    @AfterMethod
    public void afterEachMethod(ITestResult result, Method m) throws IOException {
        if(result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.logPass(m.getName() + " is Passed");
        } else if(result.getStatus() == ITestResult.FAILURE) {
            String base64Screenshot = CommonUtils.captureScreenshot(driver);  // Returns Base64 string
            ExtentTestManager.logScreenShot(result.getThrowable().getMessage(), base64Screenshot);
        } else {
            ExtentTestManager.logSkip(m.getName() + " is Skipped");
        }
    }

    @AfterClass
    public void afterTestComplete() {
        Driver.tearDown();
        ExtentTestManager.endTestandFlush();
    }
}

