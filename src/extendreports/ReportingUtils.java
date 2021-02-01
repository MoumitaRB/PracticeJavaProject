package extendreports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingUtils implements ITestListener {
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String suiteName;
	
	public void onTestStart(ITestResult result) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		//extent.createTest(result.getTestClass().getName()).createNode(result.getName()).pass("details");
				test=extent.createTest(result.getName()); // create new entry in th report
				test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
        test=extent.createTest(result.getName()); // create new entry in th report
		
		test.log(Status.FAIL, "Test Case FAILED IS " + result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // SEND LOGS TO REPORTS
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Case SKIIPED  IS " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}
	
	public void onStart(ITestContext context) {
    htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");//specify location of the report
		
		htmlReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		htmlReporter.config().setReportName("Functional Testing"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","moumita");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,IE");
		
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	

	

}
