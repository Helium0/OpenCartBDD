package helper;


import factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class MyHooks extends WebDriverFactory {


    private WebDriverFactory webDriverFactory;



    @Before
    public WebDriver getBrowser() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebdriverBrowser("chrome");
        driver.get("http://localhost/OpenShop/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
