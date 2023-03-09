package pageobject_model.driver;

public class DriverManagerFactory {
    private static  DriverManager driverManager;
    private final static DriverManagerFactory factory = new DriverManagerFactory();

    public static DriverManager getManager() {
        return driverManager;
    }
    private DriverManagerFactory() {

        switch (System.getProperty("browser")) {
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
    }
}
