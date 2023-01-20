package state;

class DWS implements State {
    @Override
    public void nextOS(Context context) {
        context.setState(new DLS());
    }
    @Override
    public void download(Context context, String file) {
        System.out.println("Windows download: " + file);
    }
}
