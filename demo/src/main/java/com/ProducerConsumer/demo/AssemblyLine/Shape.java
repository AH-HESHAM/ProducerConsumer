package com.ProducerConsumer.demo.AssemblyLine;

// generalization to the 2 shapes we have
public abstract class Shape {
    private String id;
    private double x;
    private double y;

    Shape(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
