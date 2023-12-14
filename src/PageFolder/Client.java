package PageFolder;

public class Client {
    public static void main(String[] args) {
        Content c = new Content();
        c.setPage(new LoginPage(c));
        c.executepage();
    }
}
