package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        String username = "Admin";
        String password = "admin_123";

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication("Admin", "admin_123");
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Dashboard should not be visible after login");
    }
}
