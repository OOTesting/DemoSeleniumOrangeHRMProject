package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Log;
import pages.HeaderMenu;
import helper.LoginHelper;


@Feature("Logout Functionality")
public class LogoutTest extends BaseTest {

    private static final Logger log = Log.getLogger(LogoutTest.class);

    @Test(description = "Verify that a user can logout")

    @Severity(SeverityLevel.CRITICAL)
    public void testValidLogout() {
        log.info("Attempting login");
        LoginHelper.loginAsAdmin(driver, wait);

        HeaderMenu headerMenu = new HeaderMenu(driver, wait);

        log.info("Select logout from user menu drop down");

        headerMenu.openUserDropdown();
        headerMenu.logout();

        // Assertion to confirm logout (example: login page visible again)
        Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"),
                "User was not redirected to login page after logout");


    }
}
