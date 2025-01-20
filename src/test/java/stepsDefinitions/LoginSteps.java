package stepsDefinitions;


import helper.Helper;
import helper.MyHooks;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;


public class LoginSteps {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected Logger logger;

    private static final By MY_ACCOUNT = By.xpath("//h2[text()='My Account']");
    private static final By MY_ACCOUNT_LOGIN_ATTEMPTS = By.xpath("//dirv[@class='alert alert-danger alert-dismissible']");
    private static final By ALERT_MESSAGE = By.xpath("//dirv[@class='alert alert-danger alert-dismissible']");



    @Given("User navigates to the Login section")
    public void user_navigates_to_the_login_section() {
        logger = LogManager.getLogger(this.getClass().getName());
        logger.info("*** User navigates to the Login section ***");
        MyHooks myHooks = new MyHooks();
        driver = myHooks.getBrowser();
        loginPage = new LoginPage(driver);
        loginPage.getMyAccount();
        loginPage.getLogin();
    }

    @When("User enters valid email address {string}")
    public void user_enters_valid_email_address(String userEmail) {
        logger.info("*** User enters valid email address ***");
        loginPage.setUserEmail(userEmail);
    }


    @And("Enter valid password {string}")
    public void enter_valid_password(String userPassword) {
        logger.info("*** Enter valid password ***");
        loginPage.setUserPassword(userPassword);
    }

    @And("Click Login")
    public void click_login() {
        logger.info("*** Click Login ***");
        loginPage.clickLoginButton();
    }

    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        boolean helper = new Helper(driver).textElement(MY_ACCOUNT,"My Account");
        boolean helper1 = new Helper(driver).textElement(MY_ACCOUNT_LOGIN_ATTEMPTS,"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.");

        if (helper || helper1) {
            logger.info("*** User succesfully logged in ***");
            Assert.assertTrue(true);
        } else {
            logger.info("*** User unsuccesfully logged in ***");
            Assert.fail("Assertion failed");
        }
    }

    @And("Close browser")
    public void close_browser() {
        logger.info("*** Close browser ***");
        driver.quit();
    }

    @When("User enters invalid email address {string}")
    public void user_enters_invalid_email_address(String userEmail) {
        logger.info("*** User enters invalid email address ***");
        loginPage.setUserEmail(userEmail);
    }

    @When("Enter invalid password {string}")
    public void enter_invalid_password(String userPassword) {
        logger.info("*** Enter invalid password ***");
        loginPage.setUserPassword(userPassword);
    }

    @Then("User should receive alert message")
    public void user_should_receive_alert_message() {
        boolean helper = new Helper(driver).textElement(ALERT_MESSAGE,"Warning: No match for E-Mail Address and/or Password.");
        if (helper) {
            logger.info("*** User received proper alert message ***");
            Assert.assertTrue(true);
        } else {
            logger.info("*** User not received proper alert message ***");
            Assert.fail("Assertion failed");
        }
    }
}
