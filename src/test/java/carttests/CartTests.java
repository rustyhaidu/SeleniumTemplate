
package carttests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import static org.testng.AssertJUnit.assertTrue;

public class CartTests extends BaseTest {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private ProductListPage productListPage;
    private ShoppingCartPage shoppingCartPage;
    private ShoppingCartCustomerPage shoppingCartCustomerPage;
    private ShoppingCartConfirmationPage shoppingCartConfirmationPage;

    @BeforeMethod
    public void initializePages() {
        indexPage = app.createIndexPage();
        loginPage = app.createLoginPage();
        productListPage = app.createProductList();
        shoppingCartPage = app.createShoppingCartPage();
        shoppingCartCustomerPage = app.createShoppingCartCustomerPage();
        shoppingCartConfirmationPage = app.createShoppingCartConfirmationPage();
    }

    @Test
    public void successfulOrder() throws InterruptedException {
        indexPage.clickOnLogin();
        Thread.sleep(1000);
        loginPage = app.createLoginPage();
        loginPage.enterTheUserName("employee1");
        loginPage.enterThePassword("123");

        loginPage.clickSubmitLogin();
        Thread.sleep(1000);
        indexPage = app.createIndexPage();

        indexPage.clickOnProductListLink();
        Thread.sleep(1000);
        productListPage = app.createProductList();

        productListPage.clickBuyNow(0);

        Thread.sleep(1000);
        shoppingCartPage = app.createShoppingCartPage();
        shoppingCartPage.clickEnterCustomerInfoLink();

        Thread.sleep(1000);
        shoppingCartCustomerPage.inputName("Tester");
        shoppingCartCustomerPage.inputEmail("tester@test.com");
        shoppingCartCustomerPage.inputPhone("075824521");
        shoppingCartCustomerPage.inputAddress("Caras Severin, strada Mihai Eminescu");

        shoppingCartCustomerPage.clickSubmitOrder();

        shoppingCartConfirmationPage.clickSubmitOrderConfirmation();
    }


}
