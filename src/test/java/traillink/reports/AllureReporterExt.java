package traillink.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.qameta.allure.Attachment;

public class AllureReporterExt extends TestListenerAdapter {
	
	//private static final WebDriver d = null;

	/*@Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod() && !testResult.isSuccess()) {
                attachScreenshot();
        }
    }
	 @Override
	    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	    } */

	   /* @Attachment(value = "{0}", type = "image/png")
	    public static void attachScreenshot(WebDriver d) {
	    	 Allure.addAttachment("Screenshot",captureScreenshot(d));
	    	 Allure.addAttachment("Screenshot",captureScreenshot(d));
	    	 Allure.addByteAttachmentAsync("acs", ".png", captureScreenshot(d));
	    }
	    
	    
	    private void attachScreenshot() {
	        try {
	            Allure.addAttachment("Screenshot",
	                    new ByteArrayInputStream(FileUtils.readFileToByteArray(Screenshots.takeScreenShotAsFile())));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }*/
	    
	    @Attachment
	    public static byte[] captureScreenshot(WebDriver d) {
	        return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
	    }
	    
	    @Override
	    public void onTestFailure(ITestResult tr) {
	        Object webDriverAttribute = tr.getTestContext().getAttribute("WebDriver");
	        if (webDriverAttribute instanceof WebDriver) {
	            System.out.println("Screesnshot captured for test case:" + tr.getMethod().getMethodName());
	            captureScreenshot((WebDriver) webDriverAttribute);
	        }
	    }

}
