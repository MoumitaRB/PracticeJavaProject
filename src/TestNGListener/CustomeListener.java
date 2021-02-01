package TestNGListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomeListener implements ITestListener {


	public void onTestStart(ITestResult result) {
		System.out.println("Test Started."+result.getMethod());
		
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed."+result.getMethod());
		
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed."+result.getMethod());
		
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skiped."+result.getMethod());
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
