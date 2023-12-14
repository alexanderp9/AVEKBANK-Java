package PageFolder;

public class LogoutPage extends ExecutePageCreator{

    public LogoutPage(Content contentpage) {
        super(contentpage);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
