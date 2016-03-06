import org.junit.Test;
import testconfigs.BaseTest;
import testdata.AccountData;

import static core.Helpers.getUniqueText;
import static pages.GmailPage.login;
import static pages.GmailPage.visit;
import static pages.MailsPage.*;
import static pages.MenuPage.*;

public class GmailTest extends BaseTest {

    @Test
    public void testGmailCommonFlow() {

        String subject = getUniqueText("test");

        visit();
        login(AccountData.email, AccountData.password);

        send(AccountData.email, subject);
        refresh();
        //assertMail(0, subject);

        //openSent();
        //assertMail(0, subject);

        //openInbox();
        search(subject);
        assertMails(subject);
    }

}

