import org.junit.Test;
import pages.GmailPage;
import pages.MailsPage;
import pages.MenuPage;
import testconfigs.BaseTest;
import testdata.AccountData;

import static core.Helpers.getUniqueText;

public class GmailTest extends BaseTest {

    GmailPage gmail = new GmailPage();
    MailsPage mails = new MailsPage();
    MenuPage menu = new MenuPage();

    @Test
    public void testGmailCommonFlow() {

        String subject = getUniqueText("test");

        gmail.visit();
        gmail.login(AccountData.email, AccountData.password);

        mails.send(AccountData.email, subject);
        menu.refresh();
        mails.assertMail(0, subject);

        menu.openSent();
        mails.assertMail(0, subject);

        menu.openInbox();
        menu.search(subject);
        mails.assertMails(subject);
    }

}

