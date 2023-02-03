package pageobject_model.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("brand"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
