package core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    private static WebDriver driver = new FirefoxDriver();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver() {
        driver = new FirefoxDriver();
    }

    public <V> void assertThat(ExpectedCondition<V> condition) {
        assertThat(condition, Configuration.timeout);
    }

    public <V> void assertThat(ExpectedCondition<V> condition, int timeout) {
        (new WebDriverWait(getDriver(), timeout)).until(condition);
    }

    public WebElement $(By locator) {
        assertThat(visibilityOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    public WebElement $(String cssSelector) {
        return getDriver().findElement(By.cssSelector(cssSelector));
    }

    public List<WebElement> $$(By locator) {
        //assertThat(visibilityOfAllElementsLocatedBy(locator));
        return getDriver().findElements(locator);
    }

    public By byText(String text) {
        return By.xpath("//*[text()[contains(.,'" + text + "')]]");
    }

    public By byCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public void open(String URL) {
        getDriver().get(URL);
    }
}
