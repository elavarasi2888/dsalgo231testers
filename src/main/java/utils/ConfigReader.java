package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static String browserType = null;
	private static String appURL;
	Properties prop;

	public static String getAppUrl() {
		return appURL;
	}

	public static String getBrowserType() {
		return browserType;
	}

	public static void setBrowserType(String browser) {
		browserType = browser;
	}

	// public void loadProperties() throws IOException {
	public Properties loadProperties() throws IOException {

		prop = new Properties();

		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		prop.load(file);

		return prop;
		// appURL = prop.getProperty("appURL");
	}
}
