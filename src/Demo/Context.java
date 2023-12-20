package Demo;

public class Context {
    private State pageState;

    public Context() {
        this.pageState = null;
    }

    public State getPageState() {
        return pageState;
    }

    public void setPageState(State pageState) {
        this.pageState = pageState;
    }

    public void refreshState(State pageState){
        setPageState(pageState);
        this.pageState.printState();
    }
}
