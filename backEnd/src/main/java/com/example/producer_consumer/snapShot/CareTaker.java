package com.example.producer_consumer.snapShot;

import java.util.HashMap;
import java.util.Map;

public class CareTaker {
    private final Map<String, Memento> saveStorage = new HashMap<String, Memento>();

    public void saveMemento(Memento memento, String saveName) {
        saveStorage.put(saveName, memento);
    }

    public Memento getMemento(String saveName) {
        return saveStorage.get(saveName);
    }

    public void clearSaves() {
        saveStorage.clear();
    }
}
