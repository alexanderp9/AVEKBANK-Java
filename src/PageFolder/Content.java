package PageFolder;

public class Content {
    private ExecutePage page;

    public void setPage(ExecutePage page) {
        this.page = page;
    }

    public void executepage(){
        page.execute();
    }
}
