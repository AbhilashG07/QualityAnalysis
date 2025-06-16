package application.base;

import io.cucumber.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Base class for initializing and managing the WebDriver instance.
 * This class uses ThreadLocal to ensure that each thread has its own instance of WebDriver.
 */
public class Base {

    public static WebDriver driver = null;
    private static final Logger logger = LogManager.getLogger(Base.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Method to initialize the driver.
     * This method should be called before any tests are run to ensure the WebDriver is set up.
     */
    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    /**
     * Method to get the current WebDriver instance.
     * This method retrieves the WebDriver instance associated with the current thread.
     *
     * @return the WebDriver instance for the current thread
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * Method to remove the WebDriver instance from the current thread.
     * This should be called after tests are completed to clean up resources.
     */
    public static void removeDriver() {
        driverThreadLocal.remove();
    }
}
