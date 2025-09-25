package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonDataReader;
import com.google.gson.JsonObject;

public class LoginPositiveTest extends BaseTest {

    @Test
    public void testValidLogin() {
        String jsonPath = System.getProperty("user.dir") + "src/test/java/data/Admin.JSON";
        JsonObject loginData = JsonDataReader.readJson(jsonPath);

        String username = loginData.get("username").getAsString();
        String password = loginData.get("password").getAsString();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication(username, password);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Dashboard should be visible after login");
    }
}
