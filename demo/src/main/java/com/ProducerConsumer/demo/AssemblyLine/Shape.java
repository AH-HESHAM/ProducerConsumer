package com.ProducerConsumer.demo.AssemblyLine;

public abstract class Shape {
    private String id;
    private double x;
    private double y;

    Shape(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}
