package traillink.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import traillink.utils.ExcelUtils;

public class CaptureScreenshot extends ExcelUtils {
	public static ExtentReports extent;
	public static ExtentTest loggers;
	public static ExtentHtmlReporter htmlReporter;

	public static String getScreenshot(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"/ExtentReports/ReportAndScreenshot/"+screenShotName+".jpg";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);                           
        return dest;
    }

}
