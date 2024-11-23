package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class Hooks {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}