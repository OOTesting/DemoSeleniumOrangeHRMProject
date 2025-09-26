package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewNewEmployee extends BasePage {

    private By firstNewNameField = By.cssSelector("input.orangehrm-firstname");
    private By lastNewNameField = By.cssSelector("input.orangehrm-lastname");

    public ViewNewEmployee(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Read actual values from the page
    public String getFirstNameField() {
        return driver.findElement(firstNewNameField).getAttribute("value");
    }

    public String getLastNewNameField() {
        return driver.findElement(lastNewNameField).getAttribute("value");
    }
}


