package application.searchroles;

/**
 * SearchRolesPageSelectors is a utility class that contains selectors
 * for elements on the Search Roles page. These selectors are used to locate elements
 * during test execution.
 */
public class SearchRolesPageSelectors {

    //By XPath
    public static final String JOB_ROLES_DIVISION_ID = "//button[@id='divisionProf']/div";
    public static final String FILTER_LABELS_XPATH = "//div[@class='dropdown-container']/div[1]";
    public static final String DIVISIONS_CATEGORY_XPATH = "//div[contains(text(),'Division Category')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String PROFESSION_CATEGORY_XPATH = "//div[contains(text(),'Profession Category')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String PROFESSION_XPATH = "//div[contains(text(),'Profession')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String COUNTRY_XPATH = "//div[contains(text(),'Country')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String STATE_XPATH = "//div[contains(text(),'State')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String CITY_XPATH = "//div[contains(text(),'City')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String CORPORATE_TITLE_XPATH = "//div[contains(text(),'Corporate title')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String WORK_XPATH = "//div[contains(text(),'I want to work')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String AVAILABILITY_XPATH = "//div[contains(text(),'What is your availability')]/following-sibling::div//div[@class='vs__dropdown-toggle']";
    public static final String SELECTED_SEARCH_BY_FILTERS = "//span[@class='vs__selected']";
    public static final String SEARCH_JOBS_XPATH = "//a[text()=' Reset ']/preceding-sibling::a";
    public static final String RESET_FILTERS_XPATH = "//a[text()=' Reset ']";
    public static final String APPLIED_FILTERS_XPATH = "//span[@class='vs__selected']";

    //By Id
    public static final String JOB_ROLES_PROFESSION_ID = "profession";
}
