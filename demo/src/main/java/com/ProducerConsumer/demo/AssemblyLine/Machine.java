package com.ProducerConsumer.demo.AssemblyLine;

import java.util.Random;

public class Machine extends Shape {
    private String color;
    private boolean ready = true;
    private MyQueue prevQueue;
    private MyQueue nextQueue;
    private int workTime;
    private Task currentTask;

    // constructor calling the super constructor
    // setting default color = white
    // setting random excution time 1~10 seconds(*1000 because wait() takes
    // milli second)
    public Machine(double x, double y) {
        super(new IdGenerator().creatId("machine"), x, y);
        this.color = "#ffffff";
        this.workTime = ((new Random().nextInt() % 10) + 1) * 1000;
    }

    // setters and getters for color and ready
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

    // getter for machine time if needed
    public int getWorkTime() {
        return this.workTime;
    }

    // set surrounding queues
    public void setPrevQue(MyQueue q) {
        this.prevQueue = q;
    }

    public void setNextvQue(MyQueue q) {
        this.nextQueue = q;
    }

    // assign current task to the task at the top of previous task if exists
    public void serveTask() {
        if (prevQueue.hasTasks()) {
            currentTask = prevQueue.geTask();
            setColor(currentTask.getColor());
            // wait(workTime);
        }
    }

    // after finish send the task to next queue
    public void sendToNextQue() {
        this.nextQueue.addTask(currentTask);
        setColor("#ffffff");
    }

}
