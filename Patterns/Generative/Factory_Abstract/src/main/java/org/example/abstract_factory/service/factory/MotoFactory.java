package org.example.abstract_factory.service.factory;

import org.example.abstract_factory.service.Honda;
import org.example.abstract_factory.service.Yomaha;
import org.example.abstract_factory.service.Moto;

public class MotoFactory extends Factory {
    @Override
    public Moto createMoto(String typeMoto) {
        switch (typeMoto) {
            case "Yomaha": return new Yomaha();
            case "Honda": return new Honda();
            default: return null;
        }
    }
}
