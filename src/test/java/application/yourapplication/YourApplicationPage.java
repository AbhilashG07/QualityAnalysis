package application.yourapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;

/**
 * YourApplicationPage represents the page object model for the "Your Application" page.
 * It provides methods to interact with and validate the page during test execution.
 */
public class YourApplicationPage {

    private WebDriver driver;

    /**
     * Constructor initializes the WebDriver instance and sets up the page elements.
     * @param driver WebDriver instance used to interact with the web page.
     */
    public YourApplicationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Validates whether the current page is the "Your Application" page.
     * @return true if the page title contains "Your Application", false otherwise.
     */
    public boolean isYourApplicationPage() {
        return SeleniumHelper.isPageTitleContainsRequiredTitle(driver, "Your Application");
    }
}
