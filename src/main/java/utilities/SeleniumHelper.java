package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * SeleniumHelper is a utility class that provides custom selenium methods
 * to simplify test assertions and improve readability.
 */
public class SeleniumHelper {
    /**
     * Initialize the LOGGER.
     */
    private static final Logger LOGGER = LogManager.getLogger(SeleniumHelper.class.getName());

    private SeleniumHelper() {
    }

    /**
     * Selects an option in a dropdown by visible text.
     *
     * @param webElement   the dropdown WebElement
     * @param textToSelect the visible text of the option to select
     */
    public static void selectByVisibleText(WebElement webElement, String textToSelect) {
        Select select = new Select(webElement);
        select.selectByVisibleText(textToSelect);
    }

    /**
     * Selects an option in a dropdown by value.
     *
     * @param webElement   the dropdown WebElement
     * @param textToSelect the value of the option to select
     */
    public static void selectByValue(WebElement webElement, String textToSelect) {
        Select select = new Select(webElement);
        select.selectByValue(textToSelect);
    }

    /**
     * Moves to an element using the Tab key and clicks Enter.
     *
     * @param driver         the WebDriver instance
     * @param numberOfTimes the number of times to press the Tab key
     */
    public static void moveToElementUsingTabKeyAndClickEnter(WebDriver driver, int numberOfTimes) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < numberOfTimes; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
    }

    /**
     * Clicks on a desired link from a list of WebElements.
     *
     * @param desiredValue  the text of the link to click
     * @param desiredList   the list of WebElements containing links
     */
    public static void clickOnDesiredLink(String desiredValue, List<WebElement> desiredList) {
        for (WebElement matchedValue : desiredList) {
            String desiredColumnListDetails = matchedValue.getText();
            if (desiredColumnListDetails.equalsIgnoreCase(desiredValue)) {
                matchedValue.click();
                LOGGER.info("Clicked on: " + desiredValue);
                break;
            }
        }
    }

    /**
     * Hovers over an element and clicks another element.
     *
     * @param driver          the WebDriver instance
     * @param elementToHover  the WebElement to hover over
     * @param elementToClick  the WebElement to click after hovering
     */
    public static void hoverAndClick(WebDriver driver, WebElement elementToHover,
                                     WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).build().perform();
        if (elementToClick.isDisplayed()) {
            elementToClick.click();
        }
    }

    /**
     * Selects an option from a dropdown by matching the option text.
     *
     * @param driver the WebDriver instance
     * @param option the text of the option to select
     */
    public static void selectOptionFromDropdown(WebDriver driver, String option) {
        String path = "//li[contains(@class, 'vs__dropdown-option') and contains(text(), '" + option + "')]";
        WebElement dropdown = WaitUtil.waitUntilElementVisibleAndReturnElement(driver.findElement(By.xpath(path)), driver, 10);
        dropdown.click();
    }

    /**
     * Hovers over a desired link and clicks on another element.
     *
     * @param driver         the WebDriver instance
     * @param desiredValue   the text of the link to hover over
     * @param desiredList    the list of WebElements containing links
     * @param clickElement   the text of the element to click after hovering
     * @param elementsToClick the list of WebElements to search for the clickable element
     */
    public static void hoverOnDesiredLinkAndClick(WebDriver driver, String desiredValue, List<WebElement> desiredList,
                                                  String clickElement, List<WebElement> elementsToClick) {
        WebElement elementToHover = null;
        WebElement elementToClick = null;
        Actions action = new Actions(driver);

        // Find the element to hover
        for (WebElement matchedValue : desiredList) {
            if (matchedValue.getText().equalsIgnoreCase(desiredValue)) {
                elementToHover = matchedValue;
                break;
            }
        }
        if (elementToHover != null) {
            action.moveToElement(elementToHover).build().perform();
        } else {
            throw new IllegalArgumentException("Hover element not found.");
        }

        // Find the element to click
        for (WebElement matchedClickElement : elementsToClick) {
            if (matchedClickElement.getText().equalsIgnoreCase(clickElement)) {
                elementToClick = matchedClickElement;
                break;
            }
        }

        if (elementToClick != null) {
            elementToClick.click();
        } else {
            throw new IllegalArgumentException("Click element not found.");
        }
    }

    /**
     * Checks if all expected labels are displayed in a list of WebElements.
     *
     * @param expectedLabels the list of expected labels
     * @param webElements    the list of WebElements to check
     * @return true if all expected labels are found, false otherwise
     */
    public static boolean isAllLabelsDisplayed(List<String> expectedLabels, List<WebElement> webElements) {
        for (String label : expectedLabels) {
            boolean found = false;
            for (WebElement divisionLabel : webElements) {
                String divisionText = divisionLabel.getText();
                if (divisionText.equalsIgnoreCase(label)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false; // Return false if any label is not found
            }
        }
        return true;
    }

    /**
     * Checks if the current page title contains the expected title.
     *
     * @param driver         the WebDriver instance
     * @param expectedTitle  the expected title to check for
     * @return true if the actual title contains the expected title, false otherwise
     */
    public static boolean isPageTitleContainsRequiredTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        LOGGER.info("Actual title: " + actualTitle);
        return actualTitle.contains(expectedTitle);
    }
}

