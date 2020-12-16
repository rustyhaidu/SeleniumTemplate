
package frontend.driversetup;

import org.openqa.selenium.WebDriver;
import pageobjects.*;

public class Application {
    private WebDriver driver;

    public Application(WebDriver driver) {
        this.driver = driver;
    }

    public IndexPage createIndexPage() {
        return new IndexPage(driver);
    }

    public LoginPage createLoginPage() {
        return new LoginPage(driver);
    }

    public ProductListPage createProductList() {
        return new ProductListPage(driver);
    }

    public ShoppingCartPage createShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartCustomerPage createShoppingCartCustomerPage() {
        return new ShoppingCartCustomerPage(driver);
    }

    public ShoppingCartConfirmationPage createShoppingCartConfirmationPage() {
        return new ShoppingCartConfirmationPage(driver);
    }

}
