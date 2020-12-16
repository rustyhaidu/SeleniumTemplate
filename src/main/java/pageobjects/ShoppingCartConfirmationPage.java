package pageobjects;

import frontend.abstractpage.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartConfirmationPage extends AbstractPage {
    @FindBy(how = How.CSS, using = "input[id='submitOrderConfirmation']")
    private WebElement submitOrderConfirmation;

    public void clickSubmitOrderConfirmation(){
        submitOrderConfirmation.click();
    }

    public ShoppingCartConfirmationPage(WebDriver driver) {
        super(driver);
    }
}
