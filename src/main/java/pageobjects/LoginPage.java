package pageobjects;

import frontend.abstractpage.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends AbstractPage {

    @FindBy(how = How.CSS, using = "input[name='userName']")
    private WebElement userNameInput;

    @FindBy(how = How.CSS, using = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "input[id='submit_login']")
    private WebElement submitLogin;

    @FindBy(how = How.CSS, using = "div[id='error_message']")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterTheUserName(String username) {
        userNameInput.sendKeys(username);
    }

    public void enterThePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmitLogin() {
        submitLogin.click();
    }

    public String getErrorMessage() {
        return error.getText();
    }

}
