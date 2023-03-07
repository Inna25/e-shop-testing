package pageobject_model.driver;

public class DriverManagerFactory {
    private static  DriverManager driverManager;
    private final static DriverManagerFactory factory = new DriverManagerFactory(); //final was removed

//        public static DriverManager getManager() {
//            DriverManager driverManager = null;
//            switch (System.getProperty("browser")) {
//                case "firefox":
//                    driverManager = new FirefoxDriverManager();
//                    break;
//                default:
//                    driverManager = new ChromeDriverManager();
//                    break;
//            }
//            return driverManager;
//        }

    public static DriverManager getManager() {

//        if(null == factory){
//            factory = new DriverManagerFactory();
//        }
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
