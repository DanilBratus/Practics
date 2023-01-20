package strategy;

class Context {
    private final Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void download(String file) {
        strategy.download(file);
    }
}
