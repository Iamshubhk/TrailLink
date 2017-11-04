package traillink.utils;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Loggers {

	// Initialize Log4j logs

	public  Logger Log = Logger.getLogger(Loggers.class.getName());

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite

	public  void startTestCase(String sTestCaseName) {

		PropertyConfigurator.configure("log4j.properties");

		Log.info("========================================================================================");

		Log.info("=================== Starting " + sTestCaseName + " Test ==========================");

		Log.info("========================================================================================");


	}

	// This is to print log for the ending of the test case

	public  void endTestCase(String sTestCaseName) {

		Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXX Finished " + sTestCaseName + " Test XXXXXXXXXXXXXXXXXXXXXXXXX");
		Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}

	// Need to create these methods, so that they can be called

	public  void info(String message) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    
		Log.info(timestamp+">>"+message);

	}

	public  void warn(String message) {

		Log.warn(message);

	}

	public  void error(String message) {

		Log.error(message);

	}

	public  void fatal(String message) {

		Log.fatal(message);

	}

	public  void debug(String message) {

		Log.debug(message);

	}

}
