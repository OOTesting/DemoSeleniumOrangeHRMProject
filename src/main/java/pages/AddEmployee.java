package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AddEmployee extends BasePage {
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By submitButton = By.cssSelector("[type='submit']");
    private By selectAdd = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']/parent::button");
    private By titleAddLocator = By.cssSelector("h6.oxd-text.oxd-text--h6.orangehrm-main-title");
    private boolean employeeAdd = false;


    public AddEmployee(WebDriver driver, WebDriverWait wait){

        super(driver, wait);
    }

    public void goToPIM() {
       DashboardPage dashboardPage = new DashboardPage(driver, wait);
       dashboardPage.isMainMenuVisible();
       dashboardPage.openPIM();
    }

    public void selectAddButton() {
        clickButton(selectAdd);
        employeeAdd = isDisplayed(titleAddLocator);

    }

    public void addANewEmployee(String fName, String lName) {
        type(firstNameField, fName);
        type(lastNameField, lName);
        clickButton(submitButton);

    }

 }
