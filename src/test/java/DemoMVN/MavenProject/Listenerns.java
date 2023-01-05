package DemoMVN.MavenProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listenerns extends DataProviders  implements ITestListener{
	ExtentReports extent = ExtentReport.getReports();
	ExtentTest test;
	WebDriver driver;
	Logger log=LogManager.getLogger(Listenerns.class);

	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		log.info("*******************onTestStart Listener method called************");
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("*******************onTestSuccess Listener method called************");
		extenttest.get().log(Status.PASS, "Test case executed successful");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("*******************onTestFailure Listener method called************");
		extenttest.get().fail(result.getThrowable());
		//get driver
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		// Attach screenshots
		String path = null;
		try {
			path = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

		extenttest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("*******************onTestFailedButWithinSuccessPercentage Listener method called************");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("*******************onTestSkipped Listener method called************");
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("*******************onStart Listener method called************");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("*******************onFinish Listener method called************");
		extent.flush();
	}
}
