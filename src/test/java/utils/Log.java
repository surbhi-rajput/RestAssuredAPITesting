package utils;

import org.apache.log4j.Logger;

public class Log {
	
	private static Logger Log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String sTestCaseName) {

		Log.info("------------- " + sTestCaseName + " test execution started"
				+ " -------------");
	}

	public static void endTestCase(String sTestCaseName) {

		Log.info("------------- " + sTestCaseName + " test execution ended"
				+ " -------------");

	}
	
	public static void date()
	{
		Log.info(java.time.LocalDate.now());

	}

	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(Exception message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

}

