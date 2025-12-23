package utils;

import factory.LoggerFactory;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    private static String browserType = null;
    private static String applicationURL;
    Properties prop = null;

    public static String getAppUrl() {
        return applicationURL;
    }

    private void setAppUrl(String appURL) {
        applicationURL = appURL;
    }

    public static String getBrowserType() {
        return browserType;
    }

    public static void setBrowserType(String browser) {
        browserType = browser;
    }

    public Properties loadProperties() {
        try {
            prop = new Properties();
            FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
            prop.load(file);
            setAppUrl(prop.getProperty("appURL"));
        } catch (Exception e) {
            LoggerFactory.getLogger().error("Unexcepted error occurred when loading configuration. {}", e.getMessage());
        }

        return prop;
    }
}
