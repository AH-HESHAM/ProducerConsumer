package com.ProducerConsumer.demo.AssemblyLine;

public class Task {
    private String id;
    private String color;

    public Task() {
        this.id = new IdGenerator().creatId("task");
        // this.color = rondome different color;
    }

}
