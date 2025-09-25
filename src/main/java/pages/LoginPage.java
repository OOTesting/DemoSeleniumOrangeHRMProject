package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By usernameField = By.cssSelector("input[name='username']");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".oxd-alert-content-text");




    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    public void setUsername(String username) {
        type(usernameField, username);
    }

    public void setPassword(String password) {
        type(passwordField, password);
    }

    public void logIntoApplication(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        clickButton(loginButton);
    }

    public boolean isLoginSuccessful() {
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        return dashboardPage.isDashboardVisible();
    }


    public void loginErrorMessage () {
        isDisplayed(errorMessage);

    }

}