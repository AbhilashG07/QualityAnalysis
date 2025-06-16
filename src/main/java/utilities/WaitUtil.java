package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

/**
 * WaitUtil is a utility class that provides custom selenium wait methods
 * to simplify waits usage and improve readability.
 */
public class WaitUtil {

    private static WebDriverWait wait;

    /**
     * Waits until the specified element is present in the DOM.
     *
     * @param element          the WebElement to wait for
     * @param driver           the WebDriver instance
     * @param timeOutInSeconds the timeout in seconds
     */
    public static void waitUntilElementVisible(WebElement element, WebDriver driver, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until the specified element is visible and returns it.
     *
     * @param element          the WebElement to wait for
     * @param driver           the WebDriver instance
     * @param timeOutInSeconds the timeout in seconds
     * @return the visible WebElement
     */
    public static WebElement waitUntilElementVisibleAndReturnElement(WebElement element, WebDriver driver, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until the specified element is not present in the DOM.
     *
     * @param element          the element to wait for invisibility
     * @param driver           the WebDriver instance
     * @param timeOutInSeconds the timeout in seconds
     * @return the found WebElement
     */
    public static void waitUntilElementNotVisible(WebElement element, WebDriver driver, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits until the specified element is clickable.
     *
     * @param element          the WebElement to wait for
     * @param driver           the WebDriver instance
     * @param timeOutInSeconds the timeout in seconds
     */
    public static void waitUntilElementClickable(WebElement element, WebDriver driver, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until all specified elements are visible.
     *
     * @param elements         the list of WebElements to wait for
     * @param driver           the WebDriver instance
     * @param timeOutInSeconds the timeout in seconds
     */
    public static void waitUntilVisibilityOfAllElements(List<WebElement> elements, WebDriver driver, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}