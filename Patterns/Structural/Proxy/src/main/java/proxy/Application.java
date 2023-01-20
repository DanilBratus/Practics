package proxy;

import proxy.service.Image;
import proxy.service.ProxyImage;

public class Application {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
        image.display();
    }
}
