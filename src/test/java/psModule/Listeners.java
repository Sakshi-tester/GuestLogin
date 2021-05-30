package psModule;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Base;
import resources.ExtentReporterNG;
import resources.Utility;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
	 test= extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		//Screenshot
		extentTest.get().fail(result.getThrowable());
		
		try {
			
			extentTest.get().addScreenCaptureFromPath(Utility.getScreenshotPath(result.getName().toString(), driver), result.getMethod().getMethodName());
			//Utility.getScreenshotPath(result.getName().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
