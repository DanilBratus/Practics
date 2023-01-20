package state;

class Context {
    private State state;
    public void setState(State state) {
        this.state = state;
    }
    public void nextOS() {
        state.nextOS(this);
    }
    public void download(String file) {
        this.state.download(this, file);
    }
}
