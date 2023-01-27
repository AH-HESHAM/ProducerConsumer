package com.example.producer_consumer.snapShot;

//should implement the save state memento method
public class Originator {
    private String x;
    private String lastUndoSave;
    CareTaker careTaker;

    public Originator(String x, CareTaker careTaker) {
        this.x = x;
        this.careTaker = careTaker;
        createSave("INITIAL");
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void createSave(String saveName) {
        careTaker.saveMemento(new Memento(this.x), saveName);
        lastUndoSave = saveName;
    }

    public void undo() {
        setOriginatorState(lastUndoSave);
    }

    public void undo(String saveName) {
        setOriginatorState(saveName);
    }

    public void undoAll() {
        setOriginatorState("INITIAL");
        careTaker.clearSaves();
    }

    private void setOriginatorState(String saveName) {
        Memento mem = careTaker.getMemento(saveName);
        this.x = mem.getX();
    }

}
