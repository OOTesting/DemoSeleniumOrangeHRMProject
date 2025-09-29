package tests;

import com.google.gson.JsonObject;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderMenu;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonDataReader;
import utils.Log;


@Feature("Access about functionality")
public class ChangePasswordTest extends BaseTest {

    private static final Logger log = Log.getLogger(ChangePasswordTest.class);

    @Test(description = "Verify that you can access about")

    @Severity(SeverityLevel.NORMAL)
    public void testAccessAbout() {
        // Read admin credentials from JSON
        JsonObject adminData = JsonDataReader.readJson("Admin.json");
        String username = adminData.get("username").getAsString();
        String password = adminData.get("password").getAsString();

        log.info("Attempting login with username: {}", username);

        LoginPage loginPage = new LoginPage(driver, wait);
        HeaderMenu headerMenu = new HeaderMenu(driver, wait);

        loginPage.logIntoApplication(username, password);

        // Assertion: Dashboard should be visible
        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Dashboard should be visible after login");


        headerMenu.goToAbout();

        // Assertion to confirm about modal is displayed
        headerMenu.isAboutHeaderDisplayed();



    }
}
