package com.spring.training.memorytest;
import java.util.ArrayList;
import java.util.List;

public class GraphUtility {
    private List<Graph> graphs=new ArrayList<>();
    
    public void addGraph(Graph g)
    {
        graphs.add(g);
    }
    
    public void removeGraph(Graph g)
    {
        graphs.remove(g);
    }
    
    public void processGraph(Graph g)
    {
        addGraph(g);
        System.out.println("Processing graph "+g);
        
    }

}
