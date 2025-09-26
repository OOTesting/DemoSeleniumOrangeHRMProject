package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonDataReader;
import com.google.gson.JsonObject;


import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.Log;
import org.slf4j.Logger;


@Feature("Login Functionality")
public class LoginPositiveTest extends BaseTest {

    private static final Logger log = Log.getLogger(LoginPositiveTest.class);

    @Test(description = "Verify that a valid admin user can log in successfully")

    @Severity(SeverityLevel.CRITICAL)
    public void testValidLogin() {
        // Read admin credentials from JSON
        JsonObject adminData = JsonDataReader.readJson("Admin.json");
        String username = adminData.get("username").getAsString();
        String password = adminData.get("password").getAsString();

        log.info("Attempting login with username: {}", username);
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication(username, password);


        // Assertion: Dashboard should be visible
        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Dashboard should be visible after login");


    }
}
