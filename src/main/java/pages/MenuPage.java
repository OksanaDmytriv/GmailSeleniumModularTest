package pages;

import core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class MenuPage {

    ConciseAPI conciseAPI = new ConciseAPI();

    public void refresh() {
        conciseAPI.$(conciseAPI.byCSS(".asf")).click();
    }

    public void openSent() {
        conciseAPI.$(By.linkText("Sent Mail")).click();
    }

    public void openInbox() {
        conciseAPI.$(conciseAPI.byCSS("a[aria-label^='Inbox']")).click();
    }

    public void search(String subject) {
        conciseAPI.$(By.name("q")).clear();
        conciseAPI.$(By.name("q")).sendKeys("subject:" + subject + Keys.ENTER);
    }
}
