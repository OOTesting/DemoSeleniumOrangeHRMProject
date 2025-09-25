package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonDataReader;
import utils.Retry;

import com.google.gson.JsonObject;

import java.util.HashMap;

public class EmployeeCreationTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void createEmployee(HashMap<String, String> input) {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication("Admin", "admin123");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed.");

        AddEmployee addEmployeePage = new AddEmployee(driver, wait);
        addEmployeePage.goToPIM();
        addEmployeePage.selectAddButton(); // Ensure this method exists in AddEmployee
        addEmployeePage.addANewEmployee(input.get("firstName"), input.get("lastName"));
    }

    @Test(dependsOnMethods = { "createEmployee" }, dataProvider = "getData", retryAnalyzer = Retry.class)
    public void verifyEmployeeCreation(HashMap<String, String> input) {
        Assert.assertTrue(true, "Employee verification placeholder");
    }

    @DataProvider
    public Object[][] getData() {
        String path = System.getProperty("user.dir") + "/src/test/java/data/Employee.json";
        JsonObject obj = JsonDataReader.readJson(path);

        HashMap<String, String> map = new HashMap<>();
        map.put("firstName", obj.get("firstName").getAsString());
        map.put("lastName", obj.get("lastName").getAsString());

        return new Object[][] { { map } };
    }
}
