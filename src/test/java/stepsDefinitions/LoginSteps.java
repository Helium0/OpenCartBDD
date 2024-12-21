package stepsDefinitions;

import helper.Helper;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class LoginSteps {

    public WebDriver driver;
    public LoginPage loginPage;
    private static final By myAccount = By.xpath("//h2[text()='My Account']");
    private static final By alertMessage = By.xpath("//dirv[@class='alert alert-danger alert-dismissible']");

//    @Given("User navigates to the Login section")
//    public void user_navigates_to_the_login_section() {
////        driver = new ChromeDriver();
////        driver.get("http://localhost/OpenShop/");
//        loginPage = new LoginPage(driver);
//        loginPage.getMyAccount();
//        loginPage.getLogin();
//    }

    @When("User enters valid email address {string}")
    public void user_enters_valid_email_address(String userEmail) {
        loginPage.setUserEmail(userEmail);
    }

    @And("Enter valid password {string}")
    public void enter_valid_password(String userPassword) {
        loginPage.setUserPassword(userPassword);
    }

    @And("Click Login")
    public void click_login() {
        loginPage.clickLoginButton();
    }

    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        boolean helper = new Helper(driver).textElement(myAccount,"My Account");

        if (helper) {
            Assert.assertTrue(helper);
        } else {
            Assert.fail("Assertion failed");
        }
    }

    @And("Close browser")
    public void close_browser() {
        driver.quit();
    }

    @When("User enters invalid email address {string}")
    public void user_enters_invalid_email_address(String userEmail) {
        loginPage.setUserEmail(userEmail);
    }

    @When("Enter invalid password {string}")
    public void enter_invalid_password(String userPassword) {
        loginPage.setUserPassword(userPassword);
    }

    @Then("User should receive alert message")
    public void user_should_receive_alert_message() {
        boolean helper = new Helper(driver).textElement(alertMessage,"Warning: No match for E-Mail Address and/or Password.");
        if (helper) {
            Assert.assertTrue(helper);
        } else {
            Assert.fail("Assertion failed");
        }
    }
}
