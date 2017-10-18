package traillink.reports;

import java.awt.Color;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentFactory extends CaptureScreenshot {
	public static ExtentReports extent;
	public static ExtentTest loggers;
	public static ExtentHtmlReporter htmlReporter;
	public static String screenShotPath;

	public ExtentHtmlReporter getHtmlReporter() {
		String reportPath = System.getProperty("user.dir")+"/ExtentReports/ReportAndScreenshot/TrailLinkReports.html";
		htmlReporter = new ExtentHtmlReporter(reportPath);
		htmlReporter.config().setDocumentTitle("TrailLink Automation Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setReportName("TrailLink Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		return htmlReporter;
	}

	public ExtentReports getExtent() {
		if (extent != null)
			return extent; // avoid creating new instance of html file
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	public ExtentTest startTest(String testcaseName) {
		loggers = extent.createTest(testcaseName);
		return loggers;
	}

	public static void endTest(WebDriver driver , String screenshotName, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			screenShotPath = getScreenshot(driver, screenshotName);		
			loggers.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test is FAILED due to below issues:", ExtentColor.RED));
			loggers.fail(result.getThrowable());
			//loggers.fail("Snapshot below: " + loggers.addScreenCaptureFromPath(screenShotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			screenShotPath = getScreenshot(driver, screenshotName);	
			loggers.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test is PASSED", ExtentColor.GREEN));
			//loggers.pass("Snapshot Here: " + loggers.addScreenCaptureFromPath(screenShotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			loggers.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test is SKIPPED", ExtentColor.GREY));
			loggers.skip(result.getThrowable());
		}
	}

	public void logSteps(ExtentTest loggers, String teststep) {
		loggers.log(Status.INFO, teststep);
	}

}
