package application.searchroles;

import application.base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.AssertHelper;

/**
 * Step definitions for the Search Roles page.
 * This class contains Cucumber step definitions that interact with the Search Roles page
 * and validate its functionality during test execution.
 */
public class SearchRolesPageStepDefinitions {

    private static final Logger logger = LogManager.getLogger(SearchRolesPageStepDefinitions.class);
    private final SearchRolesPage searchRolesPage;
    private final WebDriver driver;

    /**
     * Constructor initializes WebDriver and SearchRolesPage instances.
     */
    public SearchRolesPageStepDefinitions() {
        this.driver = Base.getDriver();
        this.searchRolesPage = new SearchRolesPage(driver);
    }

    /**
     * Validates that the division filter is selected by default.
     */
    @Then("division should be selected by default")
    public void divisionShouldBeSelectedByDefault() {
        AssertHelper.assertTrue(searchRolesPage.isJobRolesDivisionSelected(), "Division is not selected by default");
    }

    /**
     * Validates that the user can see the expected divisions.
     * @param dataTable DataTable containing the expected divisions.
     */
    @Then("the user should see the following divisions")
    public void userShouldSeeFollowingDivisions(DataTable dataTable) {
        AssertHelper.assertTrue(searchRolesPage.isAllDivisionFiltersDisplayed(dataTable.asList()),
                "Not all divisions are displayed.");
    }

    /**
     * Simulates the user choosing the Profession filter.
     */
    @And("the user chooses Profession filter")
    public void theUserChoosesProfessionFilter() {
        searchRolesPage.clickOnJobRolesProfession();
    }

    /**
     * Validates that the user can see the expected professions.
     * @param dataTable DataTable containing the expected professions.
     */
    @Then("the user should see the following professions")
    public void theUserShouldSeeTheFollowingProfessions(DataTable dataTable) {
        AssertHelper.assertTrue(searchRolesPage.isAllProfessionFiltersDisplayed(dataTable.asList()),
                "Not all professions are displayed.");
    }

    /**
     * Simulates the user searching for job roles using specific filter details.
     * @param dataTable DataTable containing filter details.
     */
    @When("the user searches with below details")
    public void userSearchesWithDetails(io.cucumber.datatable.DataTable dataTable) {
        searchRolesPage.selectAllRequiredFilters(dataTable.asMaps());
    }

    /**
     * Validates that job listings are filtered according to the selected filters.
     * @param dataTable DataTable containing the expected filter values.
     */
    @Then("the job listings should be filtered according to below filter value")
    public void theJobListingsShouldBeFilteredAccordingToBelowFilterValue(DataTable dataTable) {
        AssertHelper.assertTrue(searchRolesPage.isDesiredFiltersSelected(dataTable.asList()),
                "Job listings are not filtered according to the selected filters.");
    }

    /**
     * Simulates the user performing either a Search or Reset action on job filters.
     * @param action The action to perform (Search or Reset).
     */
    @And("^the user will (Search|Reset) the job filters applied$")
    public void searchOrResetTheJobs(String action) {
        searchRolesPage.clickOnSearchOrResetJobs(action);
    }

    /**
     * Validates that all filters are cleared after a reset action.
     */
    @Then("all filters should be cleared")
    public void allFiltersShouldBeCleared() {
        AssertHelper.assertFalse(searchRolesPage.isFiltersApplied(),
                "All filters are not cleared after reset.");
    }


}
