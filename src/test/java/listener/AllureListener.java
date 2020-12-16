
package listener;

import base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureListener extends BaseTest implements ITestListener {


    /**
     * Method return the description from the 'description' attribute provided in the @Test
     *
     * @param iTestResult the result of the test
     * @return the description of the Test
     */
    private String getTestDescription(ITestResult iTestResult) {
        return iTestResult.getMethod().getDescription() ;
    }

    /**
     * Method is used to return the test method name.
     *
     * @param iTestResult Results of the tests
     * @return Name of the test method
     */
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    /**
     * Method is used in order to save specific log message.
     *
     * @param message What to log
     * @return Message log
     */
    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

    /**
     * Method is used to save a screenshot
     *
     * @param driver WebDriver instance
     * @return The screenshot
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Method is used when a test fails.
     * 1. Save the screenshot where the test failed.
     * 2. Save the test method name.
     *
     * @param iTestResult The test result
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {

        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        saveScreenshot(driver);
        saveTextLog("Test method: " + getTestMethodName(iTestResult));
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
