
package frontend.driversetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

import static utils.helpers.OSHandler.setChromeDriverPropertyByOs;


public class DriverFactory {

    /**
     * Method is used to set up the Chrome Driver.
     * This will be run first when a test is running.
     *
     * @return WebDriver instance
     */
    public static WebDriver getChromeDriver() {
        //set up chrome driver using system properties based on machine's OS
        setChromeDriverPropertyByOs();

        //DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        //create new object of Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

}
