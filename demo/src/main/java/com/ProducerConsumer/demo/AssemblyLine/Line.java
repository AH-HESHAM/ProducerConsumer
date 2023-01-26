package com.ProducerConsumer.demo.AssemblyLine;

import java.util.ArrayList;

public class Line {
    private ArrayList<Machine> machines = new ArrayList<>();
    private ArrayList<MyQueue> queues = new ArrayList<>();
    private ArrayList<Task> tasks = new ArrayList<>();
    private Line lineInstance = null;

    public Line getInstance() {
        if (lineInstance != null)
            return lineInstance;
        else {
            lineInstance = new Line();
            return lineInstance;
        }
    }

    private Line() {
    }

    public void addMachine(Machine m) {
        machines.add(m);
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public void addQue(MyQueue q) {
        queues.add(q);
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

}
