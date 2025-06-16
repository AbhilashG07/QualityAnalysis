package application.carriers;

import application.base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.AssertHelper;

/**
 * Step definitions for the Carriers page.
 * This class contains methods that define the steps for interacting with the Carriers page in the application.
 * It uses Cucumber annotations to map feature file steps to Java methods.
 */
public class CarriersPageStepDefinitions {

    private static final Logger logger = LogManager.getLogger(CarriersPageStepDefinitions.class);
    private final CarriersPage carriersPage;
    private final WebDriver driver;

    /**
     * Constructor for CarriersPageStepDefinitions.
     * Initializes the WebDriver and the CarriersPage object.
     */
    public CarriersPageStepDefinitions() {
        this.driver = Base.getDriver();
        this.carriersPage = new CarriersPage(driver);
    }

    /**
     * Validates that the company logo is displayed on the Carriers page.
     */
    @Then("the user should see the logo")
    public void userShouldSeeLogo() {
        AssertHelper.assertTrue(carriersPage.isLogoDisplayed(), "Deutsche Bank logo is not displayed");
    }

    /**
     * Validates that the main navigation menu is displayed on the Carriers page.
     */
    @Then("the user should see the main navigation menu")
    public void userShouldSeeNavigationMenu() {
        AssertHelper.assertTrue(carriersPage.isNavigationMenuDisplayed(), "Main navigation menu is not displayed");
    }

    /**
     * Validates that the page title is "Careers".
     */
    @And("the page title should be Careers")
    public void thePageTitleShouldBeCareers() {
        AssertHelper.assertTrue(carriersPage.isPageTitleCareers(), "You are not on the Careers page");
    }

    /**
     * Simulates the user selecting a section and sub-section from the Careers page.
     *
     * @param section    the section to select
     * @param subSection the sub-section to select
     */
    @When("the user chooses {string} section and {string} sub-section from the careers page")
    public void theUserChoosesSectionFromTheCareersPage(String section, String subSection) {
        carriersPage.clickOnSectionAndSubSection(section, subSection);
    }
}
