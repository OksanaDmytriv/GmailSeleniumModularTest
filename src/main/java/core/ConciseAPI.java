package core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }

    public static <V> void assertThat(ExpectedCondition<V> condition) {
        assertThat(condition, Configuration.timeout);
    }

    public static <V> void assertThat(ExpectedCondition<V> condition, int timeout) {
        (new WebDriverWait(getDriver(), timeout)).until(condition);
    }

    public static WebElement $(By locator) {
        assertThat(visibilityOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    public static WebElement $(String cssSelector) {
        By locator = byCSS(cssSelector);
        return $(locator);
    }

    public static List<WebElement> $$(By locator) {
        assertThat(visibilityOfAllElementsLocatedBy(locator));
        return getDriver().findElements(locator);
    }

    public static By byText(String text) {
        return By.xpath("//*[text()[contains(.,'" + text + "')]]");
    }

    public static By byCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static void open(String URL) {
        getDriver().get(URL);
    }
}
