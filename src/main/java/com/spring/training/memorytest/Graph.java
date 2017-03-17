package com.spring.training.memorytest;
public class Graph {
    private Point[] points;

    public Graph(Point[] points) {
        super();
        this.points = points;
    }

    @Override
    public String toString() {
        return "Graph [points=" + points.length + "]";
    }
    
    

}