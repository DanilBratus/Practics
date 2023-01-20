package strategy;

class DLS implements Strategy {
    @Override
    public void download(String file) {
        System.out.println("linux download: " + file);
    }
}
