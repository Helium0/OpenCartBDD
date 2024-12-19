package stepsDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class Loginsteps {

    public WebDriver driver;
    public LoginPage loginPage;

    @Given("User navigates to the Login section")
    public void user_navigates_to_the_login_section() {
        driver = new ChromeDriver();
        driver.get("http://localhost/OpenShop/");
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
    public void click_login() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(3000);
    }
    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() throws InterruptedException {


    }

    @And("Close application")
    public void close_application() {
        driver.quit();
    }
}
