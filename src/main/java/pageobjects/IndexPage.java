package pageobjects;

import frontend.abstractpage.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IndexPage extends AbstractPage {

    @FindBy(how = How.CSS, using = "a[id='loginButton']")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = "a[id='logoutButton']")
    private WebElement logoutButton;

    @FindBy(how = How.CSS, using = "a[id='productListLink']")
    private WebElement productListLink;

    @FindBy(how = How.CSS, using = "a[id='myCartLink']")
    private WebElement myCartLink;

    public void clickOnLogin() {
        loginButton.click();
    }

    public void clickOnLogout() {
        logoutButton.click();
    }

    public void clickOnProductListLink() {
        productListLink.click();
    }

    public void clickMyCartLink() {
        productListLink.click();
    }

    public boolean booleanIsLoggedIn() {
        return isElementPresent(logoutButton);
    }

    public IndexPage(WebDriver driver) {
        super(driver);
    }

}
