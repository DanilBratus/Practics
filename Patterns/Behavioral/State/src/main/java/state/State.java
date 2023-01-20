package state;

public interface State {
    void nextOS(Context context);
    void download(Context context, String file);
}
