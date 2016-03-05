package pages;

import core.ConciseAPI;
import org.openqa.selenium.By;

import static core.CustomConditions.listNthElementHasText;
import static core.CustomConditions.textsOf;

public class MailsPage {

    ConciseAPI conciseAPI = new ConciseAPI();

    String emails = "[role='main'] .zA";

    public void send(String email, String subject) {
        conciseAPI.$(conciseAPI.byText("COMPOSE")).click();
        conciseAPI.$(By.name("to")).sendKeys(email);
        conciseAPI.$(By.name("subjectbox")).sendKeys(subject);
        conciseAPI.$(conciseAPI.byText("Send")).click();
    }

    public void assertMails(String... subjects) {
        conciseAPI.assertThat(textsOf(conciseAPI.byCSS(emails), subjects));
    }

    public void assertMail(int index, String subject) {
        conciseAPI.assertThat(listNthElementHasText(conciseAPI.byCSS(emails), index, subject));
    }
}
