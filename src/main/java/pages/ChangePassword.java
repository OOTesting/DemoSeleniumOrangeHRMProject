package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ChangePassword extends BasePage {
    private By dropdownMenuItems = By.cssSelector(".oxd-dropdown-menu .oxd-userdropdown-link");
    private By aboutHeaderText = By.xpath("//h6[contains(@class,'orangehrm-main-title') and normalize-space()='About']");


    public ChangePassword(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Generic method to click a menu item by name
     public void clickMenuItem(String menuName) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownMenuItems));
            List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownMenuItems));


         for (WebElement item : items) {
                String text = item.getText().trim();
                if (text.equalsIgnoreCase(menuName)) {
                    item.click();
                    return; // stop after clicking
                }
            }

            throw new RuntimeException("Menu item not found: " + menuName);
        }

        // Specific actions for clarity in test cases
        public void logout() {
            clickMenuItem("Logout");
        }

        public void goToSupport() {
            clickMenuItem("Support");
        }

        public void goToAbout() {
            clickMenuItem("About");
        }

        public void changePassword() {
            clickMenuItem("Change Password");
        }

        public boolean isAboutHeaderDisplayed() {
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutHeaderText));
            return header.isDisplayed();
    }
    }
