package frontend.abstractpage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import static org.awaitility.Awaitility.await;

public abstract class HomePage extends AbstractPage {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Base method to select a random option from a Select Web Element
     *
     * @param webElement - the webElement we want to select the random option from
     */
    @Step("Select a value")
    protected void select(WebElement webElement, String visibleText) {
        LOG.info("Setting the value on the Web Element: " + webElement.getText());
        Select select = new Select(webElement);

        select.selectByVisibleText(visibleText);
        await().until(() -> visibleText.equals(select.getFirstSelectedOption().getText()));
    }

    /**
     * Retrieving the text from the Selected Option
     *
     * @param webElement - The web element from which we want to get the text from
     * @return - return the text of the Selected Option
     */
    @Step("Get the selected value option from the Select Web Element ")
    protected String getTextFromSelectedOption(WebElement webElement) {
        return new Select(webElement).getFirstSelectedOption().getText();
    }

    /**
     * Base method to select a random option from a Select Web Element
     *
     * @param webElement - the webElement we want to select the random option from
     */
    @Step("Select a random value between its range")
    protected void selectRandomValue(WebElement webElement) {
        Random random = new Random();
        Select select = new Select(webElement);
        int max = select.getOptions().size();
        int randomInt = random.nextInt(max - 1) + 1;

        LOG.info("Setting the value on the Web Element: " + select.getOptions().get(randomInt).getText());
        select.selectByIndex(randomInt);
        await().until(() -> getTextFromSelectedOption(webElement).equals(select.getOptions().get(randomInt).getText()));
    }

    public void searchInput(WebElement searchInput, String searchSelector, String searchText) {
        waitUntilListOfElementsIsVisible(By.cssSelector(searchSelector));
        searchInput.clear();
        searchInput.sendKeys(searchText);
    }
}
