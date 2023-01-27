package com.example.producer_consumer.snapShot;

/*
    Memento contains state of an
    object to be restored.
*/
public class Memento {
    private String x;

    public Memento(String x) {
        this.x = x;
    }

    public String getX() {
        return x;
    }
}
