
package frontend.driversetup;

import org.openqa.selenium.WebDriver;
import pageobjects.*;

public class Application {
    private WebDriver driver;

    public Application(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage createHomePage() {
        return new HomePage(driver);
    }

    public LoginPage createLoginPage() {
        return new LoginPage(driver);
    }
}
