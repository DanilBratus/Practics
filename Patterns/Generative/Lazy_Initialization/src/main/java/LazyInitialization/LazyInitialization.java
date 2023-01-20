package LazyInitialization;

public class LazyInitialization {
    private Widget myWidget = null;

    public Widget getMyWidget() {
        if (myWidget == null) return myWidget = new Widget();
            return myWidget;
    }
}
