package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Listeners extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[START] Test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[PASS] Test: " + result.getMethod().getMethodName());
        attachText("Test Passed", "Test passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[FAIL] Test: " + result.getMethod().getMethodName());
        attachText("Failure Reason", result.getThrowable().toString());

        try {
            driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getField("driver")
                    .get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
            attachScreenshot(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SKIP] Test: " + result.getMethod().getMethodName());
        attachText("Test Skipped", result.getThrowable() != null ? result.getThrowable().toString() : "No reason provided.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("[WARN] Test failed but within success percentage: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("[SUITE START] " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[SUITE FINISH] " + context.getName());
    }

    // 🔗 Attach plain text to Allure
    @Attachment(value = "{title}", type = "text/plain")
    public String attachText(String title, String message) {
        return message;
    }

    // 🔗 Attach screenshot to Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }
}
