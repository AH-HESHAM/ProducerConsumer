package com.ProducerConsumer.demo.AssemblyLine;

import java.util.ArrayList;

public class Line {
    private ArrayList<Machine> machines = new ArrayList<>();
    private ArrayList<MyQueue> queues = new ArrayList<>();
    private ArrayList<Task> tasks = new ArrayList<>();
    private static Line lineInstance = null;

    // singlton
    public static Line getInstance() {
        if (lineInstance != null)
            return lineInstance;
        else {
            lineInstance = new Line();
            return lineInstance;
        }
    }

    private Line() {
    }

    // add a machine to the list of machines
    public String addMachine(double x, double y) {
        Machine m = new Machine(x, y);
        machines.add(m);
        return m.getId();
    }

    // add a task to the list of tasks
    public String addTask() {
        Task t = new Task();
        tasks.add(t);
        return t.getId();
    }

    // add a queue to the list of queues
    public String addQue(double x, double y) {
        MyQueue q = new MyQueue(x, y);
        queues.add(q);
        return q.getId();
    }

    // befor start simulation add All Tasks To First Que
    public void addAllTasksToFirstQue() {
        for (Task i : tasks)
            queues.get(0).addTask(i);
    }

    // getters
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public ArrayList<Machine> getMachines() {
        return this.machines;
    }

    public ArrayList<MyQueue> getQueues() {
        return this.queues;
    }

}
