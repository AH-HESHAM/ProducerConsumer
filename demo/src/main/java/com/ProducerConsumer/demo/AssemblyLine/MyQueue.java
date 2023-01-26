package com.ProducerConsumer.demo.AssemblyLine;

public class MyQueue extends Shape {
    MyQueue(double x, double y) {
        super(new IdGenerator().creatId("queue"), x, y);
    }

}
