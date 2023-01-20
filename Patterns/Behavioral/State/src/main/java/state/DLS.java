package state;

class DLS implements State {
    @Override
    public void nextOS(Context context) {
        context.setState(new DWS());
    }
    @Override
    public void download(Context context, String file) {
        System.out.println("Linux download: " + file);
    }
}
