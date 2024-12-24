package stepsDefinitions;


import helper.Helper;
import helper.MyHooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;


public class LoginSteps {

    protected WebDriver driver;
    protected LoginPage loginPage;

    private static final By MYACCOUNT = By.xpath("//h2[text()='My Account']");
    private static final By ALERTMESSAGE = By.xpath("//dirv[@class='alert alert-danger alert-dismissible']");



    @Given("User navigates to the Login section")
    public void user_navigates_to_the_login_section() {
        MyHooks myHooks = new MyHooks();
        driver = myHooks.getBrowser();
        loginPage = new LoginPage(driver);
        loginPage.getMyAccount();
        loginPage.getLogin();
    }

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
        boolean helper = new Helper(driver).textElement(MYACCOUNT,"My Account");

        if (helper) {
            Assert.assertTrue(true);
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
        boolean helper = new Helper(driver).textElement(ALERTMESSAGE,"Warning: No match for E-Mail Address and/or Password.");
        if (helper) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Assertion failed");
        }
    }
}
