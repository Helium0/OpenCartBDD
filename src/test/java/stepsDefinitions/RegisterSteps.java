package stepsDefinitions;

import factory.WebDriverFactory;
import helper.Helper;
import helper.MyHooks;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.RegisterPage;



public class RegisterSteps extends WebDriverFactory {


    protected RegisterPage registerPage;
    protected Helper helper;
    protected Logger logger;

    private static final By ACCOUNT_MESSAGE = By.xpath("//h1[text()='Your Account Has Been Created!']");
    private static final By FIRST_NAME_MESSAGE = By.id("error-firstname");
    private static final By LAST_NAME_MESSAGE = By.id("error-lastname");
    private static final By EMAIL_MESSAGE = By.id("error-email");
    private static final By PASSWORD_MESSAGE = By.id("error-password");
    private static final By PRIVACY_POLICY_MESSAGE = By.xpath("//dirv[@class='alert alert-danger alert-dismissible']");

    @And("Click continue button")
    public void click_continue_button() {
        logger = LogManager.getLogger(this.getClass().getName());
        logger.info("*** Click Continue Button ***");
        registerPage = new RegisterPage(driver);
        registerPage.clickContinueButton();
    }

    @When("User enters valid first name")
    public void user_enters_valid_first_name() {
        logger.info("*** User enters valid first name ***");
        helper = new Helper(driver);
        registerPage.setUserFirstName(helper.fakeUserData().name().firstName());
    }

    @When("User doesn`t enter any data fields")
    public void user_doesnt_enter_any_data_fields() {
        logger.info("*** Without enters any data fields ***");
        registerPage.clickContinueButtonToRegister();
    }

    @And("Enters valid last name")
    public void enters_valid_last_name() {
        logger.info("*** Enters Valid Last Name ***");
        registerPage.setInputUserLastName(helper.fakeUserData().name().lastName());
    }

    @And("Enters valid email adress")
    public void enters_valid_email_adress() {
        logger.info("*** Enters Valid Email Adress ***");
        registerPage.setInputUserEmail(helper.fakeUserData().internet().emailAddress());
    }

    @And("Enters valid password")
    public void enters_valid_password() {
        logger.info("*** Enters Valid Password ***");
        registerPage.setInputUserPassword(helper.fakeUserData().internet().password());
    }

    @And("Accepts privacy policy")
    public void accepts_privacy_policy() {
        logger.info("*** Accepts Privacy Policy ***");
        registerPage.movePrivacyPolicySlider();
    }

    @And("Click continue button for register")
    public void click_continue_button_for_register() {
        logger.info("*** Click Continue Button For Register ***");
        registerPage.clickContinueButtonToRegister();
    }

    @Then("Defined account should be registered")
    public void defined_account_should_be_registered() {
        boolean helper = new Helper(driver).textElement(ACCOUNT_MESSAGE, "Your Account Has Been Created!");
        if(helper) {
            logger.info("*** Account registered succesfully ***");
            Assert.assertTrue(true);
        } else {
            logger.info("*** Account unregistered ***");
            Assert.fail("Assertion failed");
        }
    }

    @Then("Remaining fields errors appear")
    public void remaining_fields_errors_appear() {
        boolean helper0 = new Helper(driver).textElement(FIRST_NAME_MESSAGE, "First Name must be between 1 and 32 characters!");
        boolean helper1 = new Helper(driver).textElement(LAST_NAME_MESSAGE, "Last Name must be between 1 and 32 characters!");
        boolean helper2 = new Helper(driver).textElement(EMAIL_MESSAGE, "E-Mail Address does not appear to be valid!");
        boolean helper3 = new Helper(driver).textElement(PASSWORD_MESSAGE, "Password must be between 4 and 20 characters!");
        if(helper0 && helper1 && helper2 && helper3){
            logger.info("*** Error Fields Appeared ***");
            Assert.assertTrue(true);
        } else {
            logger.info("*** Error Fields Not Appeared ***");
            Assert.fail("Assertion failed");
        }

    }

    @Then("Privacy policy error message appears")
    public void privacy_policy_error_message_appears() {
        boolean helper = new Helper(driver).textElement(PRIVACY_POLICY_MESSAGE, "Warning: You must agree to the Privacy Policy!");
        if(helper){
            logger.info("*** Privacy Policy error message appeared ***");
            Assert.assertTrue(true);
        } else {
            logger.info("*** No Privacy Policy error message ***");
            Assert.fail("Assertion failed");
        }
    }



}
