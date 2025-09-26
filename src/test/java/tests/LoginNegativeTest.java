package tests;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonDataReader;


import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.Log;


@Feature("Login Functionality")
public class LoginNegativeTest extends BaseTest {
    private static final Logger log = Log.getLogger(LoginNegativeTest.class);
    @Test(description = "Verify that invalid login credentials do not allow login")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidLogin() {
        // Read invalid credentials from JSON
        JsonObject invalidUserData = JsonDataReader.readJson("InvalidUser.json");
        String username = invalidUserData.get("username").getAsString();
        String password = invalidUserData.get("password").getAsString();

        log.info("Attempting login with admin with invalid password");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication(username, password);

        // Assertion: Dashboard should not be visible
        Assert.assertFalse(loginPage.isLoginSuccessful(),
                "Dashboard should not be visible after login with invalid credentials");

    }
}
