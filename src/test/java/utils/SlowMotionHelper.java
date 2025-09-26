package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SlowMotionHelper {
    private WebDriver driver;
    private int delay; // milliseconds

    public SlowMotionHelper(WebDriver driver, int delay) {
        this.driver = driver;
        this.delay = delay;
    }

    private void pause() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public WebElement find(By locator) {
        pause();
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
        pause();
    }

    public void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
        pause();
    }
}
