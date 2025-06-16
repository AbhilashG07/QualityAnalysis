package application.carriers;

/**
 * CareersPageSelectors class contains selectors for elements on the Careers page.
 */
public class CareersPageSelectors {

    //By Css
    public static final String LOGO_CSS = ".logo";
    public static final String NAVIGATION_MENU_CSS = ".main-header";

    //By XPath
    public static final String PAGE_HEADER_XPATH = "//title[contains(text(),'Careers')]";
    public static final String JOB_SECTIONS_XPATH = "//nav[@class='navigation-main initialized']//ul[@class='nav-root']/child::li";
    public static final String JOB_SUB_SECTIONS_XPATH = "//div[@class='touch-overviewlink']/following-sibling::ul/li/a";
}
