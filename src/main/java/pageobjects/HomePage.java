package pageobjects;

import frontend.abstractpage.AbstractPage;
import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(how = How.CSS, using = "input[id='loginButton']")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = "a[id='logoutButton']")
    private WebElement logoutButton;

    @FindBy(how = How.CSS, using = "a[href='/home']")
    private WebElement shopButton;

    @FindBy(how = How.CSS, using = "button[id='checkout'")
    private WebElement checkoutButton;

    @FindBy(how = How.CSS, using = "button[class='btn btn-primary']")
    private List<WebElement> buyButtons;

    @FindBy(how = How.CSS, using = "h1")
    private List<WebElement> productTitles;

    public void clickOnShop() {
        shopButton.click();
    }

    public void clickOnCheckOut() {
        checkoutButton.click();
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void clickOnLogout() {
        logoutButton.click();
    }

    public void clickOnProductBuyButton(String title) {
        for (int i = 0; i < productTitles.size(); i++) {
            String crtTitle = productTitles.get(i).getText();
            if (crtTitle.equals(title)) {
                buyButtons.get(i).click();
                break;
            }
        }
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
