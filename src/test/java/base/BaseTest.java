
package base;

import frontend.driversetup.Application;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.helpers.SharedStates;

import static frontend.driversetup.DriverFactory.getChromeDriver;
import static utils.constants.Constants.*;
import static utils.helpers.OSHandler.getOs;

public class BaseTest {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    private WebDriver driver;
    protected Application app;

    /**
     * Method will store OS information in a shared object.
     * Execution will be performed based on this value.
     * This check will be performed before every scenario.
     */
    @BeforeSuite()
    public void storeOs() {
        SharedStates.setDetectedOs(getOs().toString());
        LOG.info("Test cases will be executed on the detected {} operating system.", SharedStates.getDetectedOs());
    }

    /**
     * Method is used to start Chrome Driver before any test method.
     */
    @BeforeMethod
    public void startDriver() {
        this.driver = getChromeDriver();
        app = new Application(driver);
        LOG.info("Chrome Driver initialized.");
        driver.get(BASE_URL);
    }

    /**
     * Perform login as precondition
     */
    protected void performLogin() {

    }

    /**
     * Method is used to quit the Chrome Driver after each test method.
     */
    /*@AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }*/


    /**
     * Method is used to return the driver object.
     *
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        return this.driver;
    }
}
