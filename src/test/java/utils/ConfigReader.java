package utils;

import factory.LoggerFactory;

import java.io.InputStream;
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
            String configFileResourcePath = "/config/";
            InputStream configResourceInputStream = getClass().getResourceAsStream(configFileResourcePath + Constants.CONFIG_DATA_FILE_NAME);
            prop.load(configResourceInputStream);
            setAppUrl(prop.getProperty("appURL"));

            if (getBrowserType() == null || getBrowserType().isEmpty()) {
                setBrowserType(prop.getProperty("browser"));
            }
        } catch (Exception e) {
            LoggerFactory.getLogger().error("Unexcepted error occurred when loading configuration. {}", e.getMessage());
        }

        return prop;
    }
}
