
package utils.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {


    public static WebDriverWait wait(WebDriver driver, long timeInSeconds) {
        return new WebDriverWait(driver, timeInSeconds);
    }

    /**
     * Method is used to wait until a specific element is no longer displayed
     *
     * @param element The element to wait for
     * @param driver WebDriver instance
     */
    public static void waitUntilInvisibilityOfElement(WebElement element, WebDriver driver) {
        wait(driver, 25).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void sleepFor(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
