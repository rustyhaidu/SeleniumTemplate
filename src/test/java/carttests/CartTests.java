
package carttests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import static org.testng.AssertJUnit.assertTrue;

public class CartTests extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeMethod
    public void initializePages() {
        homePage = app.createHomePage();
        loginPage = app.createLoginPage();
    }

    @Test
    public void successfulOrder() throws InterruptedException {
        loginPage = app.createLoginPage();
        loginPage.enterTheUserName("user");
        loginPage.enterThePassword("password");

        loginPage.clickOnLogin();
        Thread.sleep(100);
        homePage = app.createHomePage();

        homePage.clickOnProductBuyButton("Soap");
        Thread.sleep(100);
        homePage.clickOnShop();
        Thread.sleep(100);
        homePage.clickOnProductBuyButton("Tooth Brush");
        Thread.sleep(100);
        homePage.clickOnCheckOut();
        Thread.sleep(100);
        homePage.clickOnShop();
    }


}
