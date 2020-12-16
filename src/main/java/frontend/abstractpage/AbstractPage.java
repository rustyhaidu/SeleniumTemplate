
package frontend.abstractpage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.helpers.Waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class AbstractPage {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    protected final WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void ensurePageIsDisplayed(WebElement element, String pageName) {
        await().atMost(60, TimeUnit.SECONDS).until(element::isDisplayed);
        LOG.info("{} is displayed.", pageName);
    }

    protected void waitUntilVisibilityOfElement(WebElement element) {
        await().atMost(15, TimeUnit.SECONDS).until(element::isDisplayed);
        LOG.info("Element is displayed.");
    }

    private FluentWait fluentWait() {
        return new FluentWait(driver).withTimeout(Duration.ofSeconds(15)).ignoring(NoSuchElementException.class);
    }

    private void setDriverTimeout(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            fluentWait().until(visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitUntilInvisibilityOfElement(WebElement element) {
        Waits.waitUntilInvisibilityOfElement(element, driver);
        LOG.info("Element no longer displayed.");

    }

    public void waitUntilIdentifiedElementIsVisibleAndClickeble(By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(NullPointerException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(TimeoutException.class)
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.presenceOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)));
        } catch (WebDriverException e) {
            LOG.info("Element was not found" + e);
        }
    }

    public void waitUntilIdentifiedElementIsVisibleAndClickeble(By by, int seconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(seconds))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(NullPointerException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(TimeoutException.class)
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.presenceOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)));
        } catch (WebDriverException e) {
            LOG.info("Element was not found" + e);
        }
    }

    public boolean isIdentifiedElementIsVisibleAndClickeble(By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(NullPointerException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(TimeoutException.class)
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.presenceOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)));
            return true;
        } catch (WebDriverException e) {
            LOG.info("Element was not found" + e);
            return false;
        }
    }

    public boolean isIdentifiedElementIsVisibleAndClickeble(By by, int seconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(seconds))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(NullPointerException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(TimeoutException.class)
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.presenceOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)));
            return true;
        } catch (WebDriverException e) {
            LOG.info("Element was not found" + e);
            return false;
        }
    }

    public void waitUntilListOfElementsIsVisible(By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NullPointerException.class)
                    .ignoring(TimeoutException.class);
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(by));
        } catch (WebDriverException e) {
            LOG.info("List of Elements not found" + e);
        }
    }

    public void waitUntilIdentifiedElementHasText(By by, String text) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NullPointerException.class)
                    .ignoring(TimeoutException.class);
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.textToBePresentInElementLocated(by, text)));
        } catch (WebDriverException e) {
            LOG.info("Element was not found" + e);
        }
    }
}
