
package logintests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void initializePages() {
        homePage = app.createHomePage();
        loginPage = app.createLoginPage();
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        loginPage = app.createLoginPage();
        Thread.sleep(100);
        loginPage.enterTheUserName("user");
        loginPage.enterThePassword("password");
        homePage.clickOnLogin();

        Thread.sleep(1000);
        homePage = app.createHomePage();
        homePage.clickOnLogout();
    }

    @Test
    public void emptyUserNameLoginTest() throws Exception {
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        loginPage.enterTheUserName("user");
        homePage.clickOnLogin();
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        homePage = app.createHomePage();
    }

    @Test
    public void invalidUserNameLoginTest() throws Exception {
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        loginPage.enterTheUserName("user");
        loginPage.enterThePassword("user");
        homePage.clickOnLogin();
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        homePage = app.createHomePage();
    }
}
