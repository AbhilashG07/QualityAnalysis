package testrunner;

import application.base.Base;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Variables;

import java.io.File;
import java.time.Duration;

/**
 * TestRunner is the entry point for executing Cucumber tests using TestNG.
 * It sets up the WebDriver, configures browser options, and manages the test lifecycle.
 */
@CucumberOptions(
        features = "src/test/resources/featurefiles/",
        glue = "",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/CucumberTestReport.xml",
                "rerun:target/cucumber-reports/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber/report.html"
        },
        monochrome = true,
        dryRun = false,
        tags = "${cucumber.filter.tags:@default}"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    public WebDriver driver;

    /**
     * Initializes the WebDriver before each test method.
     * Sets up browser-specific configurations and launches the application URL.
     *
     * @throws Exception if an error occurs during WebDriver initialization.
     */
    @BeforeMethod
    public void initializeTheDriver() throws Exception {

        ChromeOptions options = new ChromeOptions();
        //Add arguments as per the need

        switch (Variables.getInstance().getBrowserType()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Variables.getInstance().getDriverPath());
                driver = new ChromeDriver(options);
                break;

            case "ie":
                System.setProperty("webdriver.ie.driver", Variables.getInstance().getDriverPath());
                driver = new InternetExplorerDriver();
                break;

            default:
                System.out.println("Browser is invalid, Launching Chrome as browser of choice..");
                System.setProperty("webdriver.chrome.driver", Variables.getInstance().getDriverPath());
                driver = new ChromeDriver(options);
        }
        // Maximize the window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // To launch Application
        driver.get(Variables.getInstance().getApplicationUrl());
        //logger.info("Application URL: " + Variables.getInstance().getApplicationUrl());

        Base.setDriver(driver);
    }


    /**
     * Cleans up the WebDriver after each test method.
     * Quits the browser and removes the WebDriver instance.
     * Takes the screenshot if the test fails and saves it to the specified directory.
     */

    @AfterMethod
    public void TeardownTest(ITestResult result) {
            try {
                if (result.getStatus() == ITestResult.FAILURE) {

                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String screenshotPath = "target/screenshots/" + result.getMethod().getMethodName() + ".png";
                    FileUtils.copyFile(screenshot, new File(screenshotPath));
                    System.out.println("Screenshot saved at: " + screenshotPath);
                }

            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            } finally {
                driver.quit();
                Base.removeDriver();
            }
    }
}
