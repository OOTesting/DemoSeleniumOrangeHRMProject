package tests;

import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonDataReader;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        JsonObject InvalidUSerData = JsonDataReader.readJson("InvalidUser.json");

        String username = InvalidUSerData.get("username").getAsString();
        String password = InvalidUSerData.get("password").getAsString();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication(username, password);
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Dashboard should not be visible after login");
    }
}
