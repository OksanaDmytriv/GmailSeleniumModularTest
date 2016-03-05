package testconfigs;

import core.ConciseAPI;
import core.Configuration;
import org.junit.AfterClass;

public class BaseTest {

    static {
        Configuration.timeout = 20;
    }

    @AfterClass
    public static void teardown() {
        ConciseAPI.getDriver().quit();
    }

}
