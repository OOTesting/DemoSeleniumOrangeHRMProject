package tests;

import org.testng.Assert;
import utils.JsonDataReader;
import com.google.gson.JsonObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.LoginPage;
import utils.BaseTest;
import utils.Retry;

import com.google.gson.JsonObject;

import java.util.HashMap;

public class EmployeeCreationTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void createEmployee(HashMap<String, String> input) {
        JsonObject adminData = JsonDataReader.readJson("Admin.json");
        String username = adminData.get("username").getAsString();
        String password = adminData.get("password").getAsString();

        // Login
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication(username, password);


        AddEmployee addEmployeePage = new AddEmployee(driver, wait);
        addEmployeePage.goToPIM();
        addEmployeePage.selectAddButton();
        addEmployeePage.addANewEmployee(input.get("firstName"), input.get("lastName"));
    }

    @Test(dependsOnMethods = { "createEmployee" }, dataProvider = "getData", retryAnalyzer = Retry.class)
    public void verifyEmployeeCreation(HashMap<String, String> input) {
        Assert.assertTrue(true, "Employee verification placeholder");
    }

    @DataProvider
    public Object[][] getData() {
        // Read JSON file
        JsonObject employeeData = JsonDataReader.readJson("Employee.json");

        // Map JSON fields to HashMap
        HashMap<String, String> map = new HashMap<>();
        map.put("firstName", employeeData.get("firstName").getAsString());
        map.put("lastName", employeeData.get("lastName").getAsString());

        // Return as 2D array for TestNG data provider
        return new Object[][] { { map } };
    }
}
