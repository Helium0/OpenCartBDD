package stepsDefinitions;

import helper.Helper;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class RegisterSteps {


    public WebDriver driver;
    public RegisterPage registerPage;
    public LoginPage loginPage;
    public Helper helper;




    @Given("User opens Login section")
    public void user_opens_login_section() {
        driver = new ChromeDriver();
        driver.get("http://localhost/OpenShop/");
        loginPage = new LoginPage(driver);
        loginPage.getMyAccount();
        loginPage.getLogin();
    }

    @And("Click continue button")
    public void click_continue_button() {
        registerPage = new RegisterPage(driver);
        registerPage.clickContinueButton();
    }

    @When("User enters valid first name")
    public void user_enters_valid_first_name() {
        helper = new Helper(driver);
        registerPage.setUserFirstName(helper.fakeUserData().name().firstName());
    }

    @And("Enters valid last name")
    public void enters_valid_last_name() {
        registerPage.setInputUserLastName(helper.fakeUserData().name().lastName());
    }

    @And("Enters valid email adress")
    public void enters_valid_email_adress() {
        registerPage.setInputUserEmail(helper.fakeUserData().internet().emailAddress());
    }

    @And("Enters valid password")
    public void enters_valid_password() {
        registerPage.setInputUserPassword(helper.fakeUserData().internet().password());
    }

    @And("Accepts privacy policy")
    public void accepts_privacy_policy() {
        registerPage.movePrivacyPolicySlider();
    }

    @And("Click continue")
    public void click_continue() {
        driver.findElement(By.cssSelector("btn btn-primary")).click();
    }

    @Then("Defined account should be registered")
    public void defined_account_should_be_registered() {
        System.out.println("OKOK");

    }
}
