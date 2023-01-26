package com.ProducerConsumer.demo.AssemblyLine;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue extends Shape {
    // 3 queues 1 for tasks 1 for source machines 1 for destination machines
    Queue<Task> tasks = new LinkedList<>();
    Queue<Machine> sourceMachines = new LinkedList<>();
    Queue<Machine> destinationMachines = new LinkedList<>();

    // constructor calling super one
    MyQueue(double x, double y) {
        super(new IdGenerator().creatId("queue"), x, y);
    }

    // add task to the list of tasks
    public void addTask(Task t) {
        tasks.add(t);
    }

    // add machine to the list of source machines (machines give to that queue)
    public void addSource(Machine m) {
        sourceMachines.add(m);
    }

    // add machine to the list of destination machines (machines receive from queue)
    public void addDestination(Machine m) {
        destinationMachines.add(m);
    }

    // checks if previous queue contains tasks
    // returns true if there are tasks
    public boolean hasTasks() {
        return !tasks.isEmpty();
    }

    // get the task at the top
    public Task geTask() {
        Task next = tasks.peek();
        tasks.remove();
        return next;
    }

}
