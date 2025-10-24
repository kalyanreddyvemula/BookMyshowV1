package Utils;


import java.io.File;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {

	static ExtentReports exReports = null;
	
	static final String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Test_Report.html" ;
	
	
	public static synchronized ExtentReports getExtentReport() {
		if(exReports == null) {
			ExtentSparkReporter exSpark = new ExtentSparkReporter(reportPath);
			
			exReports = new ExtentReports();
			
			exReports.attachReporter(exSpark);
			
			
		}
		
		return exReports;
	}
	

	
}
