package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Helper {

    WebDriver driver;

    public Helper(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebDriverWait waitMethod() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean textElement(By loc, String text) {
        return waitMethod().until(ExpectedConditions.textToBe(loc,text));
    }

}
