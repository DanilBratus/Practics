package org.example.adapter;

import org.example.adapter.model.Radio;
import org.example.adapter.service.Adapter;
import org.example.adapter.service.AmericanSocket;
import org.example.adapter.service.EuroSocket;
import org.example.adapter.service.SimpleAmericanSocket;

public class Application {
    public static void main(String[] args) {
// Создание обьекта интерфейса родителя
        AmericanSocket as = new SimpleAmericanSocket();
        Radio radio = new Radio();

        EuroSocket es = new Adapter(as);
        es.getPower();
        radio.linkedMusic(es);
    }
}
