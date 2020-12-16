package pageobjects;

import frontend.abstractpage.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartCustomerPage extends AbstractPage {
    @FindBy(how = How.CSS, using = "input[id='name']")
    private WebElement nameInput;

    @FindBy(how = How.CSS, using = "input[id='email']")
    private WebElement emailInput;

    @FindBy(how = How.CSS, using = "input[id='phone']")
    private WebElement phoneInput;

    @FindBy(how = How.CSS, using = "input[id='address']")
    private WebElement addressInput;

    @FindBy(how = How.CSS, using = "input[id='submitCartCustomer']")
    private WebElement submitOrderButton;

    public void clickSubmitOrder() {
        submitOrderButton.click();
    }

    public void inputName(String name) {
        nameInput.sendKeys(name);
    }

    public void inputEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void inputPhone(String phone) {
        phoneInput.sendKeys(phone);
    }


    public void inputAddress(String address) {
        addressInput.sendKeys(address);
    }

    public ShoppingCartCustomerPage(WebDriver driver) {
        super(driver);
    }
}
