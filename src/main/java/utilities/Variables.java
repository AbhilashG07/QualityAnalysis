package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Variables class is a singleton that loads framework properties from a file
 * and provides methods to access various configuration values such as browser type,
 * driver path, and application URL.
 */
public class Variables {

    private static final Logger logger = LogManager.getLogger(Variables.class);
    private static Properties frameworkProperties;
    private static Variables variablesInstance = null;

    /**
     * Private constructor to load properties from the file.
     */
    private Variables() {
        try {
            frameworkProperties = new Properties();

            InputStream inputStream = new FileInputStream(
                    "src/main/resources/framework.properties");

            frameworkProperties.load(inputStream);
            logger.info("Properties File Loaded...");


        } catch (Exception ex) {
            logger.error("Failed to initializeTheDriver/load .property file: " + ex.getMessage());
            throw new RuntimeException("Failed to initializeTheDriver/load .property file: " + ex.getMessage());
        }
    }

    /**
     * Static method to get the singleton instance of Variables.
     *
     * @return the single instance of Variables
     */
    public static Variables getInstance() {
        if (variablesInstance == null) {
            variablesInstance = new Variables();
        }
        return variablesInstance;
    }

    /**
     * Method to get the browser type.
     *
     * @return the browser type
     */
    public String getBrowserType() {

        String browserType = frameworkProperties.getProperty("browser");

        if (browserType == null) {
            logger.error("Property \"browserType\" could not be loaded, cannot continue.");
            throw new RuntimeException(
                    "Property \"browserType\" could not be loaded, cannot continue.");
        }
        return browserType;
    }

    /**
     * Method to get the driver path based on browser type.
     *
     * @return the driver path
     */
    public String getDriverPath() {
        String driverPath = null;

        if (Variables.getInstance().getBrowserType().equalsIgnoreCase("chrome")) {
            driverPath = frameworkProperties.getProperty("chromeDriverPath");
        } else if (Variables.getInstance().getBrowserType().equalsIgnoreCase("ie")) {
            driverPath = frameworkProperties.getProperty("ieDriverPath");
        }

        if (driverPath == null) {
            logger.error("Driver path could not be loaded.");
            throw new RuntimeException(
                    "Driver path could not be loaded, cannot continue.");
        }
        return driverPath;
    }

    /**
     * Method to get the application URL.
     *
     * @return the application URL
     */
    public String getApplicationUrl() {

        String applicationUrl = frameworkProperties.getProperty("applicationUrl");

        if (applicationUrl == null) {
            logger.error("Application URL could not be loaded, cannot continue.");
            throw new RuntimeException(
                    "Application URL could not be loaded, cannot continue.");
        }
        return applicationUrl;
    }
}
