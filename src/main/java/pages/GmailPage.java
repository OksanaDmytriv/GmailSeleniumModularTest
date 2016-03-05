package pages;

import core.ConciseAPI;
import org.openqa.selenium.Keys;


public class GmailPage {

    ConciseAPI conciseAPI = new ConciseAPI();

    public void login(String email, String password) {
        conciseAPI.$(conciseAPI.byCSS("#Email")).sendKeys(email + Keys.ENTER);
        conciseAPI.$(conciseAPI.byCSS("#Passwd")).sendKeys(password + Keys.ENTER);
    }

    public void visit() {
        conciseAPI.open("http://gmail.com");
    }
}
