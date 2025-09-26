package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.ViewNewEmployee;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonDataReader;
import utils.Log;

import io.qameta.allure.*;

import org.slf4j.Logger;
import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import utils.SlowMotionHelper;

@Feature("Add Employee")
public class EmployeeCreationTest extends BaseTest {

    private static final Logger log = Log.getLogger(EmployeeCreationTest.class);
    private Faker faker = new Faker();

    @Test(description = "Create new employee with random data and check data matches")
    @Severity(SeverityLevel.BLOCKER)
    public void createEmployee() {
        // Generate random first and last name
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        log.info("Generated employee: {} {}", firstName, lastName);

        // Read admin credentials from JSON
        JsonObject adminData = JsonDataReader.readJson("Admin.json");
        String username = adminData.get("username").getAsString();
        String password = adminData.get("password").getAsString();

        // Login
        log.info("Logging in with admin credentials");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.logIntoApplication(username, password);

        SlowMotionHelper slow = new SlowMotionHelper(driver, 3000);

        // Add new employee
        log.info("Navigating to PIM and adding a new employee");
        AddEmployee addEmployeePage = new AddEmployee(driver, wait);
        addEmployeePage.goToPIM();
        addEmployeePage.selectAddButton();
        slow.click(addEmployeePage.addANewEmployee(firstName, lastName));

        // Verify that employee has been added correctly
        log.info("Verifying that the employee was created successfully");
        ViewNewEmployee viewEmployeePage = new ViewNewEmployee(driver, wait);

        // Make sure your ViewNewEmployee class has these getter methods:
        String actualFirstName = viewEmployeePage.getFirstNameField();
        String actualLastName = viewEmployeePage.getLastNewNameField();

        log.info("Expected first name: {}, Actual first name: {}", firstName, actualFirstName);
        log.info("Expected last name: {}, Actual last name: {}", lastName, actualLastName);

        Assert.assertEquals(actualFirstName, firstName, "First name does not match!");
        Assert.assertEquals(actualLastName, lastName, "Last name does not match!");
    }
}
