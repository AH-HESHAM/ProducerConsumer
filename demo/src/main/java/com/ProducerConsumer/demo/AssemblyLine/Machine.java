package com.ProducerConsumer.demo.AssemblyLine;

import java.util.Random;

public class Machine extends Shape {
    private String color;
    private boolean ready = true;
    private MyQueue prevQueue;
    private MyQueue nextQueue;
    private int workTime;
    private Task currentTask;

    Machine(double x, double y) {
        super(new IdGenerator().creatId("machine"), x, y);
        this.color = "#ffffff";
        this.workTime = (new Random().nextInt() % 10) * 1000;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setReady() {
        this.ready = !this.ready;
    }

    public boolean getReady() {
        return this.ready;
    }

    public int getWorkTime() {
        return this.workTime;
    }

    // public boolean getPrevQueState() {
    // return prevQueue.Isempty();
    // }

    // public void sendToNextQue() {
    // this.nextQueue.addTask(currentTask);
    // }
}
