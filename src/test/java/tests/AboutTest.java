package tests;

import helper.LoginHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import pages.HeaderMenu;
import utils.BaseTest;
import utils.Log;


@Feature("Access about functionality")
public class AboutTest extends BaseTest {

    private static final Logger log = Log.getLogger(AboutTest.class);

    @Test(description = "Verify that you can access about")

    @Severity(SeverityLevel.NORMAL)
    public void testAccessAbout() {

        log.info("Attempting login");
        LoginHelper.loginAsAdmin(driver, wait);

        HeaderMenu headerMenu = new HeaderMenu(driver, wait);

        log.info("Select the about link");
        headerMenu.openUserDropdown();
        headerMenu.goToAbout();

        // Assertion to confirm about modal is displayed
        headerMenu.isAboutHeaderDisplayed();



    }
}
