package pageobjects;

import frontend.abstractpage.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage extends AbstractPage {
    @FindBy(how = How.CSS, using = "a[id='continueBuyLink']")
    private WebElement continueBuyLink;

    @FindBy(how = How.CSS, using = "a[id='enterCustomerInfoLink']")
    private WebElement enterCustomerInfoLink;

    public void clickContinueBuyLink(){
        continueBuyLink.click();
    }

    public void clickEnterCustomerInfoLink(){
        enterCustomerInfoLink.click();
    }

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
}
