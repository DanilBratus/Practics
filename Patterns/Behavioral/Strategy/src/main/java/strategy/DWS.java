package strategy;

class DWS implements Strategy {
    @Override
    public void download(String file) {
        System.out.println("windows download: " + file);
    }
}
