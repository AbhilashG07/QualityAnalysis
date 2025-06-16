package application.home;

import application.base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.AssertHelper;

/**
 * HomePageStepDefinitions contains step definitions for Cucumber tests
 * related to the Home Page functionality. It interacts with the HomePage class
 * to perform actions and assertions on the Home Page.
 */
public class HomePageStepDefinitions {

    private static final Logger logger = LogManager.getLogger(HomePageStepDefinitions.class);
    private HomePage homePage;
    private WebDriver driver;

    /**
     * Constructor initializes the WebDriver and HomePage instances.
     */
    public HomePageStepDefinitions() {
        this.driver = Base.getDriver();
        this.homePage = new HomePage(driver);
    }

    /**
     * Verifies that the Company logo is displayed on the Home Page.
     */
    @Then("the user should see the Company logo on home page")
    public void userShouldSeeLogoOnHomePage() {
        AssertHelper.assertTrue(homePage.isLogoDisplayed(),
                "Deutsche Bank logo is not displayed on home page");
        logger.info("Company logo is displayed on the home page.");
    }

    /**
     * Verifies that the main navigation menu is displayed on the Home Page.
     */
    @And("the user should see the main navigation menu on home page")
    public void userShouldSeeNavigationMenuOnHomePage() {
        AssertHelper.assertTrue(homePage.isMainNavigationDisplayed(),
                "Navigation menu is not displayed on home page");
    }

    /**
     * Accepts cookies if the cookie consent banner is presented.
     */
    @And("the user accepts cookies if presented")
    public void userAcceptsCookiesIfPresented() {
        homePage.acceptCookiesIfPresent();
    }

    /**
     * Navigates the user to the Company careers page.
     */
    @Given("the user navigates to Company careers page")
    public void userNavigatesToCareersPage() {
        homePage.clickOnCareersLink();
    }

    /**
     * Verifies that the Careers link is present in the main navigation menu.
     */
    @And("the careers link should be present in the main navigation menu")
    public void theCareersLinkShouldBePresentInTheMainNavigationMenu() {
        AssertHelper.assertTrue(homePage.isCareersLinkDisplayed(), "Careers link is not present in the main navigation menu");
    }

    /**
     * Verifies that the user is currently on the Home Page.
     */
    @Given("the user is on home page")
    public void theUserIsOnHomePage() {
        AssertHelper.assertTrue(homePage.isHomePage(), "Not in the home page");
    }

}
