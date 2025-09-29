package helper;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.testng.Assert;
import pages.LoginPage;
import utils.JsonDataReader;
import utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper {

    private static final Logger log = Log.getLogger(LoginHelper.class);

    public static void loginAsAdmin(WebDriver driver, WebDriverWait wait) {
        JsonObject adminData = JsonDataReader.readJson("Admin.json");

        String username = adminData.get("username").getAsString();
        String password = adminData.get("password").getAsString();

        log.info("Login as admin");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication(username, password);

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Dashboard should be visible after login");
    }
}
