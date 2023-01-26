package com.ProducerConsumer.demo.AssemblyLine;

public class Task {
    private String id;
    private String color;
    private String[] colors = { "red", "orange", "yellow", "green", "blue", "indigo ", "violet ", "black" };
    private static int colorNum = 0;

    public Task() {
        this.id = new IdGenerator().creatId("task");
        this.color = colors[colorNum];
        colorNum = (colorNum + 1) % 8;
    }

    public String getId() {
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

}
