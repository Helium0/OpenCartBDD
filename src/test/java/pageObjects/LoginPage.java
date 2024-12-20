package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     WebDriver driver;


    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement login;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(id = "input-password")
    private WebElement setPassword;

    @FindBy(id = "input-email")
    private WebElement setEmail;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void getMyAccount() {
        myAccount.click();
    }

    public void getLogin() {
        login.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void setUserEmail(String email) {
        setEmail.sendKeys(email);
    }
    public void setUserPassword(String password) {
        setPassword.sendKeys(password);
    }
}
