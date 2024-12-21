package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    @FindBy(linkText = "Continue")
    private WebElement continueButton;
    @FindBy(id = "input-firstname")
    private WebElement inputUserFirstName;
    @FindBy(id = "input-lastname")
    private WebElement inputUserLastName;
    @FindBy(id = "input-email")
    private WebElement inputUserEmail;
    @FindBy(id = "input-password")
    private WebElement inputUserPassword;
    @FindBy(name = "agree")
    private WebElement privacyPolicySlider;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void setUserFirstName(String name) {
        inputUserFirstName.sendKeys(name);
    }

    public void setInputUserLastName(String lastName) {
        inputUserLastName.sendKeys(lastName);
    }
    public void setInputUserEmail(String email) {
        inputUserEmail.sendKeys(email);
    }
    public void setInputUserPassword(String password) {
        inputUserPassword.sendKeys(password);
    }
    public void movePrivacyPolicySlider() {
        privacyPolicySlider.click();
    }

}
