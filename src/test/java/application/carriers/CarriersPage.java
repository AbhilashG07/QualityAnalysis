package application.carriers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;
import java.util.List;

/**
 * Represents the Carriers page in the application.
 * Provides methods to interact with elements on the page.
 */
public class CarriersPage {

    private WebDriver driver;

    @FindBy(css = CareersPageSelectors.LOGO_CSS)
    private WebElement logo;

    @FindBy(css = CareersPageSelectors.NAVIGATION_MENU_CSS)
    private WebElement navigationMenu;

    @FindBy(xpath = CareersPageSelectors.PAGE_HEADER_XPATH)
    private WebElement pageHeader;

    @FindBy(xpath = CareersPageSelectors.JOB_SECTIONS_XPATH)
    private List<WebElement> jobSections;

    @FindBy(xpath = CareersPageSelectors.JOB_SUB_SECTIONS_XPATH)
    private List<WebElement> jobSubSections;

    /**
     * Constructor to initialize the CarriersPage with the WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the page
     */
    public CarriersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Checks if the company logo is displayed.
     *
     * @return true if the company logo is displayed, false otherwise
     */
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    /**
     * Checks if the navigation menu is displayed.
     *
     * @return true if the navigation menu is displayed, false otherwise
     */
    public boolean isNavigationMenuDisplayed() {
        return navigationMenu.isDisplayed();
    }

    /**
     * Checks if the page title is Careers or not.
     *
     * @return true if the page title is Careers, false otherwise
     */
    public boolean isPageTitleCareers() {
        return driver.getTitle().contains("Careers");
    }

    /**
     * Clicks on the section and sub-section in the Careers page.
     * @param section the section to click on
     * @param subSection the sub-section to click on
     */
    public void clickOnSectionAndSubSection(String section, String subSection) {
        SeleniumHelper.hoverOnDesiredLinkAndClick(driver, section, jobSections, subSection, jobSubSections);
    }
}
