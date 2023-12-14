package AccountCollection;
import PageFolder.Content;
import PageFolder.LoginPage;

public class BankDemo {

    public static void main(String[] args) {

        PageFolder.Content c = new Content();
        c.setPage(new LoginPage(c));
        c.executepage();
    }
}
