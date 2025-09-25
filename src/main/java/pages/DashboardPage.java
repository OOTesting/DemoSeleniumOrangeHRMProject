package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By mainMenu = By.cssSelector(".oxd-main-menu");
    private By pimMenu = By.xpath("//div[@class='oxd-main-menu']//span[text()='PIM']");

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isDashboardVisible() {
        return isDisplayed(dashboardHeader);
    }

    public void openPIM() {
        clickButton(pimMenu);
    }

    public boolean isMainMenuVisible() {
        return isDisplayed(mainMenu);
    }
}

