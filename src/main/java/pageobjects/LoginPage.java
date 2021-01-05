package pageobjects;

import frontend.abstractpage.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.helpers.Helper;

public class LoginPage extends AbstractPage {

    @FindBy(how = How.CSS, using = "input[name='username']")
    private WebElement userNameInput;

    @FindBy(how = How.CSS, using = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "input[id='loginButton']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterTheUserName(String username) {
        userNameInput.sendKeys(username);
    }

    public void enterThePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public boolean isPopUpDisplayed() throws Exception {
        return Helper.focusOnWindow(driver);
    }

}
