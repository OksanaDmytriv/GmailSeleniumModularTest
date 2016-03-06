package testconfigs;

import core.ConciseAPI;
import core.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    static WebDriver driver;

    static {
        Configuration.timeout = 20;
    }

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
        ConciseAPI.setDriver(driver);
    }

    @AfterClass
    public static void teardown() {
        ConciseAPI.getDriver().quit();
    }

}
