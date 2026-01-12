package utils;


import java.util.Map;

import static utils.Constants.TEST_DATA_FILE_NAME;

public class ValidCredentialDataReader {

    private static String validUserName;
    private static String validPassword;

    public static void getValidCredentialsFromExcelData() {

        String dataFileResourcePath = "/testData/"+ TEST_DATA_FILE_NAME;

        DataReader reader = new DataReader(dataFileResourcePath);

        String sheetName = "login_valid";
        String scenarioName = "valid username and valid password";

        LoggerFactory.getLogger().info("Reading data from file: {}, sheet: {}, scenario: {}", dataFileResourcePath, sheetName, scenarioName);

        Map<String, String> testData = reader.getDataByScenarioName(sheetName, scenarioName);
        setValidUserName(testData.get("Username"));
        setValidPassword(testData.get("Password"));
    }

    private static void setValidUserName(String userName) {
        validUserName = userName;
    }

    public static String getValidUserName() {
        return validUserName;
    }

    private static void setValidPassword(String password) {
        validPassword = password;
    }

    public static String getValidPassword() {
        return validPassword;
    }
}
