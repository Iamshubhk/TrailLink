package traillink.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import traillink.testbase.TestBase;

public class CaptureScreenshot extends TestBase implements ITestListener  {
	
	@Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	takeScreenShot(result.getTestClass().getName());
    }
    
    public void takeScreenShot(String testcaseName) {
    	String dest = System.getProperty("user.dir") +"/Screenshots/"+testcaseName+".png";
    	//get the driver
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(dest));
				System.out.println("***Placed screen shot in "+dest+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
}

