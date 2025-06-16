package application.searchroles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;
import utilities.WaitUtil;
import java.util.List;
import java.util.Map;

/**
 * SearchRolesPage represents the page object model for the Search Roles page.
 * It provides methods to interact with and verify elements on the page.
 */
public class SearchRolesPage {

    private WebDriver driver;

    @FindBy(xpath = SearchRolesPageSelectors.JOB_ROLES_DIVISION_ID)
    private WebElement jobRolesDivision;

    @FindBy(xpath = SearchRolesPageSelectors.FILTER_LABELS_XPATH)
    private List<WebElement> divisionFilterLabels;

    @FindBy(id = SearchRolesPageSelectors.JOB_ROLES_PROFESSION_ID)
    private WebElement jobRolesProfession;

    @FindBy(xpath = SearchRolesPageSelectors.FILTER_LABELS_XPATH)
    private List<WebElement> professionFilterLabels;

    @FindBy(xpath = SearchRolesPageSelectors.DIVISIONS_CATEGORY_XPATH)
    private WebElement divisionsCategoryFilter;

    @FindBy(xpath = SearchRolesPageSelectors.PROFESSION_CATEGORY_XPATH)
    private WebElement professionCategoryFilter;

    @FindBy(xpath = SearchRolesPageSelectors.PROFESSION_XPATH)
    private WebElement professionFilter;

    @FindBy(xpath = SearchRolesPageSelectors.COUNTRY_XPATH)
    private WebElement countryFilter;

    @FindBy(xpath = SearchRolesPageSelectors.STATE_XPATH)
    private WebElement stateFilter;

    @FindBy(xpath = SearchRolesPageSelectors.CITY_XPATH)
    private WebElement cityFilter;

    @FindBy(xpath = SearchRolesPageSelectors.CORPORATE_TITLE_XPATH)
    private WebElement corporateTitleFilter;

    @FindBy(xpath = SearchRolesPageSelectors.WORK_XPATH)
    private WebElement workFilter;

    @FindBy(xpath = SearchRolesPageSelectors.AVAILABILITY_XPATH)
    private WebElement availabilityFilter;

    @FindBy(xpath = SearchRolesPageSelectors.SELECTED_SEARCH_BY_FILTERS)
    private List<WebElement> selectedSearchByFilters;

    @FindBy(xpath = SearchRolesPageSelectors.SEARCH_JOBS_XPATH)
    private WebElement searchJobsButton;

    @FindBy(xpath = SearchRolesPageSelectors.RESET_FILTERS_XPATH)
    private WebElement resetFiltersButton;

    @FindBy(xpath = SearchRolesPageSelectors.APPLIED_FILTERS_XPATH)
    private List<WebElement> appliedFilters;

    /**
     * Constructor initializes the WebDriver and PageFactory elements.
     *
     * @param driver WebDriver instance used to interact with the page
     */
    public SearchRolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Checks if the job roles division section is selected and visible.
     *
     * @return true if the job roles division is displayed, false otherwise
     */
    public boolean isJobRolesDivisionSelected() {
        WaitUtil.waitUntilElementVisible(jobRolesDivision, driver, 10);
        return jobRolesDivision.isDisplayed();
    }

    /**
     * Verifies if all expected division filter labels are displayed.
     *
     * @param expectedLabels List of expected filter labels
     * @return true if all expected labels are displayed, false otherwise
     */
    public boolean isAllDivisionFiltersDisplayed(List<String> expectedLabels) {
        return SeleniumHelper.isAllLabelsDisplayed(expectedLabels, divisionFilterLabels);
    }

    /**
     * Clicks on the job roles profession filter.
     */
    public void clickOnJobRolesProfession() {
        WaitUtil.waitUntilElementClickable(jobRolesProfession, driver, 10);
        jobRolesProfession.click();
    }

    /**
     * Verifies if all expected profession filter labels are displayed.
     *
     * @param expectedLabels List of expected filter labels
     * @return true if all expected labels are displayed, false otherwise
     */
    public boolean isAllProfessionFiltersDisplayed(List<String> expectedLabels) {
        return SeleniumHelper.isAllLabelsDisplayed(expectedLabels, professionFilterLabels);
    }

    /**
     * Selects all required filters based on the provided filter data.
     *
     * @param filterData List of maps containing filter type and value
     */
    public void selectAllRequiredFilters(List<Map<String, String>> filterData) {
        for (java.util.Map<String, String> filter : filterData) {
            String filterType = filter.get("Filter Type");
            String filterValue = filter.get("Filter Value");

            // Select the filter type
            selectFilter(filterType);

            // Select the filter value
            selectFilterValue(filterValue);
        }
    }

    /**
     * Selects a filter based on the filter type.
     *
     * @param filterType Type of the filter to select
     */
    public void selectFilter(String filterType) {
        switch (filterType) {
            case "Division Category":
                divisionsCategoryFilter.click();
                break;
            case "Country":
                countryFilter.click();
                break;
            case "State":
                stateFilter.click();
                break;
            case "City":
                cityFilter.click();
                break;
            case "Corporate title":
                corporateTitleFilter.click();
                break;
            case "I want to work":
                workFilter.click();
                break;
            case "Profession Category":
                professionCategoryFilter.click();
                break;
            case "Profession":
                professionFilter.click();
                break;
            default:
                throw new IllegalArgumentException("Filter type not recognized: " + filterType);
        }
    }

    /**
     * Selects a filter value from a dropdown.
     *
     * @param filterValue Value of the filter to select
     */
    public void selectFilterValue(String filterValue) {
        // Generic approach to find dropdown option by text
        SeleniumHelper.selectOptionFromDropdown(driver, filterValue);
    }

    /**
     * Clicks on either the search jobs button or the reset filters button based on the action.
     *
     * @param action Action to perform ("search" or "reset")
     */
    public void clickOnSearchOrResetJobs(String action) {
        switch (action.toLowerCase()) {
            case "search":
                searchJobsButton.click();
                break;
            case "reset":
                resetFiltersButton.click();
                break;
            default:
                throw new IllegalArgumentException("Action not recognized: " + action);
        }
    }

    /**
     * Verifies if the desired filters are selected.
     *
     * @param expectedFilters List of expected filters
     * @return true if all expected filters are selected, false otherwise
     */
    public boolean isDesiredFiltersSelected(List<String> expectedFilters) {
        return SeleniumHelper.isAllLabelsDisplayed(expectedFilters, selectedSearchByFilters);
    }

    /**
     * Checks if any filters are applied.
     *
     * @return true if filters are applied, false otherwise
     */
    public boolean isFiltersApplied() {
        return !appliedFilters.isEmpty();
    }

}
