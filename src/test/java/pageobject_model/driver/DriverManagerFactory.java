package pageobject_model.driver;

public class DriverManagerFactory {
    public static DriverManager getManager() {

        DriverManager driverManager = null;

        switch (System.getProperty("browser")) {
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
