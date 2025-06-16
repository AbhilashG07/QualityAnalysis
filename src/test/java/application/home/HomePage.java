package application.home;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;
import utilities.WaitUtil;

/**
 * Represents the Home Page of the application.
 * Provides methods to interact with elements on the Home Page.
 */
public class HomePage {

    private WebDriver driver;

    @FindBy(css = HomePageSelectors.APPLICATION_LOGO_CSS)
    private WebElement dbLogo;

    @FindBy(css = HomePageSelectors.MAIN_NAVIGATION_CSS)
    private WebElement mainNavigation;

    @FindBy(linkText = HomePageSelectors.CAREERS_LINK_TEXT)
    private WebElement careersLink;

    /**
     * Constructor to initialize the HomePage with the WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the page
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Checks if the application logo is displayed.
     *
     * @return true if the logo is displayed, false otherwise
     */
    public boolean isLogoDisplayed() {
        return dbLogo.isDisplayed();
    }

    /**
     * Checks if the main navigation menu is displayed.
     *
     * @return true if the main navigation menu is displayed, false otherwise
     */
    public boolean isMainNavigationDisplayed() {
        return mainNavigation.isDisplayed();
    }

    /**
     * Checks if the Careers link is displayed.
     *
     * @return true if the Careers link is displayed, false otherwise
     */
    public boolean isCareersLinkDisplayed() {
        return careersLink.isDisplayed();
    }

    /**
     * Accepts cookies if the cookie banner is present.
     * Uses the Tab key to navigate and Enter key to click.
     * If the cookie banner is not present, no action is taken.
     */
    //TODO: Implement a more robust cookie acceptance mechanism, possibly using a specific selector for the cookie banner.
    public void acceptCookiesIfPresent() {
        try {
            SeleniumHelper.moveToElementUsingTabKeyAndClickEnter(driver, 17);
        } catch (Exception e) {
            // Cookie banner may not be present, which is fine
        }
    }

    /**
     * Clicks on the Careers link.
     * First attempts a direct click, and if it fails, uses JavaScript to click.
     */
    public void clickOnCareersLink() {
        // First try direct click
        try {
            WaitUtil.waitUntilElementClickable(careersLink, driver, 10);
            careersLink.click();
        } catch (Exception e) {
            // If direct click fails, try with JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", careersLink);
        }
    }

    /**
     * Checks if the current page is the Home Page.
     *
     * @return true if the URL contains ".com/index", false otherwise
     */
    public boolean isHomePage() {
        return driver.getCurrentUrl().contains(".com/index");
    }
}
