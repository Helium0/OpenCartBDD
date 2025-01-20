package helper;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Date;


public class Helper {

    protected WebDriver driver;


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

    public static String getTimeStamp() {
        Date date = new Date();
        return date.toString().replace(" ","_").replace(":","_");
    }

    public Faker fakeUserData() {
        return new Faker();
    }

}
