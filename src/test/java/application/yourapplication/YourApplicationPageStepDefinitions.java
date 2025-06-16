package application.yourapplication;

import application.base.Base;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.AssertHelper;

/**
 * Step definitions for the Your Application page.
 * This class contains Cucumber step definitions to verify the functionality
 * and elements of the Your Application page during test execution.
 */
public class YourApplicationPageStepDefinitions {

    private static final Logger logger = LogManager.getLogger(YourApplicationPageStepDefinitions.class);
    private final YourApplicationPage yourApplicationPage;
    private final WebDriver driver;

    /**
     * Constructor to initialize the step definitions.
     * It sets up the WebDriver and YourApplicationPage instances.
     */
    public YourApplicationPageStepDefinitions() {
        this.driver = Base.getDriver();
        this.yourApplicationPage = new YourApplicationPage(driver);
    }

    /**
     * Verifies that the Your Applications page is displayed.
     * This step checks if the page is visible and asserts the result.
     */
    @Then("the user should see the Your Applications page")
    public void theUserShouldSeeTheYourApplicationsPage() {
        AssertHelper.assertTrue(yourApplicationPage.isYourApplicationPage(),
                "Your Applications page is not displayed.");
    }
}
