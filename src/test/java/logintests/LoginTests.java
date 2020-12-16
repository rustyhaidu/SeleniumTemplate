
package logintests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests extends BaseTest {

    private IndexPage indexPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void initializePages() {
        indexPage = app.createIndexPage();
        loginPage = app.createLoginPage();
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        indexPage.clickOnLogin();
        loginPage = app.createLoginPage();
        Thread.sleep(100);
        loginPage.enterTheUserName("employee1");
        loginPage.enterThePassword("123");

        loginPage.clickSubmitLogin();
        Thread.sleep(1000);
        indexPage = app.createIndexPage();
        indexPage.clickOnLogout();
    }

    @Test
    public void emptyUserNameLoginTest() throws InterruptedException {
        indexPage.clickOnLogin();
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        loginPage.enterTheUserName("employee1");
        loginPage.clickSubmitLogin();
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        indexPage = app.createIndexPage();
        assertTrue(loginPage.getErrorMessage().contains("Login Failed"));
    }

    @Test
    public void invalidUserNameLoginTest() throws InterruptedException {
        indexPage.clickOnLogin();
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        loginPage.enterTheUserName("employee1");
        loginPage.enterThePassword("employee1");
        loginPage.clickSubmitLogin();
        loginPage = app.createLoginPage();
        Thread.sleep(1000);
        indexPage = app.createIndexPage();
        assertTrue(loginPage.getErrorMessage().contains("Login Failed"));
    }
}
